package ru.pogosyan.module2

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.sp

// Задание 1. Приветствие по имени; если имя равно null — «Имя не задано»
@Composable
fun Hello(name: String?, modifier: Modifier = Modifier) {
    Text(
        text = if (name != null) "Привет, $name!" else "Имя не задано",
        fontSize = 28.sp,
        modifier = modifier
    )
}
