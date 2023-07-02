package com.android.chatmeup.ui.screens.login
//
//import androidx.lifecycle.ViewModel
//import androidx.lifecycle.ViewModelProvider
//import kotlinx.coroutines.flow.MutableStateFlow
//
//enum class LoginStatus{
//    INIT,
//    INPUT_PHONE_NO,
//    INPUT_CODE,
//}
//
//enum class InputPhoneNoEventState{
//    INIT,
//    LOADING,
//    ERROR,
//    DONE
//}
//
//class LoginPageViewModel: ViewModel() {
//    val loginEventStatus = MutableStateFlow(LoginStatus.INIT)
//    val inputPhoneNoEventState = MutableStateFlow(InputPhoneNoEventState.INIT)
//
//    val phoneNo = MutableStateFlow("")
//
//    fun onEventTriggered(
//        event: LoginEvents
//    ){
//        when(event){
//            LoginEvents.InitLoginEvent -> {
//                loginEventStatus.value = LoginStatus.INIT
//            }
//            LoginEvents.InputCodeEvent -> {
//                loginEventStatus.value = LoginStatus.INPUT_CODE
//            }
//            LoginEvents.InputPhoneNoEvent -> {
//                loginEventStatus.value = LoginStatus.INPUT_PHONE_NO
//            }
//        }
//    }
//
//    fun onInputPhoneNoEventTriggered(
//        event: InputPhoneNoEvents
//    ){
//        when(event){
//            InputPhoneNoEvents.InitPhoneNoEvent -> {
//                inputPhoneNoEventState.value = InputPhoneNoEventState.INIT
//            }
//            InputPhoneNoEvents.LoadingPhoneNoEvent -> {
//                //TODO :: I need to work on sending this info to firebase and sending a whatsapp message to the number
//                inputPhoneNoEventState.value = InputPhoneNoEventState.LOADING
//            }
//            InputPhoneNoEvents.DonePhoneNoEvent -> {
//                inputPhoneNoEventState.value = InputPhoneNoEventState.DONE
//                onEventTriggered(LoginEvents.InputCodeEvent)
//            }
//            InputPhoneNoEvents.ErrorPhoneNoEvent -> {
//                inputPhoneNoEventState.value = InputPhoneNoEventState.ERROR
//            }
//        }
//    }
//
//    sealed class LoginEvents(){
//        object InitLoginEvent: LoginEvents()
//        object InputPhoneNoEvent: LoginEvents()
//        object InputCodeEvent: LoginEvents()
//    }
//
//    sealed class InputPhoneNoEvents(){
//        object InitPhoneNoEvent: InputPhoneNoEvents()
//        object LoadingPhoneNoEvent: InputPhoneNoEvents()
//        object ErrorPhoneNoEvent: InputPhoneNoEvents()
//        object DonePhoneNoEvent: InputPhoneNoEvents()
//    }
//}