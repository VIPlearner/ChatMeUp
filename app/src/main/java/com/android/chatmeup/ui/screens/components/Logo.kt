package com.android.chatmeup.ui.screens.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.text.ExperimentalTextApi
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextMotion
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.android.chatmeup.ui.theme.md_theme_light_onPrimaryContainer
import com.android.chatmeup.ui.theme.md_theme_light_primary

@OptIn(ExperimentalTextApi::class)
@Composable
fun Logo(){
    Text(text = "ChatMeUp",
        style = TextStyle(
            brush = Brush.horizontalGradient(
                listOf(md_theme_light_primary, md_theme_light_onPrimaryContainer)
            ),
            fontSize = 50.sp,
            textMotion = TextMotion.Animated
        ),
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 25.dp, end = 25.dp),
        textAlign = TextAlign.Start,
//                color = cmuBlue
    )
}