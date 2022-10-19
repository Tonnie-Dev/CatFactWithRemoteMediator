package com.uxstate.catfactwithremotemediator.presentation.screens.overview_screen.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun LoadingItem(modifier:Modifier = Modifier) {
    Column(
            modifier = modifier,
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally

    ) {


        CircularProgressIndicator()
    }
}


@Preview
@Composable
fun LoadingItemPreview() {
    LoadingItem()
}