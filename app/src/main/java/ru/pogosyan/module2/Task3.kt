package ru.pogosyan.module2

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextIndent
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

// Вариант 1: зелёный шрифт 16.sp, курсив, выравнивание по центру
@Composable
fun GreenItalicText(modifier: Modifier = Modifier) {
    Text(
        text = stringResource(R.string.jetpack_compose_description),
        color = Color(0xFF2E7D32),
        fontSize = 16.sp,
        fontStyle = FontStyle.Italic,
        textAlign = TextAlign.Center,
        modifier = modifier.fillMaxWidth()
    )
}

// Вариант 2: одна строка, в конце — многоточие
@Composable
fun OneLineText(modifier: Modifier = Modifier) {
    Text(
        text = stringResource(R.string.jetpack_compose_description),
        maxLines = 1,
        overflow = TextOverflow.Ellipsis,
        modifier = modifier
    )
}

// Вариант 3: отступ первой строки 48.sp, размер 24.sp, чёрный шрифт, зелёный фон, подчёркивание
@Composable
fun IndentedUnderlinedText(modifier: Modifier = Modifier) {
    Text(
        text = stringResource(R.string.jetpack_compose_description),
        fontSize = 24.sp,
        color = Color.Black,
        textDecoration = TextDecoration.Underline,
        style = TextStyle(textIndent = TextIndent(firstLine = 48.sp)),
        modifier = modifier.background(Color.Green)
    )
}

@Composable
fun JetpackTextVariants(modifier: Modifier = Modifier) {
    Column(modifier = modifier.padding(8.dp)) {
        GreenItalicText()
        Spacer(modifier = Modifier.height(16.dp))
        OneLineText()
        Spacer(modifier = Modifier.height(16.dp))
        IndentedUnderlinedText()
    }
}

@Preview(name = "Зелёный курсив", showBackground = true)
@Composable
fun GreenItalicTextPreview() {
    GreenItalicText()
}

@Preview(name = "Одна строка", showBackground = true)
@Composable
fun OneLineTextPreview() {
    OneLineText()
}

@Preview(name = "Отступ и подчёркивание", showBackground = true)
@Composable
fun IndentedUnderlinedTextPreview() {
    IndentedUnderlinedText()
}
