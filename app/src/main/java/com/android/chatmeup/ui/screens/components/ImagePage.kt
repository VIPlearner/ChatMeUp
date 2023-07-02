package com.android.chatmeup.ui.screens.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import coil.compose.rememberAsyncImagePainter

@Composable
fun ImagePage(
    title: String,
    imageObj: Any,
    onBackClick: () -> Unit,
){

    Scaffold(
        containerColor = Color.Black,
        modifier = Modifier.fillMaxSize(),
        topBar = {
            CmuTopBar(
                Modifier,
                title,
                Color.White,
                true,
                onBackClick,
            ) }
    ) {
       Box(modifier = Modifier.padding(it)){
           Image(
               painter = rememberAsyncImagePainter(imageObj),
               contentDescription = "Profile Picture",
               modifier = Modifier
                   .fillMaxSize()
                   .align(Alignment.Center),
               contentScale = ContentScale.Fit
           )
       }
    }
}