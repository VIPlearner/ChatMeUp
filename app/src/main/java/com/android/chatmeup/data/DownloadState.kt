package com.android.chatmeup.data

sealed class DownloadState(){
    object NotDownloaded: DownloadState()
    object OnQueue: DownloadState()
    data class Downloading(val progress: Double): DownloadState()
    object Downloaded: DownloadState()
}
