package com.uxstate.catfactwithremotemediator.presentation.screens.overview_screen.components

import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.uxstate.catfactwithremotemediator.R

@Composable
fun FabButton(
    onRefresh: () -> Unit
) {
    IconButton(onClick = onRefresh) {
        Icon(
                imageVector = Icons.Default.Refresh,
                contentDescription = stringResource(id = R.string.refresh_label)
        )
    }
}

