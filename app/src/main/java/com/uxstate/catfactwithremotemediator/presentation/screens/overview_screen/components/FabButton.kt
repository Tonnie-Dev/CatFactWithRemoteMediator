package com.uxstate.catfactwithremotemediator.presentation.screens.overview_screen.components

import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.uxstate.catfactwithremotemediator.R
import com.uxstate.catfactwithremotemediator.util.LocalSpacing

@Composable
fun FabButton(
    onRefresh: () -> Unit
) {

    val spacing = LocalSpacing.current
Surface(shape = CircleShape, color = Color(0xFFFF007F), elevation = 5.dp) {
    IconButton(onClick = onRefresh, modifier = Modifier.size(spacing.spaceExtraLarge)) {
        Icon(
                imageVector = Icons.Default.Refresh,
                contentDescription = stringResource(id = R.string.refresh_label),
                tint = MaterialTheme.colors.onPrimary
        )
    }
  }
}

@Preview
@Composable
fun FabButtonPreview() {
FabButton {

}
}