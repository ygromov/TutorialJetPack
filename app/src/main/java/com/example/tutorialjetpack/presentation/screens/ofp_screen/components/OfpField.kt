package com.example.tutorialjetpack.presentation.screens.ofp_screen.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.example.tutorialjetpack.R
import com.example.tutorialjetpack.domain.model.OfpFieldModel
import com.example.tutorialjetpack.presentation.screens.ofp_screen.OfpScreenEvent

@Composable
fun OfpField(
    index: Int,
    ofpModel: OfpFieldModel,
    onEvent: (OfpScreenEvent) -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 10.dp, top = 8.dp, end = 10.dp)
            .background(MaterialTheme.colors.background)
        ,
        horizontalArrangement = Arrangement.SpaceBetween,

    ) {
        Icon(
            modifier = Modifier.weight(1f).align(Alignment.CenterVertically),
            imageVector = ImageVector.vectorResource(id = R.drawable.ic_test_ofp4),
            contentDescription = "ic_test",

        )
        Card(
            modifier = Modifier.padding(start = 8.dp, top = 8.dp, end = 8.dp), elevation = 5.dp
        ) {
            TextField(
                value = ofpModel.value,
                onValueChange = { newValue ->
                    onEvent.invoke(OfpScreenEvent.ChangeOfpItem(newValue,index))
                },
                maxLines = 1,
                modifier = Modifier
                    .height(50.dp)
                    .width(60.dp),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                colors = TextFieldDefaults.textFieldColors(textColor = MaterialTheme.colors.primary, backgroundColor = MaterialTheme.colors.secondary)         //(textColor = Color.Red)
            )
        }
        Text(
            modifier = Modifier
                .weight(1f).align(Alignment.CenterVertically),
            text = ofpModel.textNameExersize,
            color = MaterialTheme.colors.primary
        )
    }
}