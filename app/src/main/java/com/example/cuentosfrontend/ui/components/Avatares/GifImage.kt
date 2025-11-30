package com.example.cuentosfrontend.ui.components.Avatares

import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.decode.GifDecoder
import coil.request.ImageRequest
import androidx.compose.ui.graphics.ColorMatrix

@Composable
fun GifImage(
    gifRes: Int?,
    modifier: Modifier = Modifier,
    size: Dp = 200.dp
) {
    val saturationLevel = 0.96f // menos saturación, valor entre 0 y 1

    val colorMatrix = ColorMatrix().apply {
        setToSaturation(saturationLevel)
    }

    AsyncImage(
        model = ImageRequest.Builder(LocalContext.current)
            .data(gifRes)
            .decoderFactory(GifDecoder.Factory())
            .build(),
        contentDescription = null,
        modifier = modifier.size(size),
        colorFilter = ColorFilter.colorMatrix(colorMatrix)
    )
}

