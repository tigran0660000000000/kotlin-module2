package ru.pogosyan.module2

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

private val primaryColor = Color(0xFF415F91)
private val secondaryColor = Color(0xFF565F71)
private val buttonTextColor = Color(0xFFFFFFFF)

const val DAILY_GOAL = 1500

// Задание 8. Трекер воды: +250 мл, завершение дня и счётчик дней подряд с нормой 1500 мл
@Composable
fun WaterTracker(modifier: Modifier = Modifier) {
    var waterCount by rememberSaveable { mutableIntStateOf(0) }
    var daysInRow by rememberSaveable { mutableIntStateOf(0) }
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "Трекер воды",
            fontSize = 32.sp,
            fontWeight = FontWeight.Bold,
            color = primaryColor
        )
        Spacer(modifier = Modifier.height(48.dp))
        Text(
            text = "$waterCount мл",
            fontSize = 48.sp,
            fontWeight = FontWeight.Bold,
            color = secondaryColor,
            modifier = Modifier.testTag("waterCount")
        )
        Spacer(modifier = Modifier.height(24.dp))
        Button(
            colors = ButtonDefaults.buttonColors(containerColor = primaryColor),
            onClick = { waterCount += 250 }
        ) {
            Text(
                text = "+250 мл",
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                color = buttonTextColor
            )
        }
        Spacer(modifier = Modifier.height(16.dp))
        Button(
            colors = ButtonDefaults.buttonColors(containerColor = secondaryColor),
            onClick = {
                daysInRow = if (waterCount >= DAILY_GOAL) daysInRow + 1 else 0
                waterCount = 0
            }
        ) {
            Text(
                text = "Завершить день",
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                color = buttonTextColor
            )
        }
        Spacer(modifier = Modifier.height(32.dp))
        Text(
            text = "Дней подряд с нормой $DAILY_GOAL мл: $daysInRow",
            fontSize = 20.sp,
            color = secondaryColor,
            modifier = Modifier.testTag("daysInRow")
        )
    }
}

@Preview(showSystemUi = true)
@Composable
fun WaterTrackerPreview() {
    Module2Theme {
        WaterTracker()
    }
}
