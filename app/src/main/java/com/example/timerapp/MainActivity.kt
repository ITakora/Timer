package com.example.timerapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.ViewModel
import com.example.timerapp.ui.theme.TimerAppTheme

class MainActivity : ComponentActivity() {
    private val viewModel by viewModels<MainViewModels>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            TimerAppTheme {
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
                    JetTimer()
                }
            }
        }
    }

    @Composable
    fun JetTimer() {
        val currentTime by viewModel.currentTime.collectAsState()
        val isRunning by viewModel.isTimeRunning.collectAsState()
        Timer(currentTime = currentTime, isRunning = isRunning, onRestart = {viewModel.restartTimer()}, onStart ={viewModel.startTimer()} )
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    TimerAppTheme {
        Greeting("Android")
    }
}