package com.uxstate.catfactwithremotemediator.presentation.screens.overview_screen.components

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
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import com.uxstate.catfactwithremotemediator.R
import com.uxstate.catfactwithremotemediator.util.LocalSpacing

@Composable
fun TopRow(modifier: Modifier = Modifier, pos:Int, prev:Int?, next:Int?, onClick: () -> Unit) {

    val spacing = LocalSpacing.current
    Row(
            modifier = modifier.padding(spacing.spaceSmall),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceEvenly
    ) {



        val text = buildAnnotatedString {

            append("Prev Page: $prev")
            withStyle(style = SpanStyle(color = MaterialTheme.colors.primary, fontWeight = FontWeight.Bold)){

                append("Curr Page: $pos")
            }
            append("Next Page: $next")

        }
        //Page Text
        Text(text = text, style = MaterialTheme.typography.h5)


    }


}

@Preview
@Composable
fun TopRowPreview() {
    TopRow(modifier = Modifier.fillMaxWidth(), 3,1,3) {}
}