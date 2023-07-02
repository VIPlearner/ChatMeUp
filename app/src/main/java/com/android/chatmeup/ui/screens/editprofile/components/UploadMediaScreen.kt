package com.android.chatmeup.ui.screens.editprofile.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Rotate90DegreesCcw
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import coil.compose.rememberAsyncImagePainter

@Composable
fun UploadImageScreen(
    imageObj: Any,
    onConfirmImage: (Any) -> Unit,
    onClickRotate: () -> Unit,
    onDismiss: () -> Unit
){
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = Color.Black
    ){
        Box(modifier = Modifier.fillMaxSize()) {
            Image(
                painter = rememberAsyncImagePainter(imageObj),
                contentDescription = "Profile Picture",
                modifier = Modifier
                    .fillMaxSize()
                    .align(Alignment.Center),
                contentScale = ContentScale.Fit
            )

            Row(
                modifier = Modifier
                    .align(Alignment.BottomCenter)
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceAround
            ) {
                TextButton(onClick = onDismiss) {
                    Text(
                        text = "Cancel",
                        color = Color.White,
                        style = MaterialTheme.typography.titleMedium
                    )
                }
                
                IconButton(onClick = onClickRotate) {
                    Icon(
                        imageVector = Icons.Outlined.Rotate90DegreesCcw,
                        contentDescription = "Rotate Image 90 degrees clockwise",
                        tint = Color.White
                    )
                }

                TextButton(onClick = { onConfirmImage(imageObj) }) {
                    Text(
                        text = "Done",
                        color = Color.White,
                        style = MaterialTheme.typography.titleMedium
                    )
                }
            }
        }
    }
}