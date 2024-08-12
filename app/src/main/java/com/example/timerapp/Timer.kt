package com.example.timerapp

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.SizeTransform
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.animation.togetherWith
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

@Composable
fun Timer(currentTime: Long, isRunning: Boolean, onStart: () -> Unit, onRestart: () -> Unit) {
    Box(modifier = Modifier.fillMaxSize()) {
        Row(modifier = Modifier.align(Alignment.BottomCenter)) {
            Button(onClick = onStart) {
                Text(text = "Start")
            }
            Spacer(modifier = Modifier.size(8.dp))
            Button(onClick = { onRestart() }) {
                Text(text = "Restart")
            }
        }
        AnimatedContent(modifier = Modifier.align(Alignment.Center),targetState = currentTime, transitionSpec = {
            if (targetState > initialState) {
                slideInVertically { fullHeight -> fullHeight } + fadeIn() togetherWith slideOutVertically { fullHeight -> fullHeight } + fadeOut()
            } else {
                slideInVertically { fullHeight -> fullHeight } + fadeIn() togetherWith slideOutVertically { fullHeight -> fullHeight } + fadeOut()
            }.using(sizeTransform = SizeTransform(clip = false))
        }, label = "") { time ->
            Text(
                text = getFormattedTime(time),
                color = MaterialTheme.colorScheme.onSurface,
                fontWeight = FontWeight.Bold,
                style = MaterialTheme.typography.bodyLarge,

            )
        }
    }
}