package com.android.chatmeup.util

import android.text.TextUtils
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Date
import java.util.Locale

fun String.isEmailValid(): Boolean {
    return !TextUtils.isEmpty(this) && android.util.Patterns.EMAIL_ADDRESS.matcher(this).matches()
}

fun isStrongPassword(password: String): Boolean {
    val minLength = 8
    val hasUppercase = password.any { it.isUpperCase() }
    val hasLowercase = password.any { it.isLowerCase() }
    val hasDigit = password.any { it.isDigit() }
    val hasSpecialChar = password.any { !it.isLetterOrDigit() }

    return password.length >= minLength && hasUppercase && hasLowercase && hasDigit && hasSpecialChar
}

fun isName(s: String): Int {
    return if (!s.all { it.isLetter() }) {  // check if string contains only letters
        -1
    } else if (s.length < 2) {  // check if string is too short to be a name
        -2
    } else 0
}

fun epochToHoursAndMinutes(epoch: Long): String {
    val date =
        Date(epoch)
    val formatter = SimpleDateFormat(
        "hh:mm a",
        Locale.getDefault()
    )

    return formatter.format(date)
}

fun epochToDayMonthYear(epoch: Long): String {
    val date =
        Date(epoch)
    val formatter = SimpleDateFormat(
        "dd MMM yy",
        Locale.getDefault()
    )

    return formatter.format(date)
}

fun convertEpochToString(epochTime: Long): String {
    val currentTime = System.currentTimeMillis()
    val currentCalendar = Calendar.getInstance()
    currentCalendar.timeInMillis = currentTime

    val epochCalendar = Calendar.getInstance()
    epochCalendar.timeInMillis = epochTime

    val dateFormatter = SimpleDateFormat("hh:mm a", Locale.getDefault())
    val dateFormat = SimpleDateFormat("dd MMM yy", Locale.getDefault())

    val currentDayStart = Calendar.getInstance()
    currentDayStart.set(Calendar.HOUR_OF_DAY, 0)
    currentDayStart.set(Calendar.MINUTE, 0)
    currentDayStart.set(Calendar.SECOND, 0)
    currentDayStart.set(Calendar.MILLISECOND, 0)

    val previousDayStart = Calendar.getInstance()
    previousDayStart.timeInMillis = currentDayStart.timeInMillis
    previousDayStart.add(Calendar.DAY_OF_MONTH, -1)

    return when {
        epochCalendar.after(currentDayStart) -> dateFormatter.format(Date(epochTime))
        epochCalendar.after(previousDayStart) -> "Yesterday"
        else -> dateFormat.format(Date(epochTime))
    }
}