package com.example.cuentosfrontend.ui.components.Web

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp



@Composable
fun ButtonContinuar(buttonText: String = "Continuar", onClick: () -> Unit,modifier: Modifier = Modifier) {
        Button(
            onClick = onClick,
            modifier = modifier
        ) {
            Text(text = buttonText, fontSize = 20.sp)
        }
}

@Composable
fun ButtonConfirmar(buttonText: String = "Confirmar", onClick: () -> Unit,modifier: Modifier = Modifier) {
    Button(
        onClick = onClick,
        modifier = modifier
    ) {
        Text(text = buttonText, fontSize = 20.sp)
    }
}


@Composable
fun BotonEntrar(
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Button(
        onClick = onClick,
        modifier = modifier
            .fillMaxWidth() // esto asegura que ocupe todo el ancho disponible
            .height(50.dp),
        shape = RoundedCornerShape(24.dp)
    ) {
        Text(text = "Entrar")
    }
}
