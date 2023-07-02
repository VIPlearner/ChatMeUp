package com.android.chatmeup.ui.screens.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CameraAlt
import androidx.compose.material.icons.filled.Photo
import androidx.compose.material3.BottomSheetDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.android.chatmeup.ui.theme.neutral_disabled
import com.android.chatmeup.ui.theme.seed

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun UploadFileOptionDialog(
    title: String = "Profile Photo",
    onTakePictureClicked: () -> Unit = {},
    onUploadFromStorageClicked: () -> Unit = {},
    onDelete: (() -> Unit)? = null
){
    Column {
        BottomSheetDefaults.DragHandle(
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )
        Text(
            text = title,
            style = MaterialTheme.typography.titleLarge,
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 25.dp, end = 25.dp),
            textAlign = TextAlign.Start
        )
        Row() {
            UploadFileOptionItem(
                modifier = Modifier,
                imageVector = Icons.Default.CameraAlt,
                onClick = onTakePictureClicked
            )
            UploadFileOptionItem(
                modifier = Modifier,
                imageVector = Icons.Default.Photo,
                onClick = onUploadFromStorageClicked
            )
        }
    }
}
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun UploadFileOptionItem(
    modifier: Modifier = Modifier,
    imageVector: ImageVector,
    onClick: () -> Unit
){
    Card(
        modifier = modifier
            .padding(18.dp)
            .size(50.dp),
        shape = CircleShape,
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.background,
            disabledContainerColor = MaterialTheme.colorScheme.background,
        ),
        border = BorderStroke(1.dp, neutral_disabled),
        onClick = onClick
    ) {
        Icon(
            modifier = Modifier
                .fillMaxSize()
                .padding(15.dp),
            imageVector = imageVector,
            contentDescription = null,
            tint = seed
        )
    }
}
