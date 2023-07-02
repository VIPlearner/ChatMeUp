package com.android.chatmeup.ui.screens.editprofile.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.android.chatmeup.ui.theme.neutral_dark
import com.android.chatmeup.ui.theme.seed

@Composable
fun ProfileItem(
    modifier: Modifier = Modifier,
    label: String,
    value: String,
    description: String = "",
    icon: ImageVector,
    iconDescription: String,
    isEditable: Boolean,
    showDivider: Boolean,
    onClickEdit: () -> Unit,
){
    Surface(
        modifier = modifier
            .fillMaxWidth(),
        color = Color.Transparent,
        onClick = onClickEdit
    ){
        Row(modifier = Modifier.padding(start = 15.dp, end = 15.dp, top = 15.dp, bottom = 10.dp)) {
            Icon(
                modifier = Modifier
                    .padding(top = 10.dp)
                    .size(25.dp),
                imageVector = icon,
                contentDescription = iconDescription,
                tint = neutral_dark
            )
            Spacer(modifier = Modifier.width(20.dp))
            Column(modifier = Modifier.align(Alignment.Bottom)) {
                Row() {
                    Column(modifier = Modifier.weight(1f)) {
                        Text(
                            text = label,
                            style = MaterialTheme.typography.labelLarge,
                            fontWeight = FontWeight.Light,
                            textAlign = TextAlign.Start,
                            color = neutral_dark
                        )
                        Text(
                            text = value,
                            style = MaterialTheme.typography.titleMedium,
                            fontWeight = FontWeight.Normal,
                            textAlign = TextAlign.Start,
                            color = MaterialTheme.colorScheme.onBackground
                        )
                    }
                    if (isEditable) {
                        IconButton(
                            onClick = onClickEdit
                        ) {
                            Icon(
                                imageVector = Icons.Default.Edit,
                                contentDescription = "Edit $label",
                                tint = seed
                            )
                        }
                    }
                }
                if (description.isNotEmpty()) {
                    Text(
                        text = description,
                        style = MaterialTheme.typography.labelLarge,
                        fontWeight = FontWeight.Light,
                        textAlign = TextAlign.Start,
                        color = neutral_dark
                    )
                }
                if(showDivider){

                }
            }
        }
    }
}