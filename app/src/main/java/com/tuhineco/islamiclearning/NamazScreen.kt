package com.tuhineco.islamiclearning

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

data class NamazTopic(
    val emoji: String,
    val title: String,
    val description: String
)

@Composable
fun NamazScreen(
    onBackClick: () -> Unit
) {

    BackHandler {
        onBackClick()
    }

    val topics = listOf(
        NamazTopic(
            "🕌",
            "নামাজের গুরুত্ব",
            "নামাজ ইসলামের গুরুত্বপূর্ণ ইবাদত। প্রতিদিন পাঁচ ওয়াক্ত নামাজ আদায় করা ফরজ।"
        ),
        NamazTopic(
            "💧",
            "নামাজের আগে প্রস্তুতি",
            "ওযু, পরিষ্কার-পরিচ্ছন্নতা, পবিত্র পোশাক এবং নামাজের স্থান প্রস্তুত করুন।"
        ),
        NamazTopic(
            "🤲",
            "নামাজের নিয়ত",
            "যে নামাজ আদায় করবেন, সেই নামাজের নিয়ত করুন।"
        ),
        NamazTopic(
            "☝️",
            "তাকবীরে তাহরিমা",
            "নামাজ শুরু করার সময় আল্লাহু আকবার বলে হাত বাঁধুন।"
        ),
        NamazTopic(
            "🙇",
            "রুকু",
            "রুকুতে গিয়ে আল্লাহর মহিমা ঘোষণা করুন এবং শান্তভাবে রুকু আদায় করুন।"
        ),
        NamazTopic(
            "🤲",
            "সিজদা",
            "সিজদায় গিয়ে আল্লাহর কাছে বিনয় প্রকাশ করুন এবং নির্ধারিত তাসবিহ পড়ুন।"
        ),
        NamazTopic(
            "📖",
            "তাশাহুদ",
            "বৈঠকে তাশাহুদ পাঠ করা হয়।"
        ),
        NamazTopic(
            "🌙",
            "দুরুদ শরীফ",
            "শেষ বৈঠকে তাশাহুদের পর দুরুদ শরীফ পাঠ করা হয়।"
        )
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFF5F9F6))
    ) {

        // Top Header
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color(0xFF0B6B4F))
                .padding(
                    horizontal = 16.dp,
                    vertical = 14.dp
                )
        ) {

            // Back Button
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable {
                        onBackClick()
                    }
                    .padding(vertical = 6.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {

                Text(
                    text = "←",
                    color = Color.White,
                    fontSize = 28.sp,
                    fontWeight = FontWeight.Bold
                )

                Spacer(
                    modifier = Modifier
                        .padding(horizontal = 4.dp)
                )

                Text(
                    text = "ফিরে যান",
                    color = Color.White,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Medium
                )
            }

            Spacer(
                modifier = Modifier.height(8.dp)
            )

            Text(
                text = "🕌 নামাজ শিক্ষা",
                color = Color.White,
                fontSize = 26.sp,
                fontWeight = FontWeight.Bold
            )

            Spacer(
                modifier = Modifier.height(5.dp)
            )

            Text(
                text = "ধাপে ধাপে নামাজ শিখুন",
                color = Color.White,
                fontSize = 15.sp
            )
        }

        // Topics
        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            contentPadding = androidx.compose.foundation.layout.PaddingValues(
                16.dp
            ),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {

            items(topics) { topic ->
                NamazTopicCard(topic)
            }
        }
    }
}

@Composable
fun NamazTopicCard(
    topic: NamazTopic
) {

    Card(
        modifier = Modifier.fillMaxWidth(),
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        ),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 3.dp
        )
    ) {

        Column(
            modifier = Modifier.padding(18.dp)
        ) {

            Text(
                text = "${topic.emoji}  ${topic.title}",
                fontSize = 19.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF174D3B)
            )

            Spacer(
                modifier = Modifier.height(8.dp)
            )

            Text(
                text = topic.description,
                fontSize = 14.sp,
                color = Color.DarkGray,
                lineHeight = 21.sp
            )
        }
    }
}