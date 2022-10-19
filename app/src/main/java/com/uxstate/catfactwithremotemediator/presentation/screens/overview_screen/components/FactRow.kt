package com.uxstate.catfacts.presentation.screens.overview_screen.components

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ContentAlpha
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import com.uxstate.catfacts.util.LocalSpacing

@Composable
fun FactRow(modifier: Modifier = Modifier, fact: String) {
    val spacing = LocalSpacing.current
    Row(
            modifier = modifier
                    .padding(spacing.spaceExtraSmall)
                    .border(
                            width = spacing.spacingTwoDp,
                            color = Color.Gray,
                            shape = RoundedCornerShape(spacing.spaceSmall)
                    )
    ) {
        Text(
                text = fact, modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
                .padding(spacing.spaceMedium),
                style = MaterialTheme.typography.body1,
                color = Color.Black.copy(alpha = ContentAlpha.medium)
        )
    }




}


@Preview
@Composable
fun FactRowPreview() {
FactRow(fact = """
    
    Cat are beautiful and belong to the feline family from the 
    larger mammal family.Their young are called kittens and they
    have whisker. They like milk and meat.They are nocturnal animals
""".trimIndent())
}