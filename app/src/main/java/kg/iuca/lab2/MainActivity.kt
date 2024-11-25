package kg.iuca.lab2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.delay
import kg.iuca.lab2.ui.theme.Lab2Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Lab2Theme {
                Surface(modifier = Modifier.fillMaxSize()) {
                    CountdownTimer()
                }
            }
        }
    }
}

@Composable
fun CountdownTimer() {
    var timeLeft by remember { mutableStateOf(10) }
    var timerFinished by remember { mutableStateOf(false) }

    // Таймер обратного отсчета
    LaunchedEffect(Unit) {
        while (timeLeft > 0) {
            delay(1000L) // Задержка 1 секунда
            timeLeft--
        }
        timerFinished = true
    }

    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier.fillMaxSize()
    ) {
        if (timerFinished) {
            Text(
                text = "Время вышло!",
                fontSize = 24.sp,
                style = MaterialTheme.typography.headlineMedium
            )
        } else {
            Text(
                text = "Осталось: $timeLeft сек.",
                fontSize = 32.sp,
                style = MaterialTheme.typography.headlineLarge
            )
        }
    }
}
