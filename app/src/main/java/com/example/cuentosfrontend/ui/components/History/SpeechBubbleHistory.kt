package com.example.cuentosfrontend.ui.components.History

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.cuentosfrontend.ui.theme.Flowers
import com.example.cuentosfrontend.ui.theme.Mystery_Regular



@Composable
fun SpeechBubbleHistory(
    text: String,
    modifier: Modifier = Modifier,
    backgroundColor: Color = Color(0xFFFFA726),
    textColor: Color = Color.White,
    fontSize: TextUnit = 16.sp
) {
    Box(
        modifier = modifier
            .background(backgroundColor, shape = RoundedCornerShape(8.dp))
            .padding(horizontal = 16.dp, vertical = 10.dp),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = text,
            color = textColor,
            fontSize = fontSize, // aquí ya no dependemos de bodyMedium
            fontFamily = Flowers,
            textAlign = TextAlign.Center,
            maxLines = 3,
            overflow = TextOverflow.Ellipsis
        )
    }
}


