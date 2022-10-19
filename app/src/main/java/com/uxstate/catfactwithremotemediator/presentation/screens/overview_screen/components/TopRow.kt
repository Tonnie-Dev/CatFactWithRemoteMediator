package com.uxstate.catfacts.presentation.screens.overview_screen.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.uxstate.catfacts.R
import com.uxstate.catfacts.util.LocalSpacing

@Composable
fun TopRow(modifier: Modifier = Modifier, pos:Int, prev:Int?, next:Int?, onClick: () -> Unit) {

    val spacing = LocalSpacing.current
    Row(
            modifier = modifier.padding(spacing.spaceSmall),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceEvenly
    ) {

        //Button
        Button(onClick = onClick, shape = RoundedCornerShape(spacing.spaceMedium)) {

            Text(text = stringResource(R.string.refresh_label), style = MaterialTheme.typography.h6)
        }

        //Page Text
        Text(text = "Pos: $pos Prev: $prev Next: $next", style = MaterialTheme.typography.h5)


    }


}

@Preview
@Composable
fun TopRowPreview() {
    TopRow(modifier = Modifier.fillMaxWidth(), 3,1,3) {}
}