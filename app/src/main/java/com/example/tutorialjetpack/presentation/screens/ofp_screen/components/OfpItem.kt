package com.example.tutorialjetpack.presentation.screens.ofp_screen.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.tutorialjetpack.domain.model.OfpFieldModel
import com.example.tutorialjetpack.presentation.screens.ofp_screen.OfpScreenEvent


@Composable
fun OfpItem(ofp: List<OfpFieldModel>, onEvent: (OfpScreenEvent) -> Unit) {
    LazyColumn(
        modifier = Modifier
            .fillMaxWidth()
            //.padding(horizontal = 8.dp, vertical = 8.dp)
            .background(MaterialTheme.colors.background)
    ) {
        itemsIndexed(ofp) { index, ofpModel ->
//            OfpField(
//                index = index, ofpModel = ofpModel, onEvent = onEvent
//            )
        }
    }
}
