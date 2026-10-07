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

data class NamazStep(
    val number: String,
    val title: String,
    val description: String
)

@Composable
fun TwoRakatNamazScreen(
    onBackClick: () -> Unit
) {

    BackHandler {
        onBackClick()
    }

    val steps = listOf(
        NamazStep(
            "১",
            "নামাজের প্রস্তুতি",
            "ওযু করে পরিষ্কার-পরিচ্ছন্ন হয়ে কিবলামুখী হয়ে দাঁড়ান।"
        ),
        NamazStep(
            "২",
            "নিয়ত",
            "মনে যে দুই রাকাত নামাজ আদায় করবেন তার নিয়ত করুন।"
        ),
        NamazStep(
            "৩",
            "তাকবীরে তাহরিমা",
            "দুই হাত কানের কাছে বা কাঁধ পর্যন্ত তুলে ‘আল্লাহু আকবার’ বলে নামাজ শুরু করুন।"
        ),
        NamazStep(
            "৪",
            "কিয়াম",
            "দাঁড়িয়ে কিরাত পাঠ করুন। প্রথমে সূরা ফাতিহা এবং এরপর একটি সূরা বা আয়াত পাঠ করুন।"
        ),
        NamazStep(
            "৫",
            "রুকু",
            "‘আল্লাহু আকবার’ বলে রুকুতে যান এবং শান্তভাবে রুকু আদায় করুন।"
        ),
        NamazStep(
            "৬",
            "প্রথম সিজদা",
            "রুকু থেকে উঠে সোজা হয়ে দাঁড়িয়ে ‘আল্লাহু আকবার’ বলে সিজদায় যান।"
        ),
        NamazStep(
            "৭",
            "দুই সিজদার মাঝের বসা",
            "প্রথম সিজদা থেকে উঠে কিছুক্ষণ বসুন, তারপর দ্বিতীয় সিজদা করুন।"
        ),
        NamazStep(
            "৮",
            "দ্বিতীয় রাকাত",
            "দাঁড়িয়ে দ্বিতীয় রাকাত শুরু করুন এবং প্রথম রাকাতের মতো কিরাত, রুকু ও দুই সিজদা আদায় করুন।"
        ),
        NamazStep(
            "৯",
            "শেষ বৈঠক",
            "দ্বিতীয় রাকাতের দুই সিজদার পর বসে তাশাহুদ, দরুদ ও দোয়া পড়ুন।"
        ),
        NamazStep(
            "১০",
            "সালাম",
            "ডান দিকে এবং বাম দিকে সালাম ফিরিয়ে নামাজ শেষ করুন।"
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
                    vertical = 12.dp
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
                text = "🕌 ২ রাকাত নামাজ",
                color = Color.White,
                fontSize = 25.sp,
                fontWeight = FontWeight.Bold
            )

            Spacer(
                modifier = Modifier.height(5.dp)
            )

            Text(
                text = "ধাপে ধাপে নামাজের নিয়ম",
                color = Color.White,
                fontSize = 15.sp
            )
        }

        // Namaz Steps
        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            contentPadding = androidx.compose.foundation.layout.PaddingValues(
                16.dp
            ),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {

            items(steps) { step ->
                NamazStepCard(step)
            }
        }
    }
}

@Composable
fun NamazStepCard(
    step: NamazStep
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
                text = "${step.number}. ${step.title}",
                fontSize = 19.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF174D3B)
            )

            Spacer(
                modifier = Modifier.height(8.dp)
            )

            Text(
                text = step.description,
                fontSize = 15.sp,
                color = Color.DarkGray,
                lineHeight = 22.sp
            )
        }
    }
}