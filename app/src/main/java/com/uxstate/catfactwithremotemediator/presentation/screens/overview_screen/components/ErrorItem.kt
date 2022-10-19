package com.uxstate.catfacts.presentation.screens.overview_screen.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.uxstate.catfacts.R
import com.uxstate.catfacts.util.LocalSpacing

@Composable
fun ErrorItem(errorMessage: String = "Error Occurred!") {

    val spacing = LocalSpacing.current
    Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Image(
                painter = painterResource(id = R.drawable.ic_error),

                modifier = Modifier
                        .size(spacing.spaceOneHundred)
                        .padding(spacing.spaceSmall),
                contentDescription = stringResource(
                        R.string.error_message
                )
        )

        Text(
                text = errorMessage,
                color = MaterialTheme.colors.error,
                style = MaterialTheme.typography.h6,
                modifier = Modifier
        )

    }
}

@Preview
@Composable
fun ErrorItemPreview() {
    ErrorItem()
}