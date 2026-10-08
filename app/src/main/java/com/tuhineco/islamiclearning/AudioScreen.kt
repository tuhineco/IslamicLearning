package com.tuhineco.islamiclearning

import android.speech.tts.TextToSpeech
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import java.util.Locale

@Composable
fun AudioScreen(
    onBackClick: () -> Unit
) {
    val context = LocalContext.current

    var isPlaying by remember {
        mutableStateOf(false)
    }

    val tts = remember {
        TextToSpeech(context) { }
    }

    LaunchedEffect(Unit) {
        tts.language = Locale("bn", "BD")
    }

    DisposableEffect(Unit) {
        onDispose {
            tts.stop()
            tts.shutdown()
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ) {

        Text(
            text = "🎧 ইসলামিক অডিও",
            style = MaterialTheme.typography.headlineMedium
        )

        Spacer(modifier = Modifier.height(20.dp))

        Card(
            modifier = Modifier.fillMaxWidth()
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(20.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                Text(
                    text = "🤲 দোয়া ও ইসলামিক শিক্ষা",
                    style = MaterialTheme.typography.titleLarge
                )

                Spacer(modifier = Modifier.height(12.dp))

                Text(
                    text = "ইসলামিক বিষয় শুনে শেখার জন্য নিচের Play বাটনে চাপুন।",
                    style = MaterialTheme.typography.bodyMedium
                )

                Spacer(modifier = Modifier.height(20.dp))

                Button(
                    onClick = {
                        if (isPlaying) {
                            tts.stop()
                            isPlaying = false
                        } else {
                            tts.speak(
                                "বিসমিল্লাহির রাহমানির রাহিম। " +
                                        "ইসলাম আমাদের শান্তি, শৃঙ্খলা ও কল্যাণের শিক্ষা দেয়। " +
                                        "আমরা নামাজ আদায় করব, ভালো কাজ করব এবং অন্যের উপকার করব।",
                                TextToSpeech.QUEUE_FLUSH,
                                null,
                                "islamic_learning_audio"
                            )
                            isPlaying = true
                        }
                    }
                ) {
                    Text(
                        text = if (isPlaying) "⏹ Stop" else "▶ Play Audio"
                    )
                }
            }
        }

        Spacer(modifier = Modifier.height(20.dp))

        Button(
            onClick = {
                tts.stop()
                onBackClick()
            }
        ) {
            Text("← ফিরে যান")
        }
    }
}