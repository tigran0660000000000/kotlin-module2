package ru.pogosyan.module2

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.material3.MaterialTheme
import androidx.compose.ui.Modifier
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

// Обёртка для предпросмотра с системным UI: контент ниже строки состояния
@Composable
fun PreviewScreen(content: @Composable () -> Unit) {
    Module2Theme {
        Column(modifier = Modifier.fillMaxSize().safeDrawingPadding()) {
            content()
        }
    }
}

@Composable
fun Module2Theme(content: @Composable () -> Unit) {
    MaterialTheme(
        colorScheme = lightColorScheme(
            primary = Color(0xFF6200EE),
            secondary = Color(0xFF03DAC5)
        ),
        content = content
    )
}
