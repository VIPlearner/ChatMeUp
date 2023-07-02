package com.android.chatmeup.ui.cmutoast

import android.app.Activity
import android.content.Context
import android.widget.Toast
import androidx.core.content.res.ResourcesCompat
import com.android.chatmeup.R
import www.sanju.motiontoast.MotionToast
import www.sanju.motiontoast.MotionToastStyle

enum class CmuToastDuration {
    SHORT,
    LONG
}

enum class CmuToastStyle {
    INFO,
    WARNING,
    ERROR,
    SUCCESS
}

class CmuToast {
    companion object {

        fun createFancyToast(
            context: Context,
            activity: Activity?,
            title: String,
            message: String,
            style: CmuToastStyle,
            duration: CmuToastDuration,
        ){
            if (activity != null) {
                MotionToast.createColorToast(
                    activity,
                    title,
                    message,

                    when (style) {
                        CmuToastStyle.INFO -> MotionToastStyle.INFO
                        CmuToastStyle.WARNING -> MotionToastStyle.WARNING
                        CmuToastStyle.SUCCESS -> MotionToastStyle.SUCCESS
                        else -> MotionToastStyle.ERROR
                    },

                    MotionToast.GRAVITY_BOTTOM,

                    if (duration == CmuToastDuration.SHORT) MotionToast.SHORT_DURATION
                    else MotionToast.LONG_DURATION,

                    ResourcesCompat.getFont(activity, R.font.inter_regular)
                )
            } else {
                Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
            }
        }
    }
}