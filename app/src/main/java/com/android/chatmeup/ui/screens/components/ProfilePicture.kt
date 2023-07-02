package com.android.chatmeup.ui.screens.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Circle
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImagePainter
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import com.android.chatmeup.ui.theme.cmuLightGrey
import com.android.chatmeup.ui.theme.neutral_disabled
import com.android.chatmeup.ui.theme.success_green
import com.google.accompanist.placeholder.PlaceholderHighlight
import com.google.accompanist.placeholder.placeholder
import com.google.accompanist.placeholder.shimmer
import timber.log.Timber

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProfilePicture(
    modifier: Modifier = Modifier,
    imageObj: Any,
    isOnline: Boolean = false,
    size: Dp = 60.dp,
    shape: Shape = RoundedCornerShape(30),
){
    val painter = rememberAsyncImagePainter(
        model = ImageRequest.Builder(LocalContext.current)
            .data(imageObj)
            .size(coil.size.Size.ORIGINAL) // Set the target size to load the image at.
            .build()
    )

    BadgedBox(
        modifier = modifier
            .size(size)
            .placeholder(
                visible = painter.state == AsyncImagePainter.State.Loading(painter),
                highlight = PlaceholderHighlight.shimmer(
                    highlightColor = neutral_disabled
                ), color = cmuLightGrey, shape = shape
            ),
        badge = {
            if(isOnline){
                Card(
                    modifier = Modifier
                        .size(size / 3)
                        .offset(x = (-(size.value / 6)).dp, y = (size.value / 6).dp),
                    shape = CircleShape,
                    colors = CardDefaults.cardColors(
                        containerColor = MaterialTheme.colorScheme.background
                    )
                ) {
                    Icon(
                        modifier = Modifier
//                        .align(Alignment.TopEnd)
                            .padding((size.value / 30).dp),
                        imageVector = Icons.Default.Circle,
                        contentDescription = null,
                        tint = success_green
                    )
                }
            }
        },
    ){
        Timber.tag("ProfilePicture").d("painter.state is ${painter.state}")
        if(painter.state is AsyncImagePainter.State.Success){
            Image(
                modifier = Modifier
                    .clip(shape)
                    .fillMaxSize(),
                contentScale = ContentScale.Crop,
                painter = painter,
                contentDescription = "Profile picture"
            )
        }
        else{
            Icon(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(10.dp),
                imageVector = Icons.Default.Person,
                contentDescription = "Upload profile picture"
            )
        }
    }
}