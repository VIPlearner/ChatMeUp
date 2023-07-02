package com.android.chatmeup.ui.screens.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBackIosNew
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

@Composable
fun CmuTopBar(
    modifier: Modifier = Modifier,
    title: String = "Chats",
    color: Color = MaterialTheme.colorScheme.onBackground,
    shouldShowBackIcon: Boolean = false,
    onBackClick: () -> Unit = {},
    vararg icons: @Composable () -> Unit = emptyArray()
){
    Row(modifier = modifier
        .fillMaxWidth()
        .padding(horizontal = 15.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        if (shouldShowBackIcon){
            IconButton(onClick = onBackClick) {
                Icon(
                    imageVector = Icons.Default.ArrowBackIosNew,
                    contentDescription = "Back Button",
                    tint = color
                )
            }
            Spacer(modifier = Modifier.width(15.dp))
        }
        Text(
            text = title,
            modifier = Modifier.weight(1f),
            style = MaterialTheme.typography.headlineSmall,
            fontWeight = FontWeight.Medium,
            color = color
        )
        for(icon in icons){
            icon()
        }
    }
}