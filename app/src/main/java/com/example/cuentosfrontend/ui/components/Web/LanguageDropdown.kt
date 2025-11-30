package com.example.cuentosfrontend.screens

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Language
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.cuentosfrontend.data.DTO.Language

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LanguageDropdown(
    languages: List<Language>,
    selectedLanguage: Language,
    accentColor: Color,
    onLanguageSelected: (Language) -> Unit
) {
    var expanded by remember { mutableStateOf(false) }

    ExposedDropdownMenuBox(
        expanded = expanded,
        onExpandedChange = { expanded = !expanded },
        modifier = Modifier.fillMaxWidth()
    ) {
        OutlinedTextField(
            readOnly = true,
            value = selectedLanguage.name,
            onValueChange = {},
            label = { Text("Idioma", color = accentColor) },
            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.Language,
                    contentDescription = null,
                    tint = accentColor
                )
            },
            trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(expanded = expanded) },
            modifier = Modifier.menuAnchor().fillMaxWidth(),
            shape = RoundedCornerShape(24.dp),
            textStyle = LocalTextStyle.current.copy(color = accentColor),
            colors = TextFieldDefaults.colors(
                focusedContainerColor = Color.White,
                unfocusedContainerColor = Color.White,
                focusedIndicatorColor = accentColor,
                unfocusedIndicatorColor = accentColor.copy(alpha = 0.5f),
                cursorColor = accentColor
            )
        )

        ExposedDropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false }
        ) {
            languages.forEach { lang ->
                DropdownMenuItem(
                    text = { Text(lang.name, color = accentColor) },
                    onClick = {
                        onLanguageSelected(lang)
                        expanded = false
                    }
                )
            }
        }
    }
}
