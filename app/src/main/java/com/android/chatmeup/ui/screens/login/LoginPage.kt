package com.android.chatmeup.ui.screens.login
//
//import android.annotation.SuppressLint
//import android.content.Context
//import androidx.compose.foundation.Image
//import androidx.compose.foundation.clickable
//import androidx.compose.foundation.layout.*
//import androidx.compose.foundation.shape.RoundedCornerShape
//import androidx.compose.material.*
//import androidx.compose.runtime.*
//import androidx.compose.ui.Alignment
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.layout.ContentScale
//import androidx.compose.ui.platform.LocalContext
//import androidx.compose.ui.res.painterResource
//import androidx.compose.ui.text.font.FontWeight
//import androidx.compose.ui.text.style.TextAlign
//import androidx.compose.ui.unit.dp
//import androidx.lifecycle.viewmodel.compose.viewModel
//import com.android.chatmeup.R
//import com.android.chatmeup.ui.theme.cmuBlue
//import com.android.chatmeup.ui.theme.cmuOffWhite
//
//@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
//@Composable
//fun LoginPage(
//    context: Context = LocalContext.current,
//    isDarkTheme: Boolean = false
//){
//    val loginPageViewModel = viewModel<LoginPageViewModel>()
//
//    val loginEventStatus by loginPageViewModel.loginEventStatus.collectAsState()
//
//    val inputPhoneNoEventState by loginPageViewModel.inputPhoneNoEventState.collectAsState()
//
//    val phoneNo: MutableState<String> = remember {
//        mutableStateOf("")
//    }
//
//    val isValidPhoneNo = remember {
//        mutableStateOf(false)
//    }
//
//    val inputPhoneNodialogVisibility  = remember {
//        mutableStateOf(false)
//    }
//
//    val inputOTPDialogVisibility = remember{
//        mutableStateOf(false)
//    }
//
//    when(loginEventStatus){
//        LoginStatus.INIT -> {
//            inputPhoneNodialogVisibility.value = false
//            inputOTPDialogVisibility.value = false
//        }
//        LoginStatus.INPUT_PHONE_NO -> {
//            inputPhoneNodialogVisibility.value = true
//            inputOTPDialogVisibility.value = false
//
//        }
//        LoginStatus.INPUT_CODE -> {
//            inputPhoneNodialogVisibility.value = false
//            inputOTPDialogVisibility.value = true
//        }
//    }
//
//    InputPhoneNoDialog(
//        isInputPhoneNoDialogVisible = inputPhoneNodialogVisibility,
//        phoneNo = phoneNo,
//        isValidPhoneNo = isValidPhoneNo,
//        inputPhoneNoEventState = inputPhoneNoEventState,
//        onBackClick = {
//            loginPageViewModel.onEventTriggered(
//                event = LoginPageViewModel.LoginEvents.InitLoginEvent
//            )
//        }) {
//    }
//
//    Scaffold(backgroundColor = MaterialTheme.colors.background) {
//        Box(modifier = Modifier
//            .fillMaxSize()
//            .padding(it)){
//            Box (modifier = Modifier.align(Alignment.TopStart)){
//                Column(modifier = Modifier.padding(top = 80.dp)) {
//                    Image(
//                        painter = painterResource(id = if(!isDarkTheme)R.drawable.login_image else R.drawable.login_image_dark_theme),
//                        contentDescription = "Login Image",
//                        modifier = Modifier
//                            .align(Alignment.CenterHorizontally)
//                            .fillMaxWidth()
//                            .fillMaxHeight(0.5f)
//                            .padding(30.dp)
//                        ,
//                        contentScale = ContentScale.Fit
//                    )
//                    Spacer(modifier = Modifier.height(30.dp))
//                    Text(
//                        text = "Connect easily with your family and friends over countries",
//                        modifier = Modifier.padding(start = 50.dp, end = 50.dp),
//                        style = MaterialTheme.typography.h5,
//                        textAlign = TextAlign.Center,
//                        fontWeight = FontWeight.Bold
//                    )
//                }
//            }
//            Box(
//                Modifier
//                    .align(Alignment.BottomCenter)
//                    .fillMaxWidth()
//                    .padding(bottom = 20.dp, start = 20.dp, end = 20.dp)
//            ) {
//                BottomSection(onClickStart = {
//                    loginPageViewModel.onEventTriggered(
//                        event = LoginPageViewModel.LoginEvents.InputPhoneNoEvent,
//                    )
//                })
//            }
//        }
//    }
//}
//
//@Composable
//fun BottomSection(
//    modifier: Modifier = Modifier,
//    onClickStart : () -> Unit
//){
//    Column(modifier = modifier) {
//        Text(
//            text = "Terms and Privacy Policy",
//            modifier = Modifier
//                .clickable {
//                    TODO()
//                }
//                .fillMaxWidth()
//                .align(Alignment.CenterHorizontally),
//            textAlign = TextAlign.Center
//        )
//        Spacer(modifier = Modifier.height(10.dp))
//        Button(modifier = Modifier
//            .height(50.dp)
//            .fillMaxWidth(),
//            onClick = {
//                onClickStart()
//                //your onclick code here
//            },elevation =  ButtonDefaults.elevation(
//                defaultElevation = 0.dp,
//                pressedElevation = 5.dp,
//                disabledElevation = 0.dp
//            ), colors = ButtonDefaults.buttonColors(backgroundColor = cmuBlue),
//            shape = RoundedCornerShape(25.dp)
//        ) {
//            Text(text = "Start Messaging",
//                style = MaterialTheme.typography.button,
//                color = cmuOffWhite
//            )
//        }
//    }
//}