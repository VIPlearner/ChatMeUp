package com.android.chatmeup.ui.screens.login
//
//import android.view.Gravity
//import android.view.WindowManager
//import androidx.compose.animation.animateContentSize
//import androidx.compose.foundation.clickable
//import androidx.compose.foundation.layout.*
//import androidx.compose.foundation.shape.RoundedCornerShape
//import androidx.compose.foundation.text.KeyboardActions
//import androidx.compose.foundation.text.KeyboardOptions
//import androidx.compose.material.*
//import androidx.compose.material.MaterialTheme.colors
//import androidx.compose.material.icons.Icons
//import androidx.compose.material.icons.filled.Clear
//import androidx.compose.material.icons.outlined.ArrowBackIos
//import androidx.compose.material.icons.outlined.Check
//import androidx.compose.runtime.*
//import androidx.compose.runtime.saveable.rememberSaveable
//import androidx.compose.ui.Alignment
//import androidx.compose.ui.ExperimentalComposeUiApi
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.graphics.Color
//import androidx.compose.ui.graphics.Shape
//import androidx.compose.ui.platform.LocalContext
//import androidx.compose.ui.platform.LocalTextInputService
//import androidx.compose.ui.platform.LocalView
//import androidx.compose.ui.res.stringResource
//import androidx.compose.ui.text.font.FontWeight
//import androidx.compose.ui.text.input.KeyboardType
//import androidx.compose.ui.text.style.TextAlign
//import androidx.compose.ui.unit.dp
//import androidx.compose.ui.unit.sp
//import androidx.compose.ui.window.Dialog
//import androidx.compose.ui.window.DialogProperties
//import androidx.compose.ui.window.DialogWindowProvider
//import com.android.chatmeup.R
//import com.android.chatmeup.ui.theme.cmuBlue
//import com.android.chatmeup.ui.theme.cmuOffWhite
//import com.togitech.ccp.component.*
//import com.togitech.ccp.data.utils.*
//import com.togitech.ccp.transformation.PhoneNumberTransformation
//
//const val MAX_PHONE_NO_LENGTH: Int = 15
//private var fullNumberState: String by mutableStateOf("")
//private var checkNumberState: Boolean by mutableStateOf(false)
//private var phoneNumberState: String by mutableStateOf("")
//private var countryCodeState: String by mutableStateOf("")
//
//@OptIn(ExperimentalComposeUiApi::class)
//@Composable
//fun InputPhoneNoDialog(
//    isInputPhoneNoDialogVisible: MutableState<Boolean>,
//    phoneNo: MutableState<String>,
//    isValidPhoneNo: MutableState<Boolean>,
//    inputPhoneNoEventState: InputPhoneNoEventState,
//    onBackClick: () -> Unit,
//    onContinueClick: () -> Unit
//){
//    var isValidPhone by remember { mutableStateOf(true) }
//    if(isInputPhoneNoDialogVisible.value){
//        Dialog(onDismissRequest =
//        {
//            onBackClick()
//        },
//            properties = DialogProperties(usePlatformDefaultWidth = false,
//                dismissOnBackPress = true,
//            )
//        ) {
//            val window = LocalView.current.parent as DialogWindowProvider
//            val wlp: WindowManager.LayoutParams = window.window.getAttributes()
//            SideEffect {
////                window.window.getDecorView().setSystemUiVisibility(
//////                    View.SYSTEM_UI_FLAG_HIDE_NAVIGATION or View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION or
////                            View.SYSTEM_UI_FLAG_LAYOUT_STABLE or View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY or
////                            View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN or View.SYSTEM_UI_FLAG_FULLSCREEN
////                )
////                window.window.getDecorView().setOnSystemUiVisibilityChangeListener(
////                    View.OnSystemUiVisibilityChangeListener {
////                        window.window.getDecorView()
////                            .setSystemUiVisibility(
////                                View.SYSTEM_UI_FLAG_HIDE_NAVIGATION or View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION or
////                                        View.SYSTEM_UI_FLAG_LAYOUT_STABLE or View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY or
////                                        View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN or View.SYSTEM_UI_FLAG_FULLSCREEN
////                            )
////                    }
////                )
//                window.window.attributes.windowAnimations =
//                    R.style.ChatMeUpSlideUpAndDownBottomDialogAnimation9
//                wlp.gravity = Gravity.BOTTOM
//                wlp.flags = wlp.flags and WindowManager.LayoutParams.FLAG_BLUR_BEHIND.inv()
//                window.window.setAttributes(wlp)
//                window.window.setGravity(Gravity.BOTTOM)
//            }
//
//            Scaffold(topBar = {
//                TopAppBar {
//                    onBackClick()
//                }
//            }) {
//                Box(
//                    modifier = Modifier
//                        .fillMaxSize()
//                        .padding(it)
//                ) {
//                    Box(modifier = Modifier.align(Alignment.TopStart)) {
//                        Column() {
//                            Spacer(modifier = Modifier.height(100.dp))
//                            Text(
//                                text = "Enter Your Phone Number",
//                                modifier = Modifier
//                                    .padding(start = 35.dp, end = 35.dp)
//                                    .align(Alignment.CenterHorizontally),
//                                style = MaterialTheme.typography.h5,
//                                textAlign = TextAlign.Center,
//                                fontWeight = FontWeight.Bold,
//                                fontSize = 28.sp
//                            )
//                            Spacer(modifier = Modifier.height(10.dp))
//                            Text(
//                                text = "Please confirm your country code and enter your phone number",
//                                modifier = Modifier.padding(start = 38.dp, end = 38.dp),
//                                style = MaterialTheme.typography.body1,
//                                textAlign = TextAlign.Center,
//                                fontWeight = FontWeight.Medium
//                            )
//                            PhoneNumberTextField(
//                                modifier = Modifier.padding(top = 50.dp),
//                                text = phoneNo.value,
//                                onValueChange = {
//                                    if (phoneNo.value.length < MAX_PHONE_NO_LENGTH) {
//                                        phoneNo.value = it
//                                    }
//                                },
//                                focusedBorderColor = colors.primary,
//                                unfocusedBorderColor = colors.primary,
//                                isValidPhoneNo = isValidPhoneNo
//                            )
//                        }
//                    }
//                    Box(
//                        Modifier
//                            .align(Alignment.BottomCenter)
//                            .fillMaxWidth()
//                            .padding(bottom = 20.dp, start = 20.dp, end = 20.dp)
//                    ) {
//                        InputPhoneNoBottomSection(
//                            inputPhoneNoEventState = inputPhoneNoEventState,
//                            onContinueClick = onContinueClick
//                        )
//                    }
//                }
//            }
//        }
//    }
//}
//
//@Composable
//fun PhoneNumberTextField(
//    modifier: Modifier = Modifier,
//    text: String,
//    onValueChange: (String) -> Unit,
//    shape: Shape = RoundedCornerShape(4.dp),
//    color: Color = Color.Transparent,
//    showCountryCode: Boolean = true,
//    showCountryFlag: Boolean = true,
//    focusedBorderColor: Color = Color.Transparent,
//    unfocusedBorderColor: Color = Color.Transparent,
//    cursorColor: Color = colors.primary,
//    bottomStyle: Boolean = false,
//    isValidPhoneNo: MutableState<Boolean>,
//) {
//    val context = LocalContext.current
//    var errorState by remember{
//        mutableStateOf(false)
//    }
//    var textFieldValue by rememberSaveable { mutableStateOf("") }
//    val keyboardController = LocalTextInputService.current
//    var phoneCode by rememberSaveable {
//        mutableStateOf(
//            getDefaultPhoneCode(
//                context
//            )
//        )
//    }
//    var defaultLang by rememberSaveable {
//        mutableStateOf(
//            getDefaultLangCode(context)
//        )
//    }
//
//    fullNumberState = phoneCode + textFieldValue
//    phoneNumberState = textFieldValue
//    countryCodeState = defaultLang
//
//
//    Surface(color = color) {
//        Column(modifier = Modifier.padding(horizontal = 16.dp, vertical = 16.dp)) {
//            if (bottomStyle) {
//                TogiCodeDialog(
//                    pickedCountry = {
//                        phoneCode = it.countryPhoneCode
//                        defaultLang = it.countryCode
//                    },
//                    defaultSelectedCountry = getLibCountries.single { it.countryCode == defaultLang },
//                    showCountryCode = showCountryCode,
//                    showFlag = showCountryFlag,
//                    showCountryName = true
//                )
//            }
//            Row(
//                verticalAlignment = Alignment.CenterVertically,
//                horizontalArrangement = Arrangement.Center
//            ) {
//                OutlinedTextField(modifier = modifier.fillMaxWidth(),
//                    shape = shape,
//                    value = textFieldValue,
//                    onValueChange = {
//                        if(it.length < MAX_PHONE_NO_LENGTH){textFieldValue = it}
//                        if(phoneCode + text != phoneCode+it){ onValueChange(phoneCode+it) }
//                    },
//                    singleLine = true,
//                    colors = TextFieldDefaults.outlinedTextFieldColors(
//                        focusedBorderColor = if (getErrorStatus()) Color.Red else focusedBorderColor,
//                        unfocusedBorderColor = if (getErrorStatus()) Color.Red else unfocusedBorderColor,
//                        cursorColor = cursorColor,
//                    ),
//                    visualTransformation = PhoneNumberTransformation(getLibCountries.single { it.countryCode == defaultLang }.countryCode.uppercase()),
//                    placeholder = { Text(text = stringResource(id = getNumberHint(getLibCountries.single { it.countryCode == defaultLang }.countryCode.lowercase()))) },
//                    keyboardOptions = KeyboardOptions.Default.copy(
//                        keyboardType = KeyboardType.NumberPassword,
//                        autoCorrect = true,
//                    ),
//                    keyboardActions = KeyboardActions(onDone = {
//                        keyboardController?.hideSoftwareKeyboard()
//                        errorState = getErrorStatus()
//                    }),
//                    leadingIcon = {
//                        if (!bottomStyle)
//                            Row {
//                                Column {
//                                    Card(backgroundColor = colors.onBackground,
//                                    shape = shape){
//                                        TogiCodeDialog(
//                                            pickedCountry = {
//                                                phoneCode = it.countryPhoneCode
//                                                defaultLang = it.countryCode
//                                            },
//                                            defaultSelectedCountry = getLibCountries.single { it.countryCode == defaultLang },
//                                            showCountryCode = showCountryCode,
//                                            showFlag = showCountryFlag
//                                        )
//                                    }
//                                }
//                                Spacer(
//                                    modifier = Modifier.width(10.dp)
//                                )
//                            }
//                    },
//                    trailingIcon = {
//                        IconButton(onClick = {
//                            textFieldValue = ""
//                            onValueChange("")
//                        }) {
//                            Icon(
//                                imageVector = Icons.Filled.Clear,
//                                contentDescription = "Clear",
//                                tint = if (getErrorStatus()) Color.Red else MaterialTheme.colors.onSurface
//                            )
//                        }
//                    })
//            }
//            if (isValidPhoneNo.value) Text(
//                text = "Invalid Number",
//                color = MaterialTheme.colors.error,
//                style = MaterialTheme.typography.caption,
//                fontWeight = FontWeight.Bold,
//                modifier = Modifier.padding(top = 0.8.dp)
//            )
//        }
//    }
//}
//
//@Composable
//fun TopAppBar(onBackClick : () -> Unit){
//    Surface(modifier = Modifier
//        .fillMaxWidth()
//        .height(70.dp),
//        color = colors.background,
//        contentColor = colors.primary
//    ) {
//        Row(){
//            Icon(
//                imageVector = Icons.Outlined.ArrowBackIos,
//                contentDescription = "Back Button",
//                modifier = Modifier
//                    .clickable { onBackClick() }
//                    .padding(15.dp)
//            )
//        }
//    }
//}
//
//@Composable
//fun InputPhoneNoBottomSection(
//    inputPhoneNoEventState: InputPhoneNoEventState,
//    onContinueClick : () -> Unit
//){
//    Column() {
//        Button(modifier = Modifier
//            .height(60.dp)
//            .fillMaxWidth()
//            .animateContentSize()
//            ,
//            onClick = {
//                onContinueClick()
//                //your onclick code here
//            },elevation =  ButtonDefaults.elevation(
//                defaultElevation = 0.dp,
//                pressedElevation = 5.dp,
//                disabledElevation = 0.dp
//            ), colors = ButtonDefaults.buttonColors(backgroundColor = cmuBlue),
//            shape = RoundedCornerShape(30.dp)
//        ) {
//            when(inputPhoneNoEventState){
//                InputPhoneNoEventState.INIT -> Text(
//                    text = "Continue",
//                    style = MaterialTheme.typography.body2,
//                    color = cmuOffWhite
//                )
//                InputPhoneNoEventState.LOADING -> {
//                    CircularProgressIndicator(color = cmuOffWhite, modifier = Modifier.padding(top = 2.dp, bottom = 2.dp), strokeWidth = 2.dp)
//                }
//                InputPhoneNoEventState.DONE -> {
//                    Icon(
//                        imageVector = Icons.Outlined.Check,
//                        contentDescription = null,
//                        modifier = Modifier
//                            .fillMaxSize()
//                            .padding(2.dp)
//                    )
//                }
//                InputPhoneNoEventState.ERROR -> {
//                    TODO()
//                }
//            }
//        }
//    }
//}