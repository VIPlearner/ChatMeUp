package com.android.chatmeup.data.db.firebase_db.repository

import android.content.Context
import android.net.Uri
import com.android.chatmeup.data.Result
import com.android.chatmeup.data.db.firebase_db.remote.FirebaseStorageSource
import com.google.firebase.storage.StorageException
import timber.log.Timber
import java.io.File


class StorageRepository {
    private val firebaseStorageService = FirebaseStorageSource()

    fun updateUserProfileImage(userID: String, byteArray: ByteArray, b: (Result<Uri>) -> Unit) {
        b.invoke(Result.Loading)
        firebaseStorageService.uploadUserImage(userID, byteArray).addOnSuccessListener {
            b.invoke((Result.Success(it)))
        }.addOnFailureListener {
            b.invoke(Result.Error(it.message))
        }
    }

    fun uploadChatImage(chatID: String, byteArray: ByteArray, b: (Result<Uri>) -> Unit) {
        b.invoke(Result.Loading)
        firebaseStorageService.uploadChatImage(chatID, byteArray).addOnSuccessListener {
            b.invoke((Result.Success(it)))
        }.addOnFailureListener {
            b.invoke(Result.Error(it.message))
        }
    }

    fun uploadFile(path: String, uri: Uri, b: (Result<Uri>) -> Unit) {
        b.invoke(Result.Loading)
        firebaseStorageService.uploadFile(path, uri).addOnSuccessListener {
            b.invoke((Result.Success(it)))
        }.addOnFailureListener {
            b.invoke(Result.Error(it.message))
        }
    }

    fun uploadChatThumbnail(chatID: String, byteArray: ByteArray, b: (Result<Uri>) -> Unit) {
        b.invoke(Result.Loading)
        firebaseStorageService.uploadChatThumbnail(chatID, byteArray).addOnSuccessListener {
            b.invoke((Result.Success(it)))
        }.addOnFailureListener {
            b.invoke(Result.Error(it.message))
        }
    }

    fun downloadChatImage(url: String, file: File, b: (Result<Nothing>) -> Unit) {
        b.invoke(Result.Loading)
        firebaseStorageService.downloadChatImage(url = url, file = file).addOnSuccessListener {
            b.invoke(Result.Success())
        }.addOnFailureListener{
            b.invoke(Result.Error(it.message))
        }.addOnProgressListener {taskSnapshot ->
            b.invoke(
                Result.Progress(
                    (100.0 * taskSnapshot.bytesTransferred) / taskSnapshot.totalByteCount
                )
            )
            Timber.tag("StorageRepo").d("Download File Size is ${taskSnapshot.totalByteCount}")
        }
    }

    fun downloadChatThumbnail(context: Context,url: String, path: String, b: (Result<Nothing>) -> Unit) {
        b.invoke(Result.Loading)
        firebaseStorageService.downloadChatThumbnail(context = context, url = url, path = path).addOnSuccessListener {
            b.invoke(Result.Success())
        }.addOnFailureListener{exception ->
            if (exception is StorageException && exception.errorCode == StorageException.ERROR_OBJECT_NOT_FOUND
            ) {
                //This is in a case where the profile does not have a profile image it should still return successful
                b.invoke(Result.Success())
                File(context.filesDir, path).delete()
                return@addOnFailureListener
            }
            b.invoke(Result.Error(exception.message))
        }.addOnProgressListener {taskSnapshot ->
            b.invoke(
                Result.Progress(
                    (100.0 * taskSnapshot.bytesTransferred) / taskSnapshot.totalByteCount
                )
            )
        }
    }

    fun downloadImage(url: String, context:Context, path:String, b: (Result<Nothing>) -> Unit) {
        b.invoke(Result.Loading)
        if(url.isBlank() || url.isEmpty()) {
            b.invoke(Result.Error(msg = "Url is Empty"))
        }
        firebaseStorageService.downloadImage(url = url, context = context, path = path).addOnSuccessListener {
            b.invoke(Result.Success())
        }.addOnFailureListener{ exception ->
            if (exception is StorageException && exception.errorCode == StorageException.ERROR_OBJECT_NOT_FOUND
            ) {
                //This is in a case where the profile does not have a profile image it should still return successful
                b.invoke(Result.Success())
                File(context.filesDir, path).delete()
                return@addOnFailureListener
            }
            b.invoke(Result.Error(exception.message))
        }.addOnProgressListener {taskSnapshot ->
            b.invoke(
                Result.Progress(
                    (100.0 * taskSnapshot.bytesTransferred) / taskSnapshot.totalByteCount
                )
            )
        }
    }

}