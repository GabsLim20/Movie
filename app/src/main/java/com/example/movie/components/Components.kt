package com.example.movie.components

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle

@Composable
fun textStyled(
    modifier: Modifier = Modifier,
    text: String,
    color: Color,
    style: TextStyle
){
    Text(text = text,
        modifier = modifier,
        color = color,
        style = style
    )
}
