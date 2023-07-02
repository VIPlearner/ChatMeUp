package com.android.chatmeup.ui.screens.editprofile

import android.Manifest
import android.app.Activity
import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.Matrix
import android.net.Uri
import android.os.Build
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.ModalBottomSheetLayout
import androidx.compose.material.ModalBottomSheetState
import androidx.compose.material.ModalBottomSheetValue
import androidx.compose.material.Surface
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.outlined.Info
import androidx.compose.material.rememberModalBottomSheetState
import androidx.compose.material3.BottomSheetDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ProvideTextStyle
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.core.content.FileProvider
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.rememberAsyncImagePainter
import com.android.chatmeup.R
import com.android.chatmeup.ui.cmutoast.CmuToast
import com.android.chatmeup.ui.cmutoast.CmuToastDuration
import com.android.chatmeup.ui.cmutoast.CmuToastStyle
import com.android.chatmeup.ui.screens.components.CmuDarkButton
import com.android.chatmeup.ui.screens.components.CmuInputTextFieldWithLabel
import com.android.chatmeup.ui.screens.components.CmuTopBar
import com.android.chatmeup.ui.screens.components.ImagePage
import com.android.chatmeup.ui.screens.components.InputStringDialog
import com.android.chatmeup.ui.screens.components.UploadFileOptionDialog
import com.android.chatmeup.ui.screens.editprofile.components.ProfileItem
import com.android.chatmeup.ui.screens.editprofile.components.UploadImageScreen
import com.android.chatmeup.ui.screens.editprofile.viewmodel.EditProfileState
import com.android.chatmeup.ui.screens.editprofile.viewmodel.EditProfileViewModel
import com.android.chatmeup.ui.theme.md_theme_dark_background
import com.android.chatmeup.ui.theme.md_theme_light_background
import com.android.chatmeup.ui.theme.neutral_disabled
import com.android.chatmeup.ui.theme.seed
import com.android.chatmeup.util.createTempImageFile
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import timber.log.Timber
import java.io.File




const val MAX_DISPLAY_NAME_LENGTH = 25
const val MAX_ABOUT_STR_LENGTH = 140

@OptIn(ExperimentalMaterial3Api::class, ExperimentalMaterialApi::class,
    ExperimentalComposeUiApi::class
)
@Composable
fun EditProfileScreen(
    context: Context,
    activity: Activity?,
    onBackClick: () -> Unit,
    editProfileViewModel: EditProfileViewModel = hiltViewModel()
){
    val myContact by editProfileViewModel.myRoomContact.collectAsState()
    val eventState by editProfileViewModel.eventState.collectAsState()
    val isUpdatingProfileImage by editProfileViewModel.isUpdatingProfileImage.collectAsState()

    val scope = rememberCoroutineScope()
    val systemUiController = rememberSystemUiController()


    val profileImageUri = Uri.parse("")

    var profileImageFile : File? by remember {
        mutableStateOf(null)
    }

//    var newProfileImageFile : File by remember {
//        mutableStateOf(File(context.filesDir, "cache/new_profile_image"))
//    }

    var newProfileImageURI: Uri? by rememberSaveable {
        mutableStateOf(null)
    }

    var newProfileImageBitmap: Bitmap? by remember {
        mutableStateOf(null)
    }

    var displayName by remember {
        mutableStateOf(myContact.displayName)
    }

    var aboutStr by remember {
        mutableStateOf(myContact.aboutStr)
    }

    var displayNameTextLengthRemaining by remember {
        mutableStateOf(MAX_DISPLAY_NAME_LENGTH - displayName.length)
    }

    var aboutStrTextLengthRemaining by remember {
        mutableStateOf(MAX_ABOUT_STR_LENGTH - aboutStr.length)
    }

    var currentBottomSheet: BottomSheetScreen by remember{
        mutableStateOf(BottomSheetScreen.EditDisplayName)
    }

    var sheetShape: Shape by remember {
        mutableStateOf(RoundedCornerShape(topStart = 20.dp, topEnd = 20.dp))
    }

    val modalBottomSheetState =
        rememberModalBottomSheetState(
            initialValue = ModalBottomSheetValue.Hidden,
            confirmValueChange = {it != ModalBottomSheetValue.HalfExpanded},
            skipHalfExpanded = true
        )

    val onUpdateProfileImageClicked = {
        sheetShape = RoundedCornerShape(topStart = 20.dp, topEnd = 20.dp)
        currentBottomSheet =
            BottomSheetScreen.UploadImageOption
        scope.launch {
            modalBottomSheetState.show()
        }
    }

    val onViewProfileImageClicked : (File) -> Unit = { imageFile ->
        sheetShape = RectangleShape
        currentBottomSheet =
            BottomSheetScreen.ProfileImagePage(imageFile)
        scope.launch {
            modalBottomSheetState.show()
        }
    }

    val cameraLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.TakePicture(),
    ) { success ->
        if (success) {
            // Retrieve the captured image URI from the camera
//            photoURI = newPhotoURI
//            scope.launch{ modalBottomSheetState.hide() }
            //Display Image confirm/cancel
            sheetShape = RectangleShape
            val inputStream = newProfileImageURI?.let { context.contentResolver.openInputStream(it) }
            newProfileImageBitmap = BitmapFactory.decodeStream(inputStream)
            currentBottomSheet =
                BottomSheetScreen.ConfirmUploadImageOption(newProfileImageBitmap)
            scope.launch {
                modalBottomSheetState.show()
            }
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
            newProfileImageURI = uri
            val inputStream = context.contentResolver.openInputStream(uri)
            newProfileImageBitmap = BitmapFactory.decodeStream(inputStream)
            Timber.tag("Edit Profile Screen").d("Photo URI: $newProfileImageURI")
//            scope.launch{ modalBottomSheetState.hide() }
            currentBottomSheet =
                BottomSheetScreen.ConfirmUploadImageOption(newProfileImageBitmap)
            scope.launch {
                modalBottomSheetState.show()
            }
        }
    }

    val requestCameraPermissionLauncher = rememberLauncherForActivityResult(
        ActivityResultContracts.RequestPermission()
    ) { isGranted ->
        if (isGranted) {
            // Permission granted, launch the camera
            if (newProfileImageURI != null && Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
                context.contentResolver.delete(newProfileImageURI!!, null)
            }
            newProfileImageURI = FileProvider.getUriForFile(
                context,
                context.applicationContext.packageName + ".provider",
                createTempImageFile(context)
            )
            cameraLauncher.launch(newProfileImageURI)
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

    val imagePainter = rememberAsyncImagePainter(profileImageFile)

    LaunchedEffect(eventState){
        if(eventState == EditProfileState.DONE){
            profileImageFile = File(context.filesDir, myContact.localProfilePhotoPath)
            displayNameTextLengthRemaining = MAX_DISPLAY_NAME_LENGTH - displayName.length
            aboutStrTextLengthRemaining = MAX_ABOUT_STR_LENGTH - aboutStr.length
        }
    }

    LaunchedEffect(isUpdatingProfileImage){
        if(isUpdatingProfileImage){
            profileImageFile = File(context.filesDir, myContact.localProfilePhotoPath)
        }
        imagePainter.onForgotten()
        imagePainter.onRemembered()
    }

    val isDarkTheme = isSystemInDarkTheme()
    LaunchedEffect(modalBottomSheetState.isVisible){
        if(!(modalBottomSheetState.isVisible &&
                    (currentBottomSheet is BottomSheetScreen.ProfileImagePage || currentBottomSheet is BottomSheetScreen.ConfirmUploadImageOption))){
            systemUiController.setSystemBarsColor(
                color = if (isDarkTheme) md_theme_dark_background else md_theme_light_background,
                darkIcons = !isDarkTheme
            )
        }
        else{
            systemUiController.setSystemBarsColor(Color.Black, darkIcons = false)
        }
    }

    ModalBottomSheetLayout(
        sheetContent = {
        SheetLayout(
            scope = scope,
            currentScreen = currentBottomSheet,
            modalBottomSheetState = modalBottomSheetState,
            context = context,
            activity = activity,
            displayName = displayName,
            onCloseImagePage = {
                systemUiController.setSystemBarsColor(
                    color = if (isDarkTheme) md_theme_dark_background else md_theme_light_background,
                    darkIcons = !isDarkTheme
                )
            },
            onDisplayNameChanged =
            {
                if(MAX_DISPLAY_NAME_LENGTH - displayName.length > 0){
                    displayNameTextLengthRemaining = MAX_DISPLAY_NAME_LENGTH - displayName.length
                    displayName = it
                }
                else{
                    //do nothing for now
                }
            },
            onConfirmDisplayName = {
                editProfileViewModel.updateDisplayName(
                    it
                )
                scope.launch {
                    modalBottomSheetState.hide()
                }
            },
            displayNameTextLengthRemaining = displayNameTextLengthRemaining,
            aboutStr = aboutStr,
            onAboutStrChanged = {
                if(MAX_ABOUT_STR_LENGTH - aboutStr.length > 0){
                    aboutStrTextLengthRemaining = MAX_ABOUT_STR_LENGTH - aboutStr.length
                    aboutStr = it
                }
                else{
                    //do nothing for now
                }
            },
            onConfirmAbout = {
                editProfileViewModel.updateAbout(
                    it
                )
                scope.launch {
                    modalBottomSheetState.hide()
                }
            },
            aboutTextLengthRemaining = aboutStrTextLengthRemaining,
            onTakePictureClicked = {
                requestCameraPermissionLauncher.launch(Manifest.permission.CAMERA)
            },
            onUploadFromStorageClicked = {
                scope.launch{
                    requestStoragePermissionLauncher.launch(
                        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) Manifest.permission.READ_MEDIA_IMAGES else Manifest.permission.READ_EXTERNAL_STORAGE
                    )
                }
            },
            onConfirmProfileImage =
            {
                scope.launch {
                    modalBottomSheetState.hide()
                }
                newProfileImageURI?.let { it1 ->
                    editProfileViewModel.updateProfileImage(
                        context = context,
                        activity = activity,
                        imageUri = it1,
                    )
                }
            },
            onRotateProfileImage = {
                val matrix = Matrix()
                matrix.postRotate(-90f)
                newProfileImageBitmap = newProfileImageBitmap?.let {
                    Bitmap.createBitmap(
                        it, 0, 0,
                        newProfileImageBitmap?.width ?: 0, newProfileImageBitmap?.getHeight()?:0,
                        matrix, true
                    )
                }
                currentBottomSheet = BottomSheetScreen.ConfirmUploadImageOption(newProfileImageBitmap)
            }
        ) },
        sheetBackgroundColor = MaterialTheme.colorScheme.background,
        sheetElevation = 20.dp,
        sheetShape = sheetShape,
        sheetState = modalBottomSheetState,
    ) {
        val keyboardController = LocalSoftwareKeyboardController.current
        if(!modalBottomSheetState.isVisible){
            keyboardController?.hide()
        }
        Scaffold(
            topBar = {
                CmuTopBar(
                    title = "Edit Profile",
                    shouldShowBackIcon = true,
                    onBackClick = onBackClick
                )
            }
        ) { paddingValues ->
            when (eventState) {
                EditProfileState.INIT -> {
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(paddingValues)
                            .padding(30.dp),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        CircularProgressIndicator(
                            modifier = Modifier
                                .size(114.dp)
                                .align(alignment = Alignment.CenterHorizontally)
                                .padding(16.dp),
                            color = MaterialTheme.colorScheme.onBackground,
                            strokeWidth = 2.dp
                        )
                        Spacer(modifier = Modifier.padding(vertical = 4.dp))
                        Text(
                            text = "Initializing...",
                            style = androidx.compose.material.MaterialTheme.typography.h6,
                            fontWeight = FontWeight.Medium,
                            color = MaterialTheme.colorScheme.onBackground,
                            textAlign = TextAlign.Center
                        )
                    }
                }

                EditProfileState.LOADING -> {
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(paddingValues)
                            .padding(30.dp),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        CircularProgressIndicator(
                            modifier = Modifier
                                .size(114.dp)
                                .align(alignment = Alignment.CenterHorizontally)
                                .padding(16.dp),
                            color = MaterialTheme.colorScheme.onBackground,
                            strokeWidth = 2.dp
                        )
                        Spacer(modifier = Modifier.padding(vertical = 4.dp))
                        Text(
                            text = "Loading...",
                            style = MaterialTheme.typography.titleLarge,
                            fontWeight = FontWeight.Medium,
                            color = MaterialTheme.colorScheme.onBackground,
                            textAlign = TextAlign.Center
                        )
                    }
                }

                EditProfileState.DONE -> {
//                    val file = File(context.filesDir, myContact.localProfilePhotoPath)
                    Column(modifier = Modifier.padding(paddingValues)) {
                        Spacer(modifier = Modifier.height(45.dp))
                        Box(
                            modifier = Modifier
                                .size(130.dp)
                                .align(Alignment.CenterHorizontally),
                        ){
                            Card(
                                shape = CircleShape,
                                onClick = {
                                    if (profileImageFile != null && profileImageFile?.exists() == true) {
                                        profileImageFile?.let{
                                            systemUiController.setSystemBarsColor(Color.Black, darkIcons = false)
                                            onViewProfileImageClicked(it)
                                        }
                                    } else {
                                        onUpdateProfileImageClicked()
                                    }
                                },
                                colors = CardDefaults.cardColors(
                                    containerColor = MaterialTheme.colorScheme.tertiaryContainer
                                )
                            ) {
                                Box(modifier = Modifier.fillMaxSize()){
                                    if (profileImageFile?.exists() != true) {
                                        Icon(
                                            modifier = Modifier
                                                .fillMaxSize()
                                                .padding(40.dp),
                                            imageVector = ImageVector.vectorResource(id = R.drawable.ic_profile),
                                            contentDescription = "Upload profile picture",
                                            tint = MaterialTheme.colorScheme.onBackground
                                        )
                                    } else {
                                        Image(
                                            painter = imagePainter,
                                            contentDescription = "Profile Picture",
                                            modifier = Modifier
                                                .fillMaxSize(),
                                            contentScale = ContentScale.Crop
                                        )
                                    }
                                    if(isUpdatingProfileImage){
                                        Surface(color = neutral_disabled.copy(0.6f), modifier = Modifier.fillMaxSize()) {
                                            CircularProgressIndicator(color = seed, strokeWidth = 5.dp, modifier = Modifier.align(Alignment.Center))
                                        }
                                    }


                                }

                            }
                            Card(
                                colors = CardDefaults.cardColors(
                                    containerColor = seed
                                ),
                                onClick = {
                                    onUpdateProfileImageClicked()
                                },
                                modifier = Modifier
                                    .align(Alignment.BottomEnd)
                                    .size(40.dp),
                                shape = CircleShape,
                                elevation = CardDefaults.cardElevation(4.dp)
                            ) {
                                Icon(
                                    modifier = Modifier.padding(10.dp),
                                    imageVector = ImageVector.Companion.vectorResource(id = R.drawable.ic_camera),
                                    contentDescription = "Click to upload Profile Picture",
                                    tint = Color.White
                                )
                            }
                        }
                        Spacer(modifier = Modifier.height(15.dp))
                        ProfileItem(
                            label = "Name",
                            value = myContact.displayName,
                            description = "This is the name your ChatMeUp Contacts will see",
                            icon = Icons.Filled.Person,
                            iconDescription = "Person Icon",
                            isEditable = true,
                            showDivider = true
                        ) {
                            displayName = myContact.displayName
                            displayNameTextLengthRemaining = MAX_DISPLAY_NAME_LENGTH - displayName.length
                            sheetShape = RoundedCornerShape(topStart = 20.dp, topEnd = 20.dp)
                            currentBottomSheet =
                                BottomSheetScreen.EditDisplayName
                            scope.launch {
                                modalBottomSheetState.show()
                            }
                        }
                        Divider(
                            modifier = Modifier
                                .fillMaxWidth(0.86f)
                                .align(Alignment.End),
                            thickness = 0.5.dp,
                            color = neutral_disabled.copy(alpha = 0.3f)
                        )
                        ProfileItem(
                            label = "About",
                            value = myContact.aboutStr,
                            icon = Icons.Outlined.Info,
                            iconDescription = "About Icon",
                            isEditable = true,
                            showDivider = true
                        ) {
                            aboutStr = myContact.aboutStr
                            aboutStrTextLengthRemaining = MAX_ABOUT_STR_LENGTH - aboutStr.length
                            sheetShape = RoundedCornerShape(topStart = 20.dp, topEnd = 20.dp)
                            currentBottomSheet =
                                BottomSheetScreen.EditAbout
                            scope.launch {
                                modalBottomSheetState.show()
                            }
                        }
                        Divider(
                            modifier = Modifier
                                .fillMaxWidth(0.86f)
                                .align(Alignment.End),
                            thickness = 0.5.dp,
                            color = neutral_disabled.copy(alpha = 0.3f)
                        )
                        ProfileItem(
                            label = "Email",
                            value = myContact.email,
                            icon = Icons.Filled.Email,
                            iconDescription = "About Icon",
                            isEditable = false,
                            showDivider = false
                        ) {
                            //todo
                        }
                    }
                }

                EditProfileState.ERROR -> {
                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(paddingValues)
                    ) {
                        Column(
                            modifier = Modifier
                                .fillMaxSize(),
                            verticalArrangement = Arrangement.Center,
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Image(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(16.dp),
                                painter = painterResource(R.drawable.ic_error),
                                contentDescription = null,
                                colorFilter = ColorFilter.tint(color = MaterialTheme.colorScheme.onBackground)
                            )
                            Spacer(modifier = Modifier.padding(vertical = 4.dp))
                            Text(
                                modifier = Modifier.padding(horizontal = 20.dp),
                                text = "Unable to Load Profile",
                                style = androidx.compose.material.MaterialTheme.typography.h6,
                                fontWeight = FontWeight.Bold,
                                color = MaterialTheme.colorScheme.onBackground,
                                textAlign = TextAlign.Center
                            )
                            Spacer(modifier = Modifier.padding(vertical = 4.dp))
                            Text(
                                modifier = Modifier.padding(horizontal = 40.dp),
                                text = "Check your Internet Connection and Try Again",
                                style = androidx.compose.material.MaterialTheme.typography.button,
                                fontWeight = FontWeight.Light,
                                color = MaterialTheme.colorScheme.onBackground,
                                textAlign = TextAlign.Center
                            )
                        }

                        CmuDarkButton(
                            modifier = Modifier
                                .padding(horizontal = 20.dp, vertical = 20.dp)
                                .align(Alignment.BottomCenter),
                            label = "Retry",
                        ) {
                            editProfileViewModel.initialize()
                        }
                    }
                }
            }
        }
    }
}

@OptIn(ExperimentalComposeUiApi::class, ExperimentalMaterial3Api::class)
@Composable
fun EditDisplayNameDialog(
    onDismissButtonClicked: () -> Unit,
    onConfirm: (String) -> Unit,
    displayName: String,
    onValueChanged: (String) -> Unit,
    textLengthRemaining: Int
){
    val keyboardController = LocalSoftwareKeyboardController.current
    keyboardController?.show()
    Column(
        modifier = Modifier
            .statusBarsPadding()
            .navigationBarsPadding()
            .imePadding(),
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        BottomSheetDefaults.DragHandle(modifier = Modifier.align(Alignment.CenterHorizontally))
        CmuInputTextFieldWithLabel(
            placeholder = "Display Name",
            text = displayName,
            onValueChanged = onValueChanged,
            trailingIcon = {
                Text(
                    text = textLengthRemaining.toString(),
                    overflow = TextOverflow.Ellipsis,
                    style = MaterialTheme.typography.labelLarge,
                    color = neutral_disabled
                )
            },
        )


        Box(
            modifier = Modifier
                .align(Alignment.End)
                .padding(bottom = 8.dp, end = 6.dp)
        ) {
            val textStyle =
                MaterialTheme.typography.labelLarge
            ProvideTextStyle(value = textStyle) {
                Row(
                ) {
                    TextButton(
                        onClick = onDismissButtonClicked,
                    ) {
                        Text(
                            "Cancel",
                            color = seed,
                            style = MaterialTheme.typography.labelLarge
                        )
                    }
                    TextButton(
                        onClick = {
                            onConfirm(displayName)
                        },
                    ) {
                        Text(
                            "Save",
                            color = seed,
                            style = MaterialTheme.typography.labelLarge
                        )
                    }
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun SheetLayout(
    scope: CoroutineScope,
    currentScreen: BottomSheetScreen,
    modalBottomSheetState: ModalBottomSheetState,
    context: Context,
    activity: Activity?,
    displayName: String,
    displayNameTextLengthRemaining: Int,
    onDisplayNameChanged: (String) -> Unit,
    onConfirmDisplayName: (String) -> Unit,
    aboutStr: String,
    aboutTextLengthRemaining: Int,
    onAboutStrChanged: (String) -> Unit,
    onConfirmAbout: (String) -> Unit,
    onTakePictureClicked: () -> Unit,
    onUploadFromStorageClicked: () -> Unit,
    onConfirmProfileImage: (Any) -> Unit,
    onRotateProfileImage: () -> Unit,
    onCloseImagePage: () -> Unit
) {
    when(currentScreen){
        BottomSheetScreen.EditDisplayName -> {
            InputStringDialog(
                onDismissButtonClicked =
                {
                    scope.launch {
                        modalBottomSheetState.hide()
                    }
                },
                onConfirm = onConfirmDisplayName,
                input = displayName,
                onValueChanged = onDisplayNameChanged,
                textLengthRemaining = displayNameTextLengthRemaining,
                instruction = "Enter your name"
            )
        }
        is BottomSheetScreen.ProfileImagePage -> {
            ImagePage(
                title = "Profile photo",
                imageObj = currentScreen.imageObj,
                onBackClick = {
                    onCloseImagePage()
                    scope.launch {
                        modalBottomSheetState.hide()
                    }
                }
            )
        }

        BottomSheetScreen.UploadImageOption -> {
            UploadFileOptionDialog(
                title = "Profile Photo",
                onTakePictureClicked = onTakePictureClicked,
                onUploadFromStorageClicked = onUploadFromStorageClicked
            )
        }

        BottomSheetScreen.EditAbout -> {
            InputStringDialog(
                onDismissButtonClicked = {
                    scope.launch {
                        modalBottomSheetState.hide()
                    }
                },
                onConfirm = onConfirmAbout,
                instruction = "Add About",
                input = aboutStr,
                onValueChanged = onAboutStrChanged,
                textLengthRemaining = aboutTextLengthRemaining
            )
        }

        is BottomSheetScreen.ConfirmUploadImageOption -> {
            currentScreen.imageObj?.let {imageObj ->
                UploadImageScreen(
                    imageObj = imageObj,
                    onConfirmImage = { onConfirmProfileImage(imageObj) },
                    onClickRotate = onRotateProfileImage,
                    onDismiss = {
                        onCloseImagePage()
                        scope.launch {
                            modalBottomSheetState.hide()
                        }
                    }
                )
            }?:{
                //todo
            }
        }
    }
}


sealed class BottomSheetScreen {
    object EditDisplayName: BottomSheetScreen()
    object EditAbout: BottomSheetScreen()
    object UploadImageOption: BottomSheetScreen()
    data class ConfirmUploadImageOption(val imageObj: Any?): BottomSheetScreen()
    data class ProfileImagePage(val imageObj: Any): BottomSheetScreen()
}