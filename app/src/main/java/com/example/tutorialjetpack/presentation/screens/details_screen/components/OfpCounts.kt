package com.example.tutorialjetpack.presentation.screens.details_screen.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.tutorialjetpack.ui.theme.White900

//@Preview
@Composable
fun OfpCounts(
    pullMax: Int,
    pushMax: Int,
    sitMax: Int,
    absMax: Int,
    extenMax: Int
    ) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 12.dp, end = 12.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Card() {
                Text(
                    text = "name",
                    color = MaterialTheme.colors.primary,
                    modifier = Modifier
                        .background(MaterialTheme.colors.primaryVariant)
                )
            }
            Card {
                Text(
                    text = "pull",
                    color = MaterialTheme.colors.primary,
                    modifier = Modifier
                        .background(MaterialTheme.colors.primaryVariant)
                )
            }
            Card {
                Text(
                    text = "push",
                    color = MaterialTheme.colors.primary,
                    modifier = Modifier
                        .background(MaterialTheme.colors.primaryVariant)
                )
            }
            Card {
                Text(
                    text = "squat",
                    color = MaterialTheme.colors.primary,
                    modifier = Modifier
                        .background(MaterialTheme.colors.primaryVariant)
                )
            }
            Card {
                Text(
                    text = "abs",
                    color = MaterialTheme.colors.primary,
                    modifier = Modifier
                        .background(MaterialTheme.colors.primaryVariant)
                )
            }
            Card {
                Text(
                    text = "extens",
                    color = MaterialTheme.colors.primary,
                    modifier = Modifier
                        .background(MaterialTheme.colors.primaryVariant)
                )
            }
        }

        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Card {
                Text(
                    text = "all",
                    color = MaterialTheme.colors.primary,
                    modifier = Modifier
                        .background(MaterialTheme.colors.primaryVariant)
                )
            }
            Card {
                Text(
                    text = pullMax.toString(),
                    color = MaterialTheme.colors.primary,
                    modifier = Modifier
                        .background(MaterialTheme.colors.primaryVariant)
                )
            }
            Card {
                Text(
                    text = pushMax.toString(),
                    color = MaterialTheme.colors.primary,
                    modifier = Modifier
                        .background(MaterialTheme.colors.primaryVariant)
                )
            }
            Card {
                Text(
                    text = sitMax.toString(),
                    color = MaterialTheme.colors.primary,
                    modifier = Modifier
                        .background(MaterialTheme.colors.primaryVariant)
                )
            }
            Card {
                Text(
                    text = absMax.toString(),
                    color = MaterialTheme.colors.primary,
                    modifier = Modifier
                        .background(MaterialTheme.colors.primaryVariant)
                )
            }
            Card {
                Text(
                    text = extenMax.toString(),
                    color = MaterialTheme.colors.primary,
                    modifier = Modifier
                        .background(MaterialTheme.colors.primaryVariant)
                )
            }
        }


        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Card {
                Text(
                    text = "month",
                    color = MaterialTheme.colors.primary,
                    modifier = Modifier
                        .background(MaterialTheme.colors.primaryVariant)
                )
            }
            Card {
                Text(
                    text = "234",
                    color = MaterialTheme.colors.primary,
                    modifier = Modifier
                        .background(MaterialTheme.colors.primaryVariant)
                )
            }
            Card {
                Text(
                    text = "433",
                    color = MaterialTheme.colors.primary,
                    modifier = Modifier
                        .background(MaterialTheme.colors.primaryVariant)
                )
            }
            Card {
                Text(
                    text = "2",
                    color = MaterialTheme.colors.primary,
                    modifier = Modifier
                        .background(MaterialTheme.colors.primaryVariant)
                )
            }
            Card {
                Text(
                    text = "121",
                    color = MaterialTheme.colors.primary,
                    modifier = Modifier
                        .background(MaterialTheme.colors.primaryVariant)
                )
            }
            Card {
                Text(
                    text = "23",
                    color = MaterialTheme.colors.primary,
                    modifier = Modifier
                        .background(MaterialTheme.colors.primaryVariant)
                )
            }
        }


        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Card {
                Text(
                    text = "week",
                    color = MaterialTheme.colors.primary,
                    modifier = Modifier
                        .background(MaterialTheme.colors.primaryVariant)
                )
            }
            Card {
                Text(
                    text = "234",
                    color = MaterialTheme.colors.primary,
                    modifier = Modifier
                        .background(MaterialTheme.colors.primaryVariant)
                )
            }
            Card {
                Text(
                    text = "435",
                    color = MaterialTheme.colors.primary,
                    modifier = Modifier
                        .background(MaterialTheme.colors.primaryVariant)
                )
            }
            Card {
                Text(
                    text = "2",
                    color = MaterialTheme.colors.primary,
                    modifier = Modifier
                        .background(MaterialTheme.colors.primaryVariant)
                )
            }
            Card {
                Text(
                    text = "123",
                    color = MaterialTheme.colors.primary,
                    modifier = Modifier
                        .background(MaterialTheme.colors.primaryVariant)
                )
            }
            Card {
                Text(
                    text = "23",
                    color = MaterialTheme.colors.primary,
                    modifier = Modifier
                        .background(MaterialTheme.colors.primaryVariant)
                )
            }
        }


        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Card {
                Text(
                    text = "day",
                    color = MaterialTheme.colors.primary,
                    modifier = Modifier
                        .background(MaterialTheme.colors.primaryVariant)
                )
            }
            Card {
                Text(
                    text = "234",
                    color = MaterialTheme.colors.primary,
                    modifier = Modifier
                        .background(MaterialTheme.colors.primaryVariant)
                )
            }
            Card {
                Text(
                    text = "433",
                    color = MaterialTheme.colors.primary,
                    modifier = Modifier
                        .background(MaterialTheme.colors.primaryVariant)
                )
            }
            Card {
                Text(
                    text = "2",
                    color = MaterialTheme.colors.primary,
                    modifier = Modifier
                        .background(MaterialTheme.colors.primaryVariant)
                )
            }
            Card {
                Text(
                    text = "123",
                    color = MaterialTheme.colors.primary,
                    modifier = Modifier
                        .background(MaterialTheme.colors.primaryVariant)
                )
            }
            Card {
                Text(
                    text = "23",
                    color = MaterialTheme.colors.primary,
                    modifier = Modifier
                        .background(MaterialTheme.colors.primaryVariant)
                )
            }
        }

    }
}