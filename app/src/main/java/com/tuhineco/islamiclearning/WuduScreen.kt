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

data class WuduStep(
    val number: String,
    val title: String,
    val description: String
)

@Composable
fun WuduScreen(
    onBackClick: () -> Unit
) {

    BackHandler {
        onBackClick()
    }

    val steps = listOf(
        WuduStep(
            "১",
            "নিয়ত",
            "ওযু করার নিয়ত করে আল্লাহর নামে ওযু শুরু করুন।"
        ),
        WuduStep(
            "২",
            "দুই হাত ধোয়া",
            "দুই হাত কবজি পর্যন্ত ভালোভাবে ধুয়ে নিন।"
        ),
        WuduStep(
            "৩",
            "কুলি করা",
            "মুখে পানি নিয়ে ভালোভাবে কুলি করুন।"
        ),
        WuduStep(
            "৪",
            "নাকে পানি দেওয়া",
            "নাকে পানি দিয়ে পরিষ্কার করুন।"
        ),
        WuduStep(
            "৫",
            "মুখ ধোয়া",
            "কপালের চুলের গোড়া থেকে থুতনির নিচ পর্যন্ত এবং এক কান থেকে অন্য কান পর্যন্ত মুখ ধুয়ে নিন।"
        ),
        WuduStep(
            "৬",
            "হাত ধোয়া",
            "প্রথমে ডান হাত এবং পরে বাম হাত কনুইসহ ভালোভাবে ধুয়ে নিন।"
        ),
        WuduStep(
            "৭",
            "মাথা মাসেহ",
            "ভেজা হাত দিয়ে মাথা মাসেহ করুন।"
        ),
        WuduStep(
            "৮",
            "কান মাসেহ",
            "মাথা মাসেহ করার পর ভেজা আঙুল দিয়ে কান মাসেহ করুন।"
        ),
        WuduStep(
            "৯",
            "পা ধোয়া",
            "প্রথমে ডান পা এবং পরে বাম পা টাখনুসহ ভালোভাবে ধুয়ে নিন। আঙুলের ফাঁকেও পানি পৌঁছান।"
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
                    modifier = Modifier.padding(horizontal = 4.dp)
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
                text = "💧 ওযু শিক্ষা",
                color = Color.White,
                fontSize = 25.sp,
                fontWeight = FontWeight.Bold
            )

            Spacer(
                modifier = Modifier.height(5.dp)
            )

            Text(
                text = "ধাপে ধাপে সঠিকভাবে ওযু শিখুন",
                color = Color.White,
                fontSize = 15.sp
            )
        }

        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            contentPadding = androidx.compose.foundation.layout.PaddingValues(
                16.dp
            ),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {

            items(steps) { step ->

                WuduStepCard(step)
            }
        }
    }
}

@Composable
fun WuduStepCard(
    step: WuduStep
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