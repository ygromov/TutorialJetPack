
package com.example.tutorialjetpack.presentation.screens.retry_ofp.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.tutorialjetpack.R
import com.example.tutorialjetpack.presentation.screens.details_screen.DetailsScreenEvent
import com.example.tutorialjetpack.presentation.screens.retry_ofp.RetryOfpEvent

@Composable
fun DetailsTopBar(
    onEvent: (DetailsScreenEvent) -> Unit
) {
    Row(
        horizontalArrangement = Arrangement.End,
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 8.dp)
    ) {
        Button(
            modifier =Modifier.padding(end =8.dp),
            elevation = ButtonDefaults.elevation(
                defaultElevation = 8.dp,
                pressedElevation = 16.dp
            ),
            colors = ButtonDefaults.buttonColors(
                backgroundColor = MaterialTheme.colors.primaryVariant,
                contentColor = MaterialTheme.colors.primary
            ),
            onClick = {
                onEvent.invoke(DetailsScreenEvent.ToOfpScreen)
            }) {
            Icon(painter = painterResource(id = R.drawable.ic_test_ofp2), contentDescription = "")
        }
        Button(
            modifier =Modifier.padding(end =8.dp),
            elevation = ButtonDefaults.elevation(
                defaultElevation = 8.dp,
                pressedElevation = 16.dp
            ),
            colors = ButtonDefaults.buttonColors(
                backgroundColor = MaterialTheme.colors.primaryVariant,
                contentColor = MaterialTheme.colors.primary
            ),
            onClick = {
                onEvent.invoke(DetailsScreenEvent.ToTrainingScreen)
            }) {
            Icon(painter = painterResource(id = R.drawable.ic_test_ofp4), contentDescription = "")
        }
        Button(
            elevation = ButtonDefaults.elevation(
                defaultElevation = 8.dp,
                pressedElevation = 16.dp
            ),
            colors = ButtonDefaults.buttonColors(
                backgroundColor = MaterialTheme.colors.primaryVariant,
                contentColor = MaterialTheme.colors.primary
            ),
            onClick = {
                onEvent.invoke(DetailsScreenEvent.ToJournalScreen)
            }) {
            Icon(painter = painterResource(id = R.drawable.settings), contentDescription = "")
        }


    }
}