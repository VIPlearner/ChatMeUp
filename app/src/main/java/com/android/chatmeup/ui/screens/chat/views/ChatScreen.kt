package com.android.chatmeup.ui.screens.chat.views

import android.Manifest
import android.app.Activity
import android.content.ContentValues
import android.content.Context
import android.net.Uri
import android.os.Build
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.annotation.RequiresApi
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.combinedClickable
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.selection.TextSelectionColors
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.ModalBottomSheetLayout
import androidx.compose.material.ModalBottomSheetState
import androidx.compose.material.ModalBottomSheetValue
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowBackIosNew
import androidx.compose.material.rememberModalBottomSheetState
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.core.content.FileProvider
import com.android.chatmeup.AppTaskManager
import com.android.chatmeup.R
import com.android.chatmeup.data.DownloadState
import com.android.chatmeup.data.db.room_db.data.MessageType
import com.android.chatmeup.data.db.room_db.entity.RoomContact
import com.android.chatmeup.data.db.room_db.entity.RoomMessage
import com.android.chatmeup.ui.cmutoast.CmuToast
import com.android.chatmeup.ui.cmutoast.CmuToastDuration
import com.android.chatmeup.ui.cmutoast.CmuToastStyle
import com.android.chatmeup.ui.screens.chat.data.ChatState
import com.android.chatmeup.ui.screens.chat.viewmodel.ChatViewModel
import com.android.chatmeup.ui.screens.chat.viewmodel.chatViewModelProvider
import com.android.chatmeup.ui.screens.components.CmuOutlinedTextField
import com.android.chatmeup.ui.screens.components.ImagePage
import com.android.chatmeup.ui.screens.components.ProfilePicture
import com.android.chatmeup.ui.screens.components.TextImage
import com.android.chatmeup.ui.screens.components.UploadFileOptionDialog
import com.android.chatmeup.ui.screens.components.UploadImageScreen
import com.android.chatmeup.ui.theme.md_theme_dark_background
import com.android.chatmeup.ui.theme.md_theme_light_background
import com.android.chatmeup.ui.theme.neutral_disabled
import com.android.chatmeup.ui.theme.seed
import com.android.chatmeup.util.createTempImageFile
import com.android.chatmeup.util.epochToDayMonthYear
import com.android.chatmeup.util.epochToHoursAndMinutes
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.launch
import timber.log.Timber
import java.io.File
import java.util.Date

@OptIn(ExperimentalMaterialApi::class)
@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun ChatScreen(
    context: Context,
    activity: Activity?,
    factory: ChatViewModel.Factory,
    chatId: String,
    userId: String,
    otherUserId: String,
    onBackClicked: () -> Unit,
    noOfUnreadMessages: String
) {
    val myUserID = Firebase.auth.uid
    if(myUserID == null) {
        onBackClicked()
        return
    }
    val systemUiController = rememberSystemUiController()
    val viewModel = chatViewModelProvider(
        chatId = chatId,
        myUserId = myUserID,
        otherUserId = otherUserId,
        factory = factory
    )
    val chatInfo by viewModel.chatInfo.observeAsState()
//    val otherUserInfo by viewModel.otherUser.observeAsState()

    val viewState by viewModel.viewState.collectAsState()

    val newMessageText by viewModel.newMessageText.collectAsState()

    val chatMediaListMap by viewModel.chatMediaListMap.collectAsState()

    val lazyListState by viewModel.lazyListState.collectAsState()

    val modalBottomSheetState =
        rememberModalBottomSheetState(
            initialValue = ModalBottomSheetValue.Hidden,
            confirmValueChange = {it != ModalBottomSheetValue.HalfExpanded},
            skipHalfExpanded = true
        )

    var newPhotoURI: Uri? by rememberSaveable {
        mutableStateOf(null)
    }

    var chatState by rememberSaveable {
        mutableStateOf(ChatState.CHAT)
    }

    val scope = rememberCoroutineScope()

    var currentBottomScreen:ChatBottomSheetScreen by remember {
        mutableStateOf(ChatBottomSheetScreen.UploadFileOptionDialog)
    }

    val isDarkTheme = isSystemInDarkTheme()

    val cameraLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.TakePicture(),
    ) { success ->
        if (success) {
            // Retrieve the captured image URI from the camera
//            photoURI = newPhotoURI
            scope.launch{ modalBottomSheetState.hide() }
            chatState = ChatState.UPLOAD_IMAGE
        }
    }

    val storageLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.GetContent()
    ) { uri: Uri? ->
        if (uri == null) {
            CmuToast.createFancyToast(
                context = context,
                activity = activity,
                title = "Image Upload",
                message = "You did not select any Image",
                style = CmuToastStyle.WARNING,
                duration = CmuToastDuration.SHORT
            )
        } else {
            newPhotoURI = uri
            Timber.tag(ContentValues.TAG).d("Photo URI: $newPhotoURI")
            scope.launch{ modalBottomSheetState.hide() }
            chatState = ChatState.UPLOAD_IMAGE
        }
    }

    val requestCameraPermissionLauncher = rememberLauncherForActivityResult(
        ActivityResultContracts.RequestPermission()
    ) { isGranted ->
        if (isGranted) {
            // Permission granted, launch the camera
//            if (newPhotoURI != null && Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
//                context.contentResolver.delete(newPhotoURI!!, null)
//            }
            newPhotoURI = FileProvider.getUriForFile(
                context,
                context.applicationContext.packageName + ".provider",
                createTempImageFile(context)
            )
            cameraLauncher.launch(newPhotoURI)
        } else {
            // Permission denied, show an error message
            CmuToast.createFancyToast(context, activity = activity, "Camera","Permission denied", CmuToastStyle.ERROR, CmuToastDuration.SHORT)
        }
    }

    val requestStoragePermissionLauncher = rememberLauncherForActivityResult(
        ActivityResultContracts.RequestPermission()
    ) { isGranted ->
        if (isGranted) {

            storageLauncher.launch("image/*")
        } else {
            // Permission denied, show an error message
            CmuToast.createFancyToast(context, activity = activity, "Storage","Permission denied", CmuToastStyle.ERROR, CmuToastDuration.SHORT)
        }
    }

    LaunchedEffect(viewState.roomMessageList.size){
        if(lazyListState.layoutInfo.totalItemsCount > noOfUnreadMessages.toInt()+1) {
            lazyListState.scrollToItem(
                lazyListState.layoutInfo.totalItemsCount - 1 - noOfUnreadMessages.toInt()
            )
        }
    }

    LaunchedEffect(modalBottomSheetState.isVisible){
        if(!(modalBottomSheetState.isVisible && currentBottomScreen is ChatBottomSheetScreen.LoadImagePage)){
            systemUiController.setSystemBarsColor(
                color = if (isDarkTheme) md_theme_dark_background else md_theme_light_background,
                darkIcons = !isDarkTheme
            )
        }
        else{
            systemUiController.setSystemBarsColor(Color.Black, darkIcons = false)
        }
    }
    when(chatState){
        ChatState.CHAT -> {
            ChatListScreen(
                onTakePicture = { requestCameraPermissionLauncher.launch(Manifest.permission.CAMERA) },
                onUploadFromStorageClicked = { requestStoragePermissionLauncher.launch(
                    if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) Manifest.permission.READ_MEDIA_IMAGES else Manifest.permission.READ_EXTERNAL_STORAGE
                ) },
                otherUserRoomContact = viewState.roomContact,
                onBackClicked = onBackClicked,
                newMessageText = newMessageText,
                viewModel = viewModel,
                roomMessageList = viewState.roomMessageList,
                lazyListState = lazyListState,
                userId = userId,
                otherUser = viewState.roomContact,
                modalBottomSheetState = modalBottomSheetState,
                onAddItemClicked = {
                    scope.launch {
                        modalBottomSheetState.show()
                    }
                },
                chatMediaListMap = chatMediaListMap,
                newPhotoUri = newPhotoURI,
                context = context,
                activity = activity,
                onDeleteMessage = {
                    viewModel.appTaskManager.addTaskToQueue(
                        AppTaskManager.Task.DeleteMessage(otherUserId,it)
                    )
                },
                onCloseImagePage = {
                    systemUiController.setSystemBarsColor(
                        color = if (isDarkTheme) md_theme_dark_background else md_theme_light_background,
                        darkIcons = !isDarkTheme
                    )
                    scope.launch{
                        modalBottomSheetState.hide()
                    }
                },
                currentBottomScreen = currentBottomScreen,
                onClickViewImage = {
                    currentBottomScreen = ChatBottomSheetScreen.LoadImagePage(it)
                    systemUiController.setSystemBarsColor(
                        Color.Black,
                        darkIcons = false
                    )
                    scope.launch {
                        modalBottomSheetState.show()
                    }
                }
            )
        }
        ChatState.UPLOAD_IMAGE -> {
            systemUiController.setSystemBarsColor(Color.Black, darkIcons = false)
            newPhotoURI?.let {
                UploadImageScreen(
                    imageUri = it,
                    onUploadCancelled = {
                        chatState = ChatState.CHAT
                    },
                    messageText = newMessageText,
                    onValueChanged = {value ->
                        viewModel.newMessageText.value = value
                    },
                    onSendMessage = {
                        chatState = ChatState.CHAT
                        newPhotoURI?.let { uri ->
                            viewModel.sendMessagePressed(
                                context = context,
                                activity = activity,
                                newPhotoURI = uri,
                                messageText = newMessageText.trim()
                            )
                        } ?: CmuToast.createFancyToast(
                            context = context,
                            activity = activity,
                            "Error",
                            "Unable to upload Image. Please try again",
                            CmuToastStyle.ERROR,
                            CmuToastDuration.SHORT
                        )
                    }

                )
            } ?: {
                CmuToast.createFancyToast(
                    context = context,
                    activity = activity,
                    "Error",
                    "Unable to upload Image. Please try again",
                    CmuToastStyle.ERROR,
                    CmuToastDuration.SHORT
                )
                chatState = ChatState.CHAT
            }
        }
    }



}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun ChatListScreen(
    onTakePicture: () -> Unit,
    onUploadFromStorageClicked: () -> Unit,
    otherUserRoomContact: RoomContact,
    onBackClicked: () -> Unit,
    newMessageText: String,
    viewModel: ChatViewModel,
    otherUser: RoomContact,
    roomMessageList: List<RoomMessage>,
    lazyListState: LazyListState,
    userId: String,
    modalBottomSheetState: ModalBottomSheetState,
    onAddItemClicked: () -> Unit,
    currentBottomScreen: ChatBottomSheetScreen,
    newPhotoUri: Uri?,
    context: Context,
    activity: Activity?,
    chatMediaListMap: HashMap<String, DownloadState>,
    onDeleteMessage: (RoomMessage) -> Unit,
    onClickViewImage: (Uri) -> Unit,
    onCloseImagePage: () -> Unit
){
    val scope = rememberCoroutineScope()
    ModalBottomSheetLayout(
        sheetState = modalBottomSheetState,
        sheetBackgroundColor = MaterialTheme.colorScheme.background,
        sheetShape = if(currentBottomScreen !is ChatBottomSheetScreen.LoadImagePage)RoundedCornerShape(topStart = 20.dp, topEnd = 20.dp)else RectangleShape,
        sheetContent = {
            when(currentBottomScreen){
                is ChatBottomSheetScreen.LoadImagePage -> {
                    val uri = currentBottomScreen
                    ImagePage(title = otherUser.displayName, imageObj = currentBottomScreen.imageUri) {
                        onCloseImagePage()
                    }
                }
                ChatBottomSheetScreen.UploadFileOptionDialog -> {
                    UploadFileOptionDialog(
                        title = "Upload Media",
                        onTakePictureClicked = onTakePicture,
                        onUploadFromStorageClicked = onUploadFromStorageClicked
                    )
                }
            }

        }
        ){
        Scaffold(
            topBar = {
                ChatTopBar(
                    context = context,
                    otherUserRoomContact = otherUserRoomContact,
                    onBackClicked = onBackClicked
                )
            },
            bottomBar = {
                ChatBottomBar(
                    messageText = newMessageText,
                    viewModel = viewModel,
                    onAddItemClicked = onAddItemClicked,
                    onSendMessagePressed = {
                        scope.launch {
                            modalBottomSheetState.hide()
                        }
                        viewModel.sendMessagePressed(context,
                        activity, null, newMessageText.trim())
                    }
                )
            }
        ) { paddingValues ->
            Surface(
                modifier = Modifier.fillMaxSize(),
                color = MaterialTheme.colorScheme.tertiaryContainer
            ) {
                if (!roomMessageList.isNullOrEmpty()) {
                    LazyColumn(
                        state = lazyListState,
                        verticalArrangement = Arrangement.Bottom,
                        modifier = Modifier.padding(paddingValues)
                    ) {
                        repeat(roomMessageList.size ?: 0) {
                            item {
                                MessageItem(
                                    context = context,
                                    activity = activity,
                                    viewModel = viewModel,
                                    myUserId = userId,
                                    roomMessage = roomMessageList[it],
                                    downloadState = if(roomMessageList[it].messageType == MessageType.TEXT_IMAGE.toString())
                                        chatMediaListMap[roomMessageList[it].messageID]
                                    else DownloadState.NotDownloaded,
                                    onDeleteMessage = onDeleteMessage,
                                    onClickViewImage = onClickViewImage
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun MessageItem(
    context: Context,
    activity: Activity?,
    viewModel: ChatViewModel,
    myUserId: String,
    roomMessage: RoomMessage,
    downloadState: DownloadState?,
    onDeleteMessage: (RoomMessage) -> Unit,
    onClickViewImage: (Uri) -> Unit
){
    val isSender = myUserId == roomMessage.senderID
    val canDeleteMessage = (Date().time - roomMessage.messageTime)<86400000L //if message has lasted for 24 hours
    val onClick = {
        when (downloadState) {
            DownloadState.Downloaded -> {
                roomMessage.localFilePath?.let{
                    onClickViewImage(
                        Uri.fromFile(
                            File(context.filesDir, it)
                        )
                    )
                }
            }

            is DownloadState.Downloading -> {
                //do nothing
            }

            DownloadState.NotDownloaded -> {
                roomMessage.serverFilePath?.let {
                    viewModel.loadImage(context, activity,
                        it, roomMessage.messageID)
                }
            }

            DownloadState.OnQueue -> {
                //do nothing
            }

            else -> {//do nothing
            }
        }
    }
    Box{
        var optionsExpanded by remember {
            mutableStateOf(false)
        }
        val onDismissRequest = { optionsExpanded = false }
        DropdownMenu(
            expanded = if(canDeleteMessage)optionsExpanded else false,
            onDismissRequest = onDismissRequest,
        ) {
            DropdownMenuItem(
                text = { Text(text = "Delete Message") },
                onClick = {
                    onDeleteMessage(roomMessage)
                    onDismissRequest()
                }
            )
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 10.dp, end = 10.dp, top = 5.dp, bottom = 5.dp)
                .combinedClickable(
                    onClick = {
                    },
                    onLongClick = { optionsExpanded = true }
                )
            ,
            horizontalArrangement = if (isSender) Arrangement.End else Arrangement.Start
        ) {
            Card(
                shape = RoundedCornerShape(
                    topStart = 15.dp,
                    topEnd = 15.dp,
                    bottomStart = if (isSender) 15.dp else 0.dp,
                    bottomEnd = if (isSender) 0.dp else 15.dp
                ),
                modifier = Modifier
                    .padding(
                        start = if (isSender) 70.dp else 0.dp,
                        end = if (!isSender) 70.dp else 0.dp
                    ),
                colors = CardDefaults.cardColors(
                    containerColor = if (isSender) seed else MaterialTheme.colorScheme.background
                ),
            ) {
                Column(
//                modifier = Modifier.padding(10.dp),
                    horizontalAlignment = if (isSender) Alignment.End else Alignment.Start
                ) {
                    if (roomMessage.messageType == MessageType.TEXT_IMAGE.toString()) {
                        downloadState?.let {
                            TextImage(
                                modifier = Modifier.padding(5.dp),
                                context = context,
                                roomMessage = roomMessage,
                                downloadState = it,
                            ) {
                                onClick()
                            }
                        }
                    }
                    if (roomMessage.messageText.isNotBlank()) {
                        Spacer(modifier = Modifier.height(5.dp))
                        Text(
                            text = roomMessage.messageText,
                            modifier = Modifier
                                .align(Alignment.Start)
                                .padding(horizontal = 10.dp),
                            style = MaterialTheme.typography.bodyLarge,
                            textAlign = TextAlign.Left,
                            color = if (isSender) Color.White else MaterialTheme.colorScheme.onBackground
                        )
                    }
                    Text(
                        text = "${epochToHoursAndMinutes(roomMessage.messageTime)}•${epochToDayMonthYear(roomMessage.messageTime)}",
                        modifier = Modifier.padding(horizontal = 10.dp),
                        color = neutral_disabled,
                        style = MaterialTheme.typography.labelSmall
                    )
                    Spacer(modifier = Modifier.height(5.dp))
                }
            }
        }
    }
}

@Composable
fun ChatTopBar(
    context: Context,
    otherUserRoomContact: RoomContact,
    onBackClicked: () -> Unit,
){
    Surface(
        modifier = Modifier.fillMaxWidth(),
        color = MaterialTheme.colorScheme.background
    ){
        Row(
            modifier = Modifier.padding(bottom = 5.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            IconButton(onClick = { onBackClicked() }) {
                Icon(
                    Icons.Default.ArrowBackIosNew,
                    "Back button"
                )
            }
            ProfilePicture(
                imageObj = File(context.filesDir, otherUserRoomContact.localProfilePhotoPath),
                size = 40.dp,
                isOnline = otherUserRoomContact.isOnline
            )
            
            Spacer(modifier = Modifier.width(20.dp))

            otherUserRoomContact.displayName.let {
                Text(
                    text = it,
                    style = MaterialTheme.typography.titleLarge
                )
            }
        }
    }
}

@Composable
fun ChatBottomBar(
    messageText: String,
    viewModel: ChatViewModel,
    onAddItemClicked: () -> Unit,
    onSendMessagePressed: () -> Unit,
) {
    Surface(color = MaterialTheme.colorScheme.background, modifier = Modifier.wrapContentSize()) {
        Row(
            modifier = Modifier.padding(top = 6.dp, bottom = 12.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            IconButton(onClick = { onAddItemClicked() }) {
                Icon(
                    modifier = Modifier.size(25.dp),
                    imageVector = Icons.Default.Add,
                    contentDescription = "Send Message button"
                )
            }

            var isSingleLine by remember {
                mutableStateOf(false)
            }
            var maxLines by remember {
                mutableStateOf(1)
            }
            CmuOutlinedTextField(
                value = messageText,
                onValueChange = {
                    viewModel.newMessageText.value = it
                },
//                    .height(40.dp),
                modifier = Modifier
                    .weight(1f)
                    .heightIn(min = 40.dp, max = 100.dp),
                placeholder = {
                    Text(
                        text = "Message",
                        color = neutral_disabled,
                        style = MaterialTheme.typography.bodyLarge,
                        modifier = Modifier
                            .fillMaxWidth()
                            .align(Alignment.CenterVertically)
                    ) },
                singleLine = isSingleLine,
                maxLines = 3,
                shape = RoundedCornerShape(10.dp),
                colors = OutlinedTextFieldDefaults.colors(
                    focusedBorderColor = Color.Transparent,
                    unfocusedBorderColor = Color.Transparent,
                    focusedContainerColor = MaterialTheme.colorScheme.tertiaryContainer,
                    unfocusedContainerColor = MaterialTheme.colorScheme.tertiaryContainer,
                    selectionColors = TextSelectionColors(
                        backgroundColor = neutral_disabled,
                        handleColor = MaterialTheme.colorScheme.primaryContainer
                    )
                ),
            )

            IconButton(onClick = {
                onSendMessagePressed()
            }) {
                Icon(
                    modifier = Modifier.size(24.dp),
                    imageVector = ImageVector.Companion.vectorResource(id = R.drawable.ic_send_button),
                    contentDescription = "Send Message button",
                    tint = seed
                )
            }
        }
    }
}

sealed class ChatBottomSheetScreen {
    object UploadFileOptionDialog: ChatBottomSheetScreen()
    data class LoadImagePage(
        val imageUri: Uri
    ): ChatBottomSheetScreen()
}