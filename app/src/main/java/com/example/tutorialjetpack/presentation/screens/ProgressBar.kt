package com.example.tutorialjetpack.presentation.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import com.example.tutorialjetpack.R

@Composable
fun ProgressBar() {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 10.dp, top = 10.dp, end = 10.dp)
    ) {

        Icon(
            imageVector = ImageVector.vectorResource(id = R.drawable.ic_test_ofp),
            contentDescription = "ic_test"
        )
        Icon(
            imageVector = ImageVector.vectorResource(id = R.drawable.ic_test_ofp),
            contentDescription = "ic_test_another"
        )
        Icon(
            imageVector = ImageVector.vectorResource(id = R.drawable.ic_test_ofp),
            contentDescription = "ic_test_another"
        )
        Icon(
            imageVector = ImageVector.vectorResource(id = R.drawable.ic_test_ofp2),
            contentDescription = "ic_test_another"
        )
        Icon(
            imageVector = ImageVector.vectorResource(id = R.drawable.ic_test_ofp2),
            contentDescription = "ic_test_another"
        )
        Icon(
            imageVector = ImageVector.vectorResource(id = R.drawable.ic_test_ofp2),
            contentDescription = "ic_test_another"
        )
        Icon(
            imageVector = ImageVector.vectorResource(id = R.drawable.ic_test_ofp3),
            contentDescription = "ic_test_another"
        )
        Icon(
            imageVector = ImageVector.vectorResource(id = R.drawable.ic_test_ofp3),
            contentDescription = "ic_test_another"
        )

        Icon(
            imageVector = ImageVector.vectorResource(id = R.drawable.ic_test_ofp3),
            contentDescription = "ic_test_another"
        )


    }
}
//error commit