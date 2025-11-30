package com.example.cuentosfrontend.ui.components.Avatares

import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp

@Composable
fun AnimatedAvatar(
    avatarRes: Int,
    isSelected: Boolean,
    modifier: Modifier = Modifier
) {
    val animatedAvatar = AvatarConstants.animatedAvatars[avatarRes]

    val smallSize = 150.dp
    val largeSize = 200.dp

    val size by animateDpAsState(targetValue = if (isSelected) largeSize else smallSize)

    Box(modifier = modifier.size(size)) {
        if (animatedAvatar != null) {
            if (isSelected) {
                // Si tiene loopAnimation, mostrar GIF animado, si no solo estático
                GifImage(
                    gifRes = animatedAvatar.loopAnimation,
                    modifier = Modifier.fillMaxSize()
                )
            } else {
                Image(
                    painter = painterResource(id = animatedAvatar.staticImage),
                    contentDescription = null,
                    modifier = Modifier.fillMaxSize()
                )
            }
        } else {
            // No tiene animación, solo imagen estática
            Image(
                painter = painterResource(id = avatarRes),
                contentDescription = null,
                modifier = Modifier.fillMaxSize()
            )
        }
    }
}
