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

data class NiyyahItem(
    val emoji: String,
    val title: String,
    val description: String
)

@Composable
fun NiyyahScreen(
    onBackClick: () -> Unit
) {

    BackHandler {
        onBackClick()
    }

    val niyyahItems = listOf(
        NiyyahItem(
            "🌅",
            "ফজরের নামাজ",
            "ফজরের ফরজ নামাজ আদায়ের নিয়ত করুন।"
        ),
        NiyyahItem(
            "☀️",
            "যোহরের নামাজ",
            "যোহরের ফরজ নামাজ আদায়ের নিয়ত করুন।"
        ),
        NiyyahItem(
            "🌤️",
            "আসরের নামাজ",
            "আসরের ফরজ নামাজ আদায়ের নিয়ত করুন।"
        ),
        NiyyahItem(
            "🌇",
            "মাগরিবের নামাজ",
            "মাগরিবের ফরজ নামাজ আদায়ের নিয়ত করুন।"
        ),
        NiyyahItem(
            "🌙",
            "এশার নামাজ",
            "এশার ফরজ নামাজ আদায়ের নিয়ত করুন।"
        ),
        NiyyahItem(
            "🕌",
            "২ রাকাত নামাজ",
            "দুই রাকাত নামাজ আদায়ের নিয়ত সম্পর্কে জানুন।"
        ),
        NiyyahItem(
            "🕌",
            "৩ রাকাত নামাজ",
            "তিন রাকাত নামাজ আদায়ের নিয়ত সম্পর্কে জানুন।"
        ),
        NiyyahItem(
            "🕌",
            "৪ রাকাত নামাজ",
            "চার রাকাত নামাজ আদায়ের নিয়ত সম্পর্কে জানুন।"
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
                text = "🤲 নামাজের নিয়ত",
                color = Color.White,
                fontSize = 25.sp,
                fontWeight = FontWeight.Bold
            )

            Spacer(
                modifier = Modifier.height(5.dp)
            )

            Text(
                text = "বিভিন্ন নামাজের নিয়ত সম্পর্কে জানুন",
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

            items(niyyahItems) { item ->

                NiyyahCard(item)
            }
        }
    }
}

@Composable
fun NiyyahCard(
    item: NiyyahItem
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
                text = "${item.emoji}  ${item.title}",
                fontSize = 19.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF174D3B)
            )

            Spacer(
                modifier = Modifier.height(8.dp)
            )

            Text(
                text = item.description,
                fontSize = 15.sp,
                color = Color.DarkGray,
                lineHeight = 22.sp
            )
        }
    }
}