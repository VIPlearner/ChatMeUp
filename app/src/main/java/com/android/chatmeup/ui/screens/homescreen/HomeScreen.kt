package com.android.chatmeup.ui.screens.homescreen

import android.app.Activity
import android.content.Context
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.animation.*
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.ModalBottomSheetLayout
import androidx.compose.material.ModalBottomSheetValue
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForwardIos
import androidx.compose.material.icons.filled.Logout
import androidx.compose.material.icons.filled.NotificationsActive
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material.rememberModalBottomSheetState
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImagePainter
import coil.compose.rememberAsyncImagePainter
import com.android.chatmeup.AppTaskManager
import com.android.chatmeup.R
import com.android.chatmeup.data.db.firebase_db.entity.UserInfo
import com.android.chatmeup.data.db.room_db.entity.RoomChat
import com.android.chatmeup.data.db.room_db.entity.RoomContact
import com.android.chatmeup.ui.screens.components.ProfilePicture
import com.android.chatmeup.ui.screens.homescreen.components.BottomSheetScreen
import com.android.chatmeup.ui.screens.homescreen.components.ChatListItem
import com.android.chatmeup.ui.screens.homescreen.components.HomeBottomBar
import com.android.chatmeup.ui.screens.homescreen.components.HomeTopBar
import com.android.chatmeup.ui.screens.homescreen.components.SheetLayout
import com.android.chatmeup.ui.screens.homescreen.viewmodel.HomeViewModel
import com.android.chatmeup.ui.screens.homescreen.viewmodel.homeViewModelProvider
import com.android.chatmeup.ui.theme.md_theme_dark_background
import com.android.chatmeup.ui.theme.md_theme_light_background
import com.android.chatmeup.ui.theme.neutral_disabled
import com.google.accompanist.pager.*
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.launch
import java.io.File

@RequiresApi(Build.VERSION_CODES.O)
@OptIn(ExperimentalPagerApi::class, ExperimentalMaterialApi::class, ExperimentalComposeUiApi::class)
@Composable
fun HomeScreen(
    context: Context,
    activity: Activity?,
    factory: HomeViewModel.Factory,
    onNavigateToChat: (String) -> Unit,
    onNavigateToLogin: () -> Unit,
    onNavigateToEditProfile: () -> Unit,
    onNavigateToSettings: () -> Unit,
){
    val systemUiController = rememberSystemUiController()
    //change status bar color anytime we change light mode or dark mode
    val myUserID = Firebase.auth.uid
    if(myUserID == null) {
        onNavigateToLogin()
        return
    }
    val viewModel: HomeViewModel = homeViewModelProvider(
        factory = factory,
        myUserID = myUserID,
    )

    val viewState by viewModel.viewState.collectAsState()

    val notificationsList by viewModel.notificationListWithUserInfo.observeAsState()

    val addContactEventState by viewModel.addContactEventState.collectAsState()

    var searchText by rememberSaveable { mutableStateOf("") }

    var selectedImageTitle by rememberSaveable { mutableStateOf("Profile Picture") }

    var selectedImageFile by rememberSaveable { mutableStateOf(File(context.filesDir, "")) }

    val pagerState = rememberPagerState(0)

    val scope = rememberCoroutineScope()

    val modalBottomSheetState =
        rememberModalBottomSheetState(initialValue = ModalBottomSheetValue.Hidden,
            skipHalfExpanded = true
        )

    var currentBottomSheet: BottomSheetScreen by remember{
        mutableStateOf(BottomSheetScreen.AddContact)
    }

    var newContactEmail by remember {
        mutableStateOf("")
    }

    val isDarkTheme = isSystemInDarkTheme()

    LaunchedEffect(modalBottomSheetState.isVisible){
        if(!(modalBottomSheetState.isVisible && currentBottomSheet == BottomSheetScreen.ProfileImage)){
            systemUiController.setSystemBarsColor(
                color = if (isDarkTheme) md_theme_dark_background else md_theme_light_background,
                darkIcons = !isDarkTheme
            )
        }
        else{
            systemUiController.setSystemBarsColor(Color.Black, darkIcons = false)
        }
    }

    LaunchedEffect(notificationsList){
        if(notificationsList.isNullOrEmpty()){
            scope.launch{ modalBottomSheetState.hide() }
        }
    }

    LaunchedEffect(viewState){
        viewState.chatsList.forEach {
            val file = File(context.filesDir, it.profilePhotoPath)
            if(it.onlineProfilePhotoPath.isNotBlank() && (!file.exists() || file.length() <= 0 || !file.isFile)){
                viewModel.appTaskManager.addDownloadTask(
                    context,
                    AppTaskManager.DownloadTask(
                        it.onlineProfilePhotoPath,
                        it.profilePhotoPath,
                        shouldRetry = true,
                        onDone = {
                        }
                    )
                )
            }
        }
    }

    ModalBottomSheetLayout(
        sheetState = modalBottomSheetState,
        sheetBackgroundColor = MaterialTheme.colorScheme.background,
        sheetShape = if(currentBottomSheet != BottomSheetScreen.ProfileImage)RoundedCornerShape(topStart = 20.dp, topEnd = 20.dp) else RectangleShape,
        sheetContent = {
            SheetLayout(
                currentScreen = currentBottomSheet,
                context = context,
                activity = activity,
                notificationsList = notificationsList as List<UserInfo>?,
                viewModel = viewModel,
                onAddContactClicked =
                {
                    viewModel.onAddContactEventTriggered(
                        event = HomeViewModel.AddContactEvents.Loading,
                        context = context,
                        activity = activity,
                        email = newContactEmail,
                    )
                },
                newContactEmail = newContactEmail,
                onNewContactEmailChanged = {newContactEmail= it},
                addContactEventState = addContactEventState,
                selectedImageTitle = selectedImageTitle,
                selectedImageUri = selectedImageFile,
                onCloseImage = {
                    systemUiController.setSystemBarsColor(
                        color = if (isDarkTheme) md_theme_dark_background else md_theme_light_background,
                        darkIcons = !isDarkTheme
                    )
                    scope.launch{
                        modalBottomSheetState.hide()
                    }
                },
                onConfirmLogout = {
                    onNavigateToLogin()
                    viewModel.logout(context = context)
                },
                onDismissLogout = {
                    scope.launch {
                        modalBottomSheetState.hide()
                    }
                }
            )
        }
    ){
        val keyboardController = LocalSoftwareKeyboardController.current
        if(!modalBottomSheetState.isVisible){
            keyboardController?.hide()
        }
        Scaffold(
            modifier = Modifier.fillMaxSize(),
            topBar = {
                when (pagerState.currentPage) {
//                    0 ->
//                        HomeTopBar(
//                            Modifier,
//                            "Contacts",
//                            {
//                                IconButton(onClick = {
//                                    Firebase.auth.signOut()
//                                    onNavigateToLogin()
//                                }) {
//                                    Icon(
//                                        modifier = Modifier.size(20.dp),
//                                        imageVector = Icons.Filled.Add,
//                                        contentDescription = "icon.name",
//                                    )
//                                }
//                            }
//                        )

                    0 ->
                        HomeTopBar(
                            Modifier,
                            "Chats",
                            {
                                IconButton(
                                    onClick = {
                                        currentBottomSheet = BottomSheetScreen.AddContact
                                        scope.launch {
                                            modalBottomSheetState.show()
                                        }
                                    }
                                ) {
                                    Icon(
                                        modifier = Modifier.size(20.dp),
                                        imageVector = ImageVector.vectorResource(id = R.drawable.ic_new_chat),
                                        contentDescription = "icon.name",
                                    )
                                }
                            },
                            {
                                if (!notificationsList.isNullOrEmpty()){
                                    IconButton(
                                        onClick = {
                                            currentBottomSheet = BottomSheetScreen.RequestsList
                                            scope.launch {
                                                modalBottomSheetState.show()
                                            }
                                        }
                                    ) {
                                        Icon(
                                            modifier = Modifier.size(20.dp),
                                            imageVector = Icons.Default.NotificationsActive,
                                            contentDescription = "icon.name",
                                        )
                                    }
                                }
                            }
                        )

                    1 ->
                        HomeTopBar(
                            Modifier,
                            "More",
                        )
                }
            },
            bottomBar = {
                HomeBottomBar(
                    pagerState = pagerState,
                    scope = scope
                )
            },
            containerColor = MaterialTheme.colorScheme.background
        ) {
            HorizontalPager(
                modifier = Modifier.fillMaxSize(),
                state = pagerState,
                count = 2
            ) { page ->
                when (page) {
//                    0 -> Text(text = "Contacts")
                    0 -> ChatsScreen(
                        modifier = Modifier.padding(it),
                        context = context,
                        searchTextValue = searchText,
                        onSearchTextValueChanged = { searchText = it },
                        onProfileImageClicked = { localPhotoPath, displayName ->
                            selectedImageTitle = displayName
                            selectedImageFile = File(context.filesDir, localPhotoPath)
                            if(selectedImageFile.exists()){
                                currentBottomSheet = BottomSheetScreen.ProfileImage
                                systemUiController.setSystemBarsColor(
                                    Color.Black,
                                    darkIcons = false
                                )
                                scope.launch {
                                    modalBottomSheetState.show()
                                }
                            }
                        },
                        list = viewState.chatsList,
                        myUserId = viewModel.myUserId,
                        onNavigateToChat = onNavigateToChat,
                        onDeleteChat =
                        {chatID, userID ->
                            viewModel.appTaskManager.addTaskToQueue(
                                AppTaskManager.Task.DeleteChatUsingChatID(chatID)
                            )
                            viewModel.appTaskManager.addTaskToQueue(
                                AppTaskManager.Task.DeleteContactUsingUserID(userID)
                            )
                        },
                    )

                    1 -> MoreScreen(
                        modifier = Modifier.padding(it),
                        context = context,
                        myContact = viewState.myContact,
                        onSignOutClicked = {
                            currentBottomSheet = BottomSheetScreen.ConfirmInfo("Please note that if you logout All your information will be deleted from this device. Will you still like to logout?")
                            scope.launch {
                                modalBottomSheetState.show()
                            }
                        },
                        onNavigateToEditProfile = onNavigateToEditProfile
                    )
                }
            }

        }
    }
}

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun ChatsScreen(
    modifier: Modifier = Modifier,
    context: Context,
    searchTextValue: String,
    onSearchTextValueChanged: (String) -> Unit,
    onProfileImageClicked: (String, String) -> Unit,
    list: List<RoomChat>,
    myUserId: String,
    onNavigateToChat: (String) -> Unit,
    onDeleteChat: (String, String) -> Unit
){
    Surface(
        modifier = modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        Column() {
//            CmuSearchTextField(
//                searchTextValue = searchTextValue,
//                onSearchTextValueChanged = onSearchTextValueChanged,
//            )
//            Spacer(modifier = Modifier.height(10.dp))
            if(list.isNotEmpty()){
                ChatList(
                    list = list,
                    context = context,
                    myUserId = myUserId,
                    onNavigateToChat = onNavigateToChat,
                    onProfileImageClicked = onProfileImageClicked,
                    onDeleteChat = onDeleteChat
                )
            }
        }
    }
}

@Composable
fun MoreScreen(
    context: Context,
    modifier: Modifier = Modifier,
    myContact: RoomContact,
    onSignOutClicked: () -> Unit,
    onNavigateToEditProfile: () -> Unit,
){
    Surface(
        modifier = modifier
            .fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        Column() {
            ContactInfoWithProfilePicture(context = context, myContact = myContact) {
                onNavigateToEditProfile()
            }
//            MoreItem() {
//
//            }
//            MoreItem(Icons.Default.Security, "Security") {
//
//            }
            MoreItem(Icons.Default.Logout, "Sign Out") {
                onSignOutClicked()
            }
        }
    }
}

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun ChatList(
    context: Context,
    list: List<RoomChat>,
    myUserId: String,
    onNavigateToChat: (String) -> Unit,
    onDeleteChat: (String, String) -> Unit,
    onProfileImageClicked: (String, String) -> Unit
){
    LazyColumn(
        modifier = Modifier,
    ){
        repeat(list.size){
            item {
                ChatListItem(
                    modifier = Modifier,
                    context = context,
                    myUserId = myUserId,
                    item = list[it],
                    onNavigateToChat = onNavigateToChat,
                    onDeleteChat = onDeleteChat
                ) {
                    onProfileImageClicked(list[it].profilePhotoPath, list[it].displayName)
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ContactInfoWithProfilePicture(
    context: Context,
    myContact: RoomContact,
    onNavigateToEditProfile: () -> Unit,
){
    val profileImageFile = File(context.filesDir, myContact.localProfilePhotoPath)
    val imagePainter: AsyncImagePainter = rememberAsyncImagePainter(profileImageFile)
    LaunchedEffect(myContact){
        imagePainter.onForgotten()
        imagePainter.onRemembered()
    }
    Card(onClick = {
        onNavigateToEditProfile()
    },
        shape = RectangleShape,
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.background)
    ) {
        Row(modifier = Modifier.padding(start = 20.dp, top = 20.dp, bottom = 20.dp)) {
            ProfilePicture(
                imageObj = File(context.filesDir, myContact.localProfilePhotoPath),
                size = 60.dp,
                shape = CircleShape,
            )
            Spacer(modifier = Modifier.width(20.dp))
            Column(Modifier.weight(1f)) {
                Text(
                    text = myContact.displayName,
                    style = MaterialTheme.typography.bodyLarge,
                    fontWeight = FontWeight.Medium,
                    maxLines = 1
                )
                Spacer(modifier = Modifier.height(10.dp))
                Text(
                    text = myContact.email,
                    overflow = TextOverflow.Ellipsis,
                    color = neutral_disabled,
                    style = MaterialTheme.typography.labelLarge,
                    maxLines = 1
                )
            }
            IconButton(onClick = { onNavigateToEditProfile() }) {
                Icon(
                    imageVector = Icons.Default.ArrowForwardIos,
                    contentDescription = "",
                    modifier = Modifier.size(15.dp)
                )
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MoreItem(
    leadingIcon: ImageVector = Icons.Outlined.Person,
    text: String = "Account",
    onClick: () -> Unit,
){
    Card(
        onClick = { onClick() },
        shape = RectangleShape,
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.background)
    ){
        Row(
            modifier = Modifier.padding(start = 20.dp, top = 5.dp, bottom = 5.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                imageVector = leadingIcon,
                contentDescription = null,
                modifier = Modifier.size(27.dp)
            )
            Spacer(modifier = Modifier.width(10.dp))
            Text(
                modifier = Modifier.weight(1f),
                text = text,
                fontWeight = FontWeight.Medium,
                overflow = TextOverflow.Ellipsis,
                style = MaterialTheme.typography.bodyLarge,
                maxLines = 1
            )
            IconButton(onClick = { onClick() }) {
                Icon(
                    imageVector = Icons.Default.ArrowForwardIos,
                    contentDescription = "",
                    modifier = Modifier.size(15.dp)
                )
            }

        }
    }
}