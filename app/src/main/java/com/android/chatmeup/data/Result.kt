package com.android.chatmeup.data


sealed class Result<out R> {
    data class Success<out T>(val data: T? = null, val msg: String? = null) : Result<T>()
//    data class Changed<out T>(val data: T? = null, val msg: String? = null) : Result<T>()
//    data class Removed<out T>(val data: T? = null, val msg: String? = null) : Result<T>()
    class Error(val msg: String? = null) : Result<Nothing>()
    data class Progress(val double: Double) : Result<Nothing>()
    object Loading : Result<Nothing>()
}

//abstract class FirebaseChildListener<in T>(){
//    abstract fun onChanged(changedObj: T);
//    abstract fun onRemoved(removedObj: T)
//    abstract fun onAdded(addedObj: T)
//    abstract fun onCancelled(errorMsg: String)
//    abstract fun onMoved(movedObj: T)
//}
