package com.android.chatmeup.ui.screens.loginscreen

import android.app.Activity
import android.content.Context
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Error
import androidx.compose.material.icons.outlined.Visibility
import androidx.compose.material.icons.outlined.VisibilityOff
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
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.android.chatmeup.ui.cmutoast.CmuToast
import com.android.chatmeup.ui.cmutoast.CmuToastDuration
import com.android.chatmeup.ui.cmutoast.CmuToastStyle
import com.android.chatmeup.ui.screens.components.CmuDarkButton
import com.android.chatmeup.ui.screens.components.CmuInputTextFieldWithLabel
import com.android.chatmeup.ui.screens.components.Logo
import com.android.chatmeup.ui.theme.cmuBlue
import com.android.chatmeup.util.isEmailValid
import com.android.chatmeup.util.isStrongPassword
import com.google.accompanist.insets.navigationBarsWithImePadding
import com.google.accompanist.permissions.ExperimentalPermissionsApi

@OptIn(ExperimentalPermissionsApi::class)
@Composable
fun LoginScreen(
    context: Context,
    activity: Activity?,
    onClickRegister: () -> Unit,
    onDataLoaded: () -> Unit,
    loginScreenViewModel: LoginScreenViewModel = hiltViewModel(),
){
//    val loginScreenViewModel = viewModel<LoginScreenViewModel>()
//    val loginScreenViewModel: LoginScreenViewModel = loginScreenViewModelProvider(
//        factory = factory,
//        cmuDataStoreRepository = cmuDataStoreRepository
//    )

    val loginViewState by loginScreenViewModel.loginEventStatus.collectAsState()

    val loadingMsg by loginScreenViewModel.loadingMsg.collectAsState()

    var email  by rememberSaveable {
        mutableStateOf("")
    }

    var password  by rememberSaveable {
        mutableStateOf("")
    }

    val isEmailValid: MutableState<Boolean> = remember {
        mutableStateOf(false)
    }

    val isPasswordVisible: MutableState<Boolean> = remember {
        mutableStateOf(false)
    }

    val isStrongPassword: MutableState<Boolean> = remember {
        mutableStateOf(false)
    }

    Scaffold(modifier = Modifier.fillMaxSize()) { paddingValues ->
        if(loginViewState == LoginStatus.INIT || loginViewState == LoginStatus.LOADING || loginViewState == LoginStatus.ERROR){
            Column(
                modifier = Modifier
                    .verticalScroll(rememberScrollState())
                    .navigationBarsWithImePadding()
                    .padding(paddingValues)
                    .fillMaxSize()
            ) {
                Spacer(modifier = Modifier.height(30.dp))
                Logo()
                Spacer(modifier = Modifier.height(50.dp))
                Text(
                    text = "Welcome Back",
                    style = MaterialTheme.typography.headlineMedium,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 25.dp, end = 25.dp),
                    textAlign = TextAlign.Start
                )
                Spacer(modifier = Modifier.height(5.dp))
                Text(
                    text = "Login to your account. Share long lasting memories",
                    style = MaterialTheme.typography.labelLarge,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 25.dp, end = 25.dp),
                    textAlign = TextAlign.Start
                )
                Spacer(modifier = Modifier.height(10.dp))
                CmuInputTextFieldWithLabel(
                    modifier = Modifier,
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
                    label = "Password",
                    placeholder = "Enter your password",
                    keyboardType = KeyboardType.Password,
                    text = password,
                    imeAction = ImeAction.Done,
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

                Spacer(modifier = Modifier.height(30.dp))

                //TODO Forgot Password and Remember me

                CmuDarkButton(
                    label = "Login",
                    isLoading = loginViewState == LoginStatus.LOADING,
                    onClick = {
                        if (isEmailValid.value) loginScreenViewModel.onEventTriggered(
                            LoginScreenViewModel.LoginEvents.LoadingEvent(
                                activity = activity,
                                context = context,
                                email = email,
                                password = password,
                                onDataLoaded = onDataLoaded
                            ),
                        )
                        else {
                            CmuToast.createFancyToast(
                                context = context,
                                activity = activity,
                                title = "Login",
                                message = "Invalid Email",
                                style = CmuToastStyle.ERROR,
                                duration = CmuToastDuration.SHORT
                            )
                        }
                    }
                )
                Text(
                    text = "or",
                    textAlign = TextAlign.Center,
                    style = MaterialTheme.typography.labelLarge,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(5.dp)
                )
                CmuDarkButton(
                    label = "Sign in with Google",
                    isLoading = false, //TODO
                    onClick = {
                        CmuToast.createFancyToast(
                            context,
                            activity,
                            "N/A",
                            "This feature has not been implemented yet",
                            CmuToastStyle.INFO,
                            CmuToastDuration.SHORT
                        )
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
                        text = "Don't have an account? ",
//                    textAlign = TextAlign.Center,
                        style = MaterialTheme.typography.labelLarge,
                        modifier = Modifier
                    )
                    Text(
                        text = "Register",
                        style = MaterialTheme.typography.labelLarge,
                        color = cmuBlue,
                        modifier = Modifier.clickable {
                            onClickRegister()
                        },
                        textDecoration = TextDecoration.Underline
                    )
                }
            }
        }
        else if(loginViewState == LoginStatus.LOADING_DATA){
            Box(
                modifier = Modifier
                    .padding(paddingValues)
                    .fillMaxSize(),
            ){
                Column(modifier = Modifier.align(Alignment.Center)) {
                    CircularProgressIndicator(
                        modifier = Modifier
                            .size(114.dp)
                            .align(alignment = Alignment.CenterHorizontally)
                            .padding(16.dp),
                        color = MaterialTheme.colorScheme.onBackground,
                        strokeWidth = 2.dp
                    )
                    Text(
                        modifier = Modifier
                            .fillMaxWidth()
                            .align(Alignment.CenterHorizontally),
                        textAlign = TextAlign.Center,
                        text = loadingMsg,
                        style = MaterialTheme.typography.titleLarge,
                    )
                }
            }
        }
        else if(loginViewState == LoginStatus.ERROR_LOADING_DATA){
            Box(modifier = Modifier
                .fillMaxSize()
                .padding(bottom = paddingValues.calculateBottomPadding())
            ){
                Column(
                    modifier = Modifier
                        .fillMaxSize(),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Icon(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.dp),
                        imageVector = Icons.Default.Error,
                        contentDescription = null,
//                        tint = Color.Black
                    )
                    Spacer(modifier = Modifier.padding(vertical = 4.dp))
                    Text(
                        modifier = Modifier.padding(horizontal = 20.dp),
                        text = "Unable to Load Chats",
                        style = androidx.compose.material.MaterialTheme.typography.h6,
                        fontWeight = FontWeight.Bold,
                        textAlign = TextAlign.Center
                    )
                    Spacer(modifier = Modifier.padding(vertical = 4.dp))
                    Text(
                        modifier = Modifier.padding(horizontal = 40.dp),
                        text = "Check your Internet Connection and Try Again",
                        style = androidx.compose.material.MaterialTheme.typography.button,
                        fontWeight = FontWeight.Light,
                        textAlign = TextAlign.Center
                    )
                }

                CmuDarkButton(
                    label = "Retry",
                    padding = PaddingValues(20.dp),
                    shape = CircleShape
                ) {
                    loginScreenViewModel.onEventTriggered(
                        event = LoginScreenViewModel.LoginEvents.LoadAllData(
                            context, activity, onDataLoaded
                        )
                    )
                }
            }
        }
        else if(loginViewState == LoginStatus.DONE){
            Box(
                modifier = Modifier
                    .padding(paddingValues)
                    .fillMaxSize(),
            ){
                Column(modifier = Modifier.align(Alignment.Center)) {
                    //TODO:: I need to put an icon/image to show done
                    Text(
                        modifier = Modifier
                            .fillMaxWidth()
                            .align(Alignment.CenterHorizontally),
                        textAlign = TextAlign.Center,
                        text = "Chats Loaded. Navigating to Home...",
                        style = androidx.compose.material.MaterialTheme.typography.h6,
                    )
                }
            }
        }
    }
}