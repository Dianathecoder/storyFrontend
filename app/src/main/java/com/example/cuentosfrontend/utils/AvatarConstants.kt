package com.example.cuentosfrontend.utils

import androidx.compose.ui.graphics.Color
import com.example.cuentosfrontend.R



data class AnimatedAvatar(
    val staticImage: Int,
    val animationOnce: Int?,
    val loopAnimation: Int,
    val animationDurationMs: Long
)

object AvatarConstants {

    // Lista de avatares disponibles
    val avatarList = listOf(
        R.drawable.dragon_estatico,
        R.drawable.cocodrilo_estatico,
        R.drawable.pajaro_estatico,
        R.drawable.perrita_estatica,
        R.drawable.zorro_estatico,
        R.drawable.tigre_estatico
    )

    val animatedAvatars = mapOf(
        R.drawable.tigre_estatico to AnimatedAvatar(
            staticImage = R.drawable.tigre_estatico,
            animationOnce = null,
            loopAnimation = R.drawable.tigre_anim,
            animationDurationMs = 2000L
        ),

        R.drawable.pajaro_estatico to AnimatedAvatar(
            staticImage = R.drawable.pajaro_estatico,
            animationOnce = null,
            loopAnimation = R.drawable.pajaro_anim,
            animationDurationMs = 2000L
        ),
        R.drawable.zorro_estatico to AnimatedAvatar(
            staticImage = R.drawable.zorro_estatico,
            animationOnce = null,
            loopAnimation = R.drawable.zorro_anim,
            animationDurationMs = 2000L
        ),
        R.drawable.perrita_estatica to AnimatedAvatar(
            staticImage = R.drawable.perrita_estatica,
            animationOnce = null,
            loopAnimation = R.drawable.perrita_anim,
            animationDurationMs = 2000L
        ),
        R.drawable.dragon_estatico to AnimatedAvatar(
            staticImage = R.drawable.dragon_estatico,
            animationOnce = null,
            loopAnimation = R.drawable.dragon_anim,
            animationDurationMs = 2000L
        ),
        R.drawable.cocodrilo_estatico to AnimatedAvatar(
            staticImage = R.drawable.cocodrilo_estatico,
            animationOnce = null,
            loopAnimation = R.drawable.cocodrilo_anim,
            animationDurationMs = 2000L
        )
    )


    val avatarBubbleColors = mapOf(
        R.drawable.dragon_anim to Color(0xFFFFF9C4), // Amarillo pastel
        R.drawable.cocodrilo_anim to Color(0xFFFFCDD2), // Rojo pastel
        R.drawable.pajaro_anim to Color(0xFFFFE0B2), // Naranja pastel
        R.drawable.perrita_anim to Color(0xFFC8E6C9),// Azul pastel
        R.drawable.zorro_anim to Color(0xFFE1BEE7), // Lila pastel
        R.drawable.tigre_anim to Color(0xFFB3E5FC) // Azul pastel suave
    )


    val avatarDescriptions = mapOf(
        R.drawable.dragon_anim to "Soy Drako, un dragón que protege las montañas.",
        R.drawable.cocodrilo_anim to "Soy Teo, el cocodrilo que vive en el río.",
        R.drawable.pajaro_anim to "Soy Lola, una pájara que vuela por los cielos.",
        R.drawable.perrita_anim to "Soy Teresa, una perrita amigable y aventurera.",
        R.drawable.zorro_anim to "Soy John, soy un zorro muy astuto.",
        R.drawable.tigre_anim to "Soy Oscar, un tigre que vive en la selva."
    )

    // Mapa avatar -> fondo asociado
    val avatarToFondoMap = mapOf(
        R.drawable.dragon_estatico to R.drawable.fondodragon,
        R.drawable.cocodrilo_estatico to R.drawable.fondococodrilo,
        R.drawable.pajaro_estatico to R.drawable.fondopajaro,
        R.drawable.perrita_estatica to R.drawable.fondoperro,
        R.drawable.zorro_estatico to R.drawable.fondozorro,
        R.drawable.tigre_estatico to R.drawable.fondotigre
    )

    val defaultFondo = R.drawable.fondodragon
}

