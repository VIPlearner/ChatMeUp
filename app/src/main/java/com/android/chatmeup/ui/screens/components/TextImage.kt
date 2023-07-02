package com.android.chatmeup.ui.screens.components

import android.content.Context
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Download
import androidx.compose.material3.Card
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.IconButton
import androidx.compose.material3.ProgressIndicatorDefaults
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.android.chatmeup.data.DownloadState
import com.android.chatmeup.data.db.room_db.entity.RoomMessage
import com.android.chatmeup.ui.theme.neutral_disabled
import com.android.chatmeup.ui.theme.seed
import java.io.File


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TextImage(
    modifier: Modifier = Modifier,
    context: Context,
    roomMessage: RoomMessage,
    downloadState: DownloadState,
    onClick: () -> Unit,
){
    Card(
        shape = RoundedCornerShape(
            topStart = 15.dp,
            topEnd = 15.dp,
            bottomStart = 15.dp,
            bottomEnd = 15.dp
        ),
        onClick = onClick,
        modifier = modifier.wrapContentSize()
    ) {
        val thumbnailFile = roomMessage.localThumbnailPath?.let {
            val file = File(context.filesDir, it)
            file
        }
        when(downloadState){
            DownloadState.Downloaded -> {
                val file = roomMessage.localFilePath?.let { File(context.filesDir, it) }
                if(file != null && file.exists() && file.canRead()){
                    AsyncImage(
                        modifier = Modifier.heightIn(30.dp, 300.dp),
                        model = file,
                        contentScale = ContentScale.Crop,
                        contentDescription = ""
                    )
                }
            }
            is DownloadState.Downloading -> {
                // animation
                val progressAnimate by animateFloatAsState(
                    targetValue = downloadState.progress.toFloat(),
                    animationSpec = ProgressIndicatorDefaults.ProgressAnimationSpec
                )
                Box(
                    modifier = Modifier.heightIn(30.dp, 300.dp),
                ){
                    AsyncImage(
                        modifier = Modifier
                            .fillMaxSize()
                            .align(Alignment.Center)
                            .blur(20.dp),
                        model = thumbnailFile,
                        contentScale = ContentScale.Crop,
                        contentDescription = ""
                    )
                    Surface(
                        modifier = Modifier.fillMaxSize(),
                        color = neutral_disabled.copy(0.3f)
                    ) {
                        CircularProgressIndicator(
                            color = seed,
                            progress = progressAnimate,
                            modifier = Modifier.align(Alignment.Center)
                        )
                    }
                }
            }
            DownloadState.NotDownloaded -> {
                Box(
                    modifier = Modifier.heightIn(30.dp, 300.dp),
                ){
                    AsyncImage(
                        modifier = Modifier
                            .fillMaxSize()
                            .align(Alignment.Center)
                            .blur(20.dp),
                        model = thumbnailFile,
                        contentScale = ContentScale.Crop,
                        contentDescription = ""
                    )
                    Surface(
                        modifier = Modifier.fillMaxSize(),
                        color = neutral_disabled.copy(0.3f)
                    ) {
                        Card(
                            modifier = Modifier.wrapContentSize(),
                            onClick = {}
                        ) {
                            IconButton(onClick = { onClick() }) {
                                Icon(
                                    imageVector = Icons.Default.Download,
                                    contentDescription = "Download Image",
                                    tint = seed
                                )
                            }
                        }
                    }
                }
            }
            DownloadState.OnQueue -> {
                Box(
                    modifier = Modifier.heightIn(30.dp, 300.dp),
                ){
                    AsyncImage(
                        modifier = Modifier
                            .fillMaxSize()
                            .align(Alignment.Center)
                            .blur(20.dp),
                        model = thumbnailFile,
                        contentScale = ContentScale.Crop,
                        contentDescription = ""
                    )
                    Surface(
                        modifier = Modifier.fillMaxSize(),
                        color = neutral_disabled.copy(0.3f)
                    ) {
                        CircularProgressIndicator(
                            color = seed,
                            modifier = Modifier.align(Alignment.Center),
                            strokeWidth = 5.dp
                        )
                    }
                }
            }
        }
    }
}