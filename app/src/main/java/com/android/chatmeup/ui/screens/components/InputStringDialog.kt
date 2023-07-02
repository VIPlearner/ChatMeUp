package com.android.chatmeup.ui.screens.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.isImeVisible
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material3.BottomSheetDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ProvideTextStyle
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.android.chatmeup.ui.theme.neutral_disabled
import com.android.chatmeup.ui.theme.seed

@OptIn(ExperimentalComposeUiApi::class, ExperimentalMaterial3Api::class,
    ExperimentalLayoutApi::class
)
@Composable
fun InputStringDialog(
    onDismissButtonClicked: () -> Unit,
    onConfirm: (String) -> Unit,
    instruction: String,
    input: String,
    onValueChanged: (String) -> Unit,
    textLengthRemaining: Int
){
    val keyboardController = LocalSoftwareKeyboardController.current
    if(!WindowInsets.isImeVisible)keyboardController?.show()
    Column(
        modifier = Modifier
            .statusBarsPadding()
            .navigationBarsPadding()
            .imePadding(),
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        BottomSheetDefaults.DragHandle(modifier = Modifier.align(Alignment.CenterHorizontally))
        Text(
            modifier = Modifier.padding(horizontal = 15.dp),
            text = instruction,
            style = MaterialTheme.typography.titleMedium,
            fontWeight = FontWeight.Normal,
            textAlign = TextAlign.Start,
            color = MaterialTheme.colorScheme.onBackground
        )
        CmuInputTextFieldWithLabel(
            placeholder = "Display Name",
            paddingValues = PaddingValues(start = 15.dp, end = 15.dp, top = 16.dp),
            text = input,
            onValueChanged = onValueChanged,
            trailingIcon = {
                Text(
                    text = textLengthRemaining.toString(),
                    overflow = TextOverflow.Ellipsis,
                    style = MaterialTheme.typography.labelLarge,
                    color = neutral_disabled
                )
            },
        )


        Box(
            modifier = Modifier
                .align(Alignment.End)
                .padding(bottom = 8.dp, end = 15.dp)
        ) {
            val textStyle =
                MaterialTheme.typography.titleMedium
            ProvideTextStyle(value = textStyle) {
                Row(
                ) {
                    TextButton(
                        onClick = onDismissButtonClicked,
                    ) {
                        Text(
                            "Cancel",
                            color = seed,
                            style = MaterialTheme.typography.titleMedium
                        )
                    }
                    TextButton(
                        onClick = {
                            onConfirm(input)
                        },
                    ) {
                        Text(
                            "Save",
                            color = seed,
                            style = MaterialTheme.typography.titleMedium
                        )
                    }
                }
            }
        }
    }
}