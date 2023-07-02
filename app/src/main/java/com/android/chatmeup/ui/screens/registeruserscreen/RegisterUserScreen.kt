package com.android.chatmeup.ui.screens.registeruserscreen

import android.Manifest
import android.app.Activity
import android.content.ContentValues.TAG
import android.content.Context
import android.net.Uri
import android.os.Build
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.ModalBottomSheetLayout
import androidx.compose.material.ModalBottomSheetValue
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Visibility
import androidx.compose.material.icons.outlined.VisibilityOff
import androidx.compose.material.rememberModalBottomSheetState
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
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
import com.android.chatmeup.ui.screens.components.UploadFileOptionDialog
import com.android.chatmeup.ui.theme.cmuBlue
import com.android.chatmeup.util.createTempImageFile
import com.android.chatmeup.util.isEmailValid
import com.android.chatmeup.util.isStrongPassword
import kotlinx.coroutines.launch
import timber.log.Timber
import java.util.Objects

@OptIn(ExperimentalMaterial3Api::class,
    ExperimentalMaterialApi::class
)
@Composable
fun RegisterUserScreen(
    context: Context,
    activity: Activity?,
    onBackClick: () -> Unit,
    viewModel: RegisterUserScreenViewModel = hiltViewModel()
){
    val registerUserViewState by viewModel.registerUserEventStatus.collectAsState()

    val scope = rememberCoroutineScope()

    val modalBottomSheetState =
        rememberModalBottomSheetState(initialValue = ModalBottomSheetValue.Hidden,
            confirmValueChange = { it != ModalBottomSheetValue.HalfExpanded }
        )

    var photoURI: Uri? by rememberSaveable {
        mutableStateOf(null)
    }

    var newPhotoURI: Uri? by rememberSaveable {
        mutableStateOf(null)
    }

    val cameraLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.TakePicture(),
    ) { success ->
        if (success) {
            // Retrieve the captured image URI from the camera
            photoURI?.let {
                viewModel.onProfilePictureEventTriggered(
                    event = RegisterUserScreenViewModel.ProfilePictureEvents.LoadingEvent,
                    imageUri = it
                )
            }
            photoURI = newPhotoURI
            scope.launch{ modalBottomSheetState.hide() }
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
            photoURI = uri
            Timber.tag(TAG).d("Photo URI: $photoURI")
            scope.launch{ modalBottomSheetState.hide() }
        }
    }

    val requestCameraPermissionLauncher = rememberLauncherForActivityResult(
        ActivityResultContracts.RequestPermission()
    ) { isGranted ->
        if (isGranted) {
            // Permission granted, launch the camera
            if (newPhotoURI != null && Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
                context.contentResolver.delete(newPhotoURI!!, null)
            }
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

    var email: String by rememberSaveable {
        mutableStateOf("")
    }

    var displayName: String by rememberSaveable {
        mutableStateOf("")
    }

    var password: String by rememberSaveable {
        mutableStateOf("")
    }

    var confirmPassword: String by rememberSaveable {
        mutableStateOf("")
    }

    val isEmailValid: MutableState<Boolean> = remember {
        mutableStateOf(false)
    }

    val isDisplayNameValid: MutableState<Boolean> = remember {
        mutableStateOf(false)
    }

    val isPasswordVisible: MutableState<Boolean> = remember {
        mutableStateOf(false)
    }

    val isStrongPassword: MutableState<Boolean> = remember {
        mutableStateOf(false)
    }

    var currentBottomSheet: BottomSheetScreen by remember{
        mutableStateOf(BottomSheetScreen.UploadImageOption)
    }

    ModalBottomSheetLayout(
        sheetState = modalBottomSheetState,
        sheetBackgroundColor = MaterialTheme.colorScheme.background,
        sheetContent = {
            SheetLayout(
                currentScreen = currentBottomSheet,
                context = context,
                activity = activity,
                viewModel = viewModel,
                onTakePictureClicked = {
                    requestCameraPermissionLauncher.launch(Manifest.permission.CAMERA)
                },
                onUploadFromStorageClicked = {
                    requestStoragePermissionLauncher.launch(
                        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) Manifest.permission.READ_MEDIA_IMAGES else Manifest.permission.READ_EXTERNAL_STORAGE
                    )
                }
            )
        }
    ){
        Scaffold(modifier = Modifier.fillMaxSize()) { paddingValues ->
            Column(
                modifier = Modifier
                    .verticalScroll(rememberScrollState())
                    .navigationBarsPadding()
                    .imePadding()
                    .padding(paddingValues)
                    .fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Spacer(modifier = Modifier.height(20.dp))
                Text(
                    text = "Create an account",
                    style = MaterialTheme.typography.headlineMedium,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 25.dp, end = 25.dp),
                    textAlign = TextAlign.Start
                )
                Spacer(modifier = Modifier.height(5.dp))
                Text(
                    text = "Connect with your friends by creating an account",
                    style = MaterialTheme.typography.labelLarge,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 25.dp, end = 25.dp),
                    textAlign = TextAlign.Start
                )
                Spacer(modifier = Modifier.height(15.dp))
                Card(
                    modifier = Modifier.size(90.dp),
                    shape = CircleShape,
                    onClick = {
                        currentBottomSheet = BottomSheetScreen.UploadImageOption
                        scope.launch {
                            modalBottomSheetState.show()
                        }
                    },
                    colors = CardDefaults.cardColors(
                        containerColor = MaterialTheme.colorScheme.tertiaryContainer
                    )
                ) {
                    if (Objects.isNull(photoURI)) {
                        Icon(
                            modifier = Modifier
                                .fillMaxSize()
                                .padding(20.dp),
                            imageVector = ImageVector.Companion.vectorResource(id = R.drawable.ic_profile),
                            contentDescription = "Upload profile picture",
                            tint = MaterialTheme.colorScheme.onBackground
                        )
                    } else {
                        Image(
                            painter = rememberAsyncImagePainter(photoURI),
                            contentDescription = "Profile Picture",
                            modifier = Modifier
                                .fillMaxSize(),
                            contentScale = ContentScale.Crop
                        )
                    }
                }
                CmuInputTextFieldWithLabel(
                    modifier = Modifier,
                    paddingValues = PaddingValues(top = 10.dp, start = 16.dp, end = 16.dp),
                    label = "Display Name",
                    placeholder = "Enter your Display Name",
                    text = displayName,
                    imeAction = ImeAction.Next,
                    onValueChanged = { value ->
                        displayName = value
                    },
                )
                CmuInputTextFieldWithLabel(
                    modifier = Modifier,
                    paddingValues = PaddingValues(top = 10.dp, start = 16.dp, end = 16.dp),
                    label = "Email",
                    placeholder = "Enter your email address",
                    text = email,
                    imeAction = ImeAction.Next,
                    onValueChanged = { value ->
                        email = value
                        isEmailValid.value = email.isEmailValid()
                    },
                )
                CmuInputTextFieldWithLabel(
                    modifier = Modifier,
                    paddingValues = PaddingValues(top = 10.dp, start = 16.dp, end = 16.dp),
                    label = "Password",
                    placeholder = "Enter your password",
                    keyboardType = KeyboardType.Password,
                    text = password,
                    imeAction = ImeAction.Next,
                    onValueChanged = { value ->
                        password = value
                        isStrongPassword.value = isStrongPassword(password)
                    },
                    trailingIcon = {
                        Icon(imageVector = if (isPasswordVisible.value) Icons.Outlined.Visibility else Icons.Outlined.VisibilityOff,
                            contentDescription = "Password visibility",
                            modifier = Modifier.clickable {
                                isPasswordVisible.value = !isPasswordVisible.value
                            }
                        )
                    },
                    visualTransformation = if (isPasswordVisible.value) VisualTransformation.None else PasswordVisualTransformation(),
                )
                CmuInputTextFieldWithLabel(
                    modifier = Modifier,
                    paddingValues = PaddingValues(top = 10.dp, start = 16.dp, end = 16.dp),
                    label = "Confirm Password",
                    placeholder = "Confirm",
                    keyboardType = KeyboardType.Password,
                    text = confirmPassword,
                    imeAction = ImeAction.Done,
                    onValueChanged = { value ->
                        confirmPassword = value
                        isStrongPassword.value = isStrongPassword(password)
                    },
                    visualTransformation = PasswordVisualTransformation(),
                )
                Spacer(modifier = Modifier.height(15.dp))

                Column() {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 5.dp, bottom = 5.dp, start = 30.dp, end = 30.dp)
                            .align(Alignment.CenterHorizontally),
                        horizontalArrangement = Arrangement.Center
                    ) {
                        Text(
                            text = "By continuing you agree to our ",
                            style = MaterialTheme.typography.labelLarge,
                            modifier = Modifier
                        )
                        Text(
                            text = "Terms of Service and",
                            style = MaterialTheme.typography.labelLarge,
                            color = cmuBlue,
                            modifier = Modifier.clickable {
                                //TODO
                            }
                        )
                    }
                    Text(
                        text = "Privacy policy",
                        style = MaterialTheme.typography.labelLarge,
                        color = cmuBlue,
                        textAlign = TextAlign.Center,
                        modifier = Modifier
                            .fillMaxWidth()
                            .clickable {
                                //TODO
                            }
                    )
                }

                Spacer(modifier = Modifier.height(15.dp))

                CmuDarkButton(
                    label = "Sign Up",
                    isLoading = registerUserViewState == RegisterUserStatus.LOADING,
                    onClick = {
                        if (!isEmailValid.value) {
                            CmuToast.createFancyToast(
                                context = context,
                                activity = activity,
                                title = "Sign Up",
                                message = "Invalid Email",
                                style = CmuToastStyle.ERROR,
                                duration = CmuToastDuration.SHORT
                            )
                        }
                        else if (!isStrongPassword.value) {
                            CmuToast.createFancyToast(
                                context = context,
                                activity = activity,
                                title = "Sign Up",
                                message = "Password too weak. Make sure to use special characters and numbers",
                                style = CmuToastStyle.ERROR,
                                duration = CmuToastDuration.LONG
                            )
                        }
                        else if (password != confirmPassword) {
                            CmuToast.createFancyToast(
                                context = context,
                                activity = activity,
                                title = "Sign Up",
                                message = "Passwords don't match",
                                style = CmuToastStyle.ERROR,
                                duration = CmuToastDuration.LONG
                            )
                        } else {
                            viewModel.onEventTriggered(
                                activity,
                                context,
                                RegisterUserScreenViewModel.RegisterUserEvents.LoadingEvent,
                                email = email,
                                password = password,
                                imageUri = photoURI,
                                displayName = displayName,
                                onRegisterUser = onBackClick
                            )
                        }
                    }
                )

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(5.dp)
                        .align(Alignment.CenterHorizontally),
                    horizontalArrangement = Arrangement.Center
                ) {
                    Text(
                        text = "Already have an account? ",
//                    textAlign = TextAlign.Center,
                        style = MaterialTheme.typography.labelLarge,
                        modifier = Modifier
                    )
                    Text(
                        text = "Login",
                        style = MaterialTheme.typography.labelLarge,
                        color = cmuBlue,
                        textDecoration = TextDecoration.Underline,
                        modifier = Modifier.clickable {
                            onBackClick()
                        }
                    )
                }

//            Spacer(modifier = Modifier.height(5.dp))
            }
        }
    }
}


@Composable
fun SheetLayout(
    currentScreen: BottomSheetScreen,
    context: Context,
    activity: Activity?,
    viewModel: RegisterUserScreenViewModel,
    onTakePictureClicked: () -> Unit,
    onUploadFromStorageClicked: () -> Unit
) {
    when(currentScreen){
        BottomSheetScreen.UploadImageOption -> {
            UploadFileOptionDialog(
                title = "Profile Picture",
                onTakePictureClicked = onTakePictureClicked,
                onUploadFromStorageClicked = onUploadFromStorageClicked
            )
        }
    }
}


sealed class BottomSheetScreen {
    object UploadImageOption: BottomSheetScreen()
}