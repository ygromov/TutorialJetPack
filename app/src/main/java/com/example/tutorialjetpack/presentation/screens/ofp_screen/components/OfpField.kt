package com.example.tutorialjetpack.presentation.screens.ofp_screen.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import com.example.tutorialjetpack.R
import com.example.tutorialjetpack.domain.model.OfpFieldModel
import com.example.tutorialjetpack.presentation.screens.ofp_screen.OfpScreenEvent

@Composable
fun OfpField(
//    text: List<MutableState<String>>,
    index: Int,
    ofpModel: OfpFieldModel,
    onEvent: (OfpScreenEvent) -> Unit
) {
//    var push: Int = 0
    Row(
        modifier = Modifier
            .fillMaxWidth()
            //.background(color = Color.Gray)
            .padding(start = 10.dp, end = 10.dp),
    ) {
        Icon(
            modifier = Modifier.weight(1f),
            imageVector = ImageVector.vectorResource(id = R.drawable.ic_test_ofp),
            contentDescription = "ic_test"
        )
//        Card(
//            //modifier = Modifier.padding(), elevation = 5.dp
//        ) {
            BasicTextField(
                value = ofpModel.value,
                onValueChange = { newValue ->
                    onEvent.invoke(OfpScreenEvent.ChangeOfpItem(newValue,index))
                },
                maxLines = 1,
                modifier = Modifier.defaultMinSize(minWidth = 40.dp).weight(1f)
                //,
                //keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
            )
//        }
        Text(
            modifier = Modifier.weight(1f),
            text = ofpModel.textNameExersize,
            //modifier = Modifier.padding(top = 5.dp, start = 5.dp)
        )
    }
}