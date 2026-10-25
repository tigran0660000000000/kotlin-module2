package ru.pogosyan.module2

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

// Задание 6.1. Круг исходного размера в правом верхнем углу чёрного компонента 240x120
@Composable
fun CircleTopEnd(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .size(width = 240.dp, height = 120.dp)
            .background(Color.Black)
    ) {
        Image(
            painter = painterResource(R.drawable.circle),
            contentDescription = "Круг",
            modifier = Modifier.align(Alignment.TopEnd)
        )
    }
}

// Задание 6.2. Синий фон, круг по центру растянут по размерам и окрашен в фиолетовый
@Composable
fun CircleStretched(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .size(width = 240.dp, height = 120.dp)
            .background(Color.Blue),
        contentAlignment = Alignment.Center
    ) {
        Image(
            painter = painterResource(R.drawable.circle),
            contentDescription = "Круг",
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.FillBounds,
            colorFilter = ColorFilter.tint(Color(0xFF822A8E))
        )
    }
}

@Preview(name = "CircleTopEnd", showSystemUi = true)
@Composable
fun CircleTopEndPreview() {
    PreviewScreen {
        CircleTopEnd()
    }
}

@Preview(name = "CircleStretched", showSystemUi = true)
@Composable
fun CircleStretchedPreview() {
    PreviewScreen {
        CircleStretched()
    }
}
