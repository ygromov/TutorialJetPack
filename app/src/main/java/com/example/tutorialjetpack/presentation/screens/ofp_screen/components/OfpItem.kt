package com.example.tutorialjetpack.presentation.screens.ofp_screen.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.example.tutorialjetpack.R
import com.example.tutorialjetpack.domain.model.OfpFieldModel


@Composable
fun ofpItem(ofpField: List<OfpFieldModel>) {
    val push = remember {
        mutableListOf(
            mutableStateOf(""),
            mutableStateOf(""),
            mutableStateOf(""),
            mutableStateOf(""),
            mutableStateOf("")
        )
    }
    LazyColumn(
        modifier = Modifier
            .fillMaxWidth()
            //.padding(horizontal = 8.dp, vertical = 8.dp)
            .background(Color.White)
    ) {
        itemsIndexed(ofpField) { index, item ->
            ofpField(ofpFieldModel = item, text = push, index = index,
                onValueChange = { newText ->
                    push[index].value = newText
                })
        }
    }
}

