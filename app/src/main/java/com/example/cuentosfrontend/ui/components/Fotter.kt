package com.example.cuentosfrontend.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
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
fun BotonEntrar(buttonText: String = "Entrar", onClick: () -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 24.dp),
        horizontalArrangement = Arrangement.End
    ) {
        Button(onClick = onClick) {
            Text(text = buttonText, fontSize = 18.sp)
        }
    }
}