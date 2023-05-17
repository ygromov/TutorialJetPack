package com.example.tutorialjetpack.presentation.screens.ofp_screen.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.example.tutorialjetpack.R
import com.example.tutorialjetpack.domain.model.OfpFieldModel

@Composable
fun ofpField(
    ofpFieldModel: OfpFieldModel,
    text: List<MutableState<String>>,
    index: Int,
    onValueChange: (String) -> Unit
) {
    var push: Int = 0
    Row(
        modifier = Modifier
            .fillMaxWidth()
            //.background(color = Color.Gray)
            .padding(start = 10.dp,end = 10.dp)
    ) {
        Icon(
            imageVector = ImageVector.vectorResource(id = R.drawable.ic_test_ofp),
            contentDescription = "ic_test"
        )
        Card(
            //modifier = Modifier.padding(), elevation = 5.dp
            ){
            BasicTextField(
                value = text[index].value,
                onValueChange = { newValue -> text[index].value = newValue },
                maxLines = 1,
                modifier = Modifier.defaultMinSize(minWidth = 40.dp)
                //,
                //keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
            )
        }
        Text(
            text = ofpFieldModel.textNameExersize,
            //modifier = Modifier.padding(top = 5.dp, start = 5.dp)
        )
    }
}