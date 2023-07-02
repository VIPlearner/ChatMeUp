package com.android.chatmeup.ui.screens.editprofile.viewmodel

import android.app.Activity
import android.content.Context
import android.net.Uri
import androidx.lifecycle.viewModelScope
import com.android.chatmeup.AppTaskManager
import com.android.chatmeup.data.Result
import com.android.chatmeup.data.db.firebase_db.repository.DatabaseRepository
import com.android.chatmeup.data.db.firebase_db.repository.StorageRepository
import com.android.chatmeup.data.db.room_db.ChatMeUpDatabase
import com.android.chatmeup.data.db.room_db.entity.RoomContact
import com.android.chatmeup.ui.DefaultViewModel
import com.android.chatmeup.ui.cmutoast.CmuToast
import com.android.chatmeup.ui.cmutoast.CmuToastDuration
import com.android.chatmeup.ui.cmutoast.CmuToastStyle
import com.android.chatmeup.util.convertFileToByteArray
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import timber.log.Timber
import java.io.File
import java.io.FileOutputStream
import javax.inject.Inject


enum class EditProfileState{
    INIT,
    LOADING,
    DONE,
    ERROR
}
@HiltViewModel
class EditProfileViewModel @Inject constructor(
    private val chatMeUpDatabase: ChatMeUpDatabase,
    private val appTaskManager: AppTaskManager
) : DefaultViewModel() {
    private val tag = EditProfileViewModel::class.java.simpleName
    private val ioScope = CoroutineScope(Dispatchers.IO + Job())

    private val dbRepository = DatabaseRepository()
    private val storageRepository = StorageRepository()
    private val myUserID = Firebase.auth.currentUser?.uid ?: ""

    private val _eventState = MutableStateFlow(EditProfileState.INIT)
    val eventState = _eventState.asStateFlow()

    private val _isUpdatingProfileImage = MutableStateFlow(false)
    val isUpdatingProfileImage = _isUpdatingProfileImage.asStateFlow()

    val myRoomContact = MutableStateFlow(RoomContact("", "", "", "", "", ""))
    init {
        initialize()
    }

    fun initialize(){
        _eventState.value = EditProfileState.LOADING
        viewModelScope.launch{
            try{
                chatMeUpDatabase.contactDao.getContactFlow(myUserID).collect {
                    Timber.tag(tag).d("Contact $it")
                    myRoomContact.value = it
                    _eventState.value = EditProfileState.DONE
                }
            }
            catch (e: Exception){
                _eventState.value = EditProfileState.ERROR
                Timber.tag(tag).d("Unable to load Contact error: $e")
            }
        }
    }
    fun updateDisplayName(
        displayName: String
    ){
        appTaskManager.addTaskToQueue(AppTaskManager.Task.UpdateDisplayName(displayName))
    }

    fun updateAbout(
        aboutStr: String
    ){
        appTaskManager.addTaskToQueue(AppTaskManager.Task.UpdateDisplayName(aboutStr))
    }

    fun updateProfileImage(
        context: Context,
        activity: Activity?,
        imageUri: Uri
    )= ioScope.launch{
        _isUpdatingProfileImage.value = true
        val imageByteArray = convertFileToByteArray(context, imageUri)
        if (imageByteArray != null) {
            storageRepository.updateUserProfileImage(myUserID, imageByteArray){ result ->
                when(result){
                    is Result.Error -> {
                        CmuToast.createFancyToast(
                            context,
                            activity,
                            "Profile Photo",
                            "Unable to update Profile Photo",
                            CmuToastStyle.ERROR,
                            CmuToastDuration.SHORT
                        )
                        _isUpdatingProfileImage.value = false
                    }
                    Result.Loading -> {
                        _isUpdatingProfileImage.value = true
                    }
                    is Result.Progress -> {}
                    is Result.Success -> {
                        _isUpdatingProfileImage.value = false
                        Timber.tag(tag).d("Upload Done")
                        //update local Storage
                        val file = File(context.filesDir,"profile_photos/my_profile.png")
                        if (!file.parentFile?.exists()!!)
                            file.parentFile?.mkdirs()
                        if(file.exists()){
                            file.delete()
                        }
                        file.createNewFile()
                        val fos = FileOutputStream(file)
                        fos.write(imageByteArray)
                        fos.close()
                        //update database
                        dbRepository.updateUserProfileImageUrl(myUserID, result.data.toString())
                    }
                }
            }
        }
    }
}