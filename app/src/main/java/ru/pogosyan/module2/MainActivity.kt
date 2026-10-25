package ru.pogosyan.module2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.BackHandler
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        // Номер задания можно передать при запуске: adb shell am start ... --ei task 8
        val startTask = intent.getIntExtra("task", 0)
        setContent {
            Module2Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    var task by rememberSaveable { mutableIntStateOf(startTask) }
                    BackHandler(enabled = task != 0) { task = 0 }
                    val modifier = Modifier.padding(innerPadding)
                    when (task) {
                        // Задание 1: вызов compose-функции Hello в активити
                        1 -> Hello(name = "Тигран", modifier = modifier)
                        3 -> JetpackTextVariants(modifier)
                        4 -> Column(modifier) { GrayButton() }
                        5 -> Column(modifier) { InitialsHeader(initials = "ТП") }
                        6 -> Column(modifier) {
                            CircleTopEnd()
                            CircleStretched()
                        }
                        7 -> ContactsScreen(modifier)
                        8 -> WaterTracker(modifier)
                        10 -> ShoppingCartScreen(modifier)
                        else -> TaskMenu(modifier) { task = it }
                    }
                }
            }
        }
    }
}

@Composable
fun TaskMenu(modifier: Modifier = Modifier, onSelect: (Int) -> Unit) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Text(text = "Модуль 2. Погосян Т.Г.", fontSize = 24.sp, fontWeight = FontWeight.Bold)
        listOf(1, 3, 4, 5, 6, 7, 8, 10).forEach { number ->
            Button(onClick = { onSelect(number) }, modifier = Modifier.fillMaxWidth()) {
                Text(text = "Задание $number")
            }
        }
    }
}
