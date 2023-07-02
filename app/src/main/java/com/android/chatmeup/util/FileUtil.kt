package com.android.chatmeup.util

import java.io.File

fun clearDirectory(directory: File) {
    if (directory.isDirectory) {
        val files = directory.listFiles()
        if (files != null) {
            for (file in files) {
                if (file.isDirectory) {
                    clearDirectory(file)
                } else {
                    file.delete()
                }
            }
        }
    }
}