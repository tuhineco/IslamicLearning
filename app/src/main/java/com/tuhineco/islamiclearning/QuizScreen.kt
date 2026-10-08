package com.tuhineco.islamiclearning

import android.content.Context
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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp

data class QuizQuestion(
    val question: String,
    val options: List<String>,
    val correctAnswer: String
)

@Composable
fun QuizScreen(
    onBackClick: () -> Unit
) {
    val context = LocalContext.current

    val questions = listOf(
        QuizQuestion(
            question = "ইসলামের প্রথম স্তম্ভ কোনটি?",
            options = listOf(
                "নামাজ",
                "কালেমা",
                "রোজা",
                "হজ"
            ),
            correctAnswer = "কালেমা"
        ),
        QuizQuestion(
            question = "এক দিনে ফরজ নামাজ কত ওয়াক্ত?",
            options = listOf(
                "৩ ওয়াক্ত",
                "৪ ওয়াক্ত",
                "৫ ওয়াক্ত",
                "৬ ওয়াক্ত"
            ),
            correctAnswer = "৫ ওয়াক্ত"
        ),
        QuizQuestion(
            question = "রমজান মাসে মুসলমানরা কী পালন করেন?",
            options = listOf(
                "হজ",
                "রোজা",
                "কুরবানি",
                "আকিকা"
            ),
            correctAnswer = "রোজা"
        ),
        QuizQuestion(
            question = "মুসলমানদের পবিত্র কিতাবের নাম কী?",
            options = listOf(
                "তাওরাত",
                "ইঞ্জিল",
                "কুরআন",
                "যাবুর"
            ),
            correctAnswer = "কুরআন"
        ),
        QuizQuestion(
            question = "নামাজের আগে সাধারণত কী করা হয়?",
            options = listOf(
                "ওযু",
                "ঘুম",
                "খাবার",
                "খেলা"
            ),
            correctAnswer = "ওযু"
        )
    )

    val preferences = remember {
        context.getSharedPreferences(
            "quiz_progress",
            Context.MODE_PRIVATE
        )
    }

    var currentQuestion by remember {
        mutableStateOf(
            preferences.getInt("current_question", 0)
        )
    }

    var score by remember {
        mutableStateOf(
            preferences.getInt("score", 0)
        )
    }

    var selectedAnswer by remember {
        mutableStateOf<String?>(null)
    }

    var quizFinished by remember {
        mutableStateOf(
            preferences.getBoolean("quiz_finished", false)
        )
    }

    if (quizFinished) {

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(20.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {

            Text(
                text = "🎉 কুইজ শেষ!",
                style = MaterialTheme.typography.headlineMedium
            )

            Spacer(modifier = Modifier.height(20.dp))

            Text(
                text = "আপনার স্কোর",
                style = MaterialTheme.typography.titleLarge
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = "$score / ${questions.size}",
                style = MaterialTheme.typography.headlineLarge
            )

            Spacer(modifier = Modifier.height(24.dp))

            Button(
                onClick = {
                    currentQuestion = 0
                    score = 0
                    selectedAnswer = null
                    quizFinished = false

                    preferences.edit()
                        .putInt("current_question", 0)
                        .putInt("score", 0)
                        .putBoolean("quiz_finished", false)
                        .apply()
                }
            ) {
                Text("🔄 আবার শুরু করুন")
            }

            Spacer(modifier = Modifier.height(12.dp))

            Button(
                onClick = onBackClick
            ) {
                Text("← ফিরে যান")
            }
        }

    } else {

        val question = questions[currentQuestion]

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(20.dp)
        ) {

            Text(
                text = "🧠 ইসলামিক কুইজ",
                style = MaterialTheme.typography.headlineMedium
            )

            Spacer(modifier = Modifier.height(12.dp))

            Text(
                text = "প্রশ্ন ${currentQuestion + 1} / ${questions.size}",
                style = MaterialTheme.typography.titleMedium
            )

            Spacer(modifier = Modifier.height(20.dp))

            Card(
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    text = question.question,
                    style = MaterialTheme.typography.titleLarge,
                    modifier = Modifier.padding(20.dp)
                )
            }

            Spacer(modifier = Modifier.height(20.dp))

            question.options.forEach { option ->

                Button(
                    onClick = {
                        if (selectedAnswer == null) {

                            selectedAnswer = option

                            if (option == question.correctAnswer) {
                                score++

                                preferences.edit()
                                    .putInt("score", score)
                                    .apply()
                            }
                        }
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 4.dp),
                    enabled = selectedAnswer == null
                ) {
                    Text(option)
                }
            }

            if (selectedAnswer != null) {

                Spacer(modifier = Modifier.height(16.dp))

                if (selectedAnswer == question.correctAnswer) {

                    Text(
                        text = "✅ সঠিক উত্তর!",
                        style = MaterialTheme.typography.titleMedium
                    )

                } else {

                    Text(
                        text = "❌ ভুল উত্তর!",
                        style = MaterialTheme.typography.titleMedium
                    )

                    Spacer(modifier = Modifier.height(4.dp))

                    Text(
                        text = "সঠিক উত্তর: ${question.correctAnswer}"
                    )
                }

                Spacer(modifier = Modifier.height(16.dp))

                Button(
                    onClick = {

                        if (currentQuestion < questions.lastIndex) {

                            currentQuestion++

                            selectedAnswer = null

                            preferences.edit()
                                .putInt(
                                    "current_question",
                                    currentQuestion
                                )
                                .apply()

                        } else {

                            quizFinished = true

                            preferences.edit()
                                .putInt(
                                    "current_question",
                                    currentQuestion
                                )
                                .putBoolean(
                                    "quiz_finished",
                                    true
                                )
                                .apply()
                        }
                    },
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(
                        if (currentQuestion < questions.lastIndex) {
                            "পরের প্রশ্ন →"
                        } else {
                            "ফলাফল দেখুন"
                        }
                    )
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            Button(
                onClick = onBackClick,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("← ফিরে যান")
            }
        }
    }
}