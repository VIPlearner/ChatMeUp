package com.android.chatmeup.ui.screens.components

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.dp
import com.android.chatmeup.ui.theme.cmuOffWhite

@Composable
fun CmuDarkButton(
    modifier: Modifier = Modifier,
    padding: PaddingValues = PaddingValues(start = 80.dp, end = 80.dp),
    label: String,
    isLoading: Boolean = false,
    shape: Shape = RoundedCornerShape(10.dp),
    onClick: () -> Unit
){
    Button(modifier = modifier
        .padding(padding)
        .height(50.dp)
        .fillMaxWidth(),
        onClick = {
            onClick()
                  },
        elevation =  ButtonDefaults.buttonElevation(
            defaultElevation = 0.dp,
            pressedElevation = 5.dp,
            disabledElevation = 0.dp),
        shape = shape,
//                ), colors = ButtonDefaults.buttonColors(backgroundColor = cmuBlue),
    ) {
        if (isLoading){
            CircularProgressIndicator(
                color = cmuOffWhite,
                modifier = Modifier.align(Alignment.CenterVertically)
                    .size(25.dp)
                ,
                strokeWidth = 2.dp
            )
        }
        else{
            Text(
                text = label,
                style = MaterialTheme.typography.labelLarge,
//                        color = cmuOffWhite
            )
        }
    }
}