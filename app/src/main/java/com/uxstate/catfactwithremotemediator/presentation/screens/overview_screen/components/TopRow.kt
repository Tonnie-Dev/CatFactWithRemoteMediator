package com.uxstate.catfactwithremotemediator.presentation.screens.overview_screen.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.ContentAlpha
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import com.uxstate.catfactwithremotemediator.util.LocalSpacing

@Composable
fun TopRow(modifier: Modifier = Modifier, pos: Int, prev: Int?, next: Int?, onClick: () -> Unit) {

    val spacing = LocalSpacing.current
    Row(
            modifier = modifier.padding(spacing.spaceSmall),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceEvenly
    ) {


        val text = buildAnnotatedString {

            append("Prev Pg: $prev  ")
            withStyle(
                    style = SpanStyle(
                            color = Color(0xFFFF007F),
                            fontWeight = FontWeight.Bold,
                            fontSize = MaterialTheme.typography.h5.fontSize
                    )
            ) {

                append("Curr Pg: $pos  ")
            }
            append("Next Page: $next")

        }
        //Page Text
        Text(text = text, style = MaterialTheme.typography.body1, color = Color.Gray.copy(alpha = ContentAlpha.medium))


    }


}

@Preview
@Composable
fun TopRowPreview() {
    TopRow(modifier = Modifier.fillMaxWidth(), 3, 1, 3) {}
}