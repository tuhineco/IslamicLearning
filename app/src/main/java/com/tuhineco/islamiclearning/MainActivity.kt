package com.tuhineco.islamiclearning

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

data class LearningItem(
    val emoji: String,
    val title: String,
    val subtitle: String
)

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            MaterialTheme {
                IslamicLearningApp()
            }
        }
    }
}

@Composable
fun IslamicLearningApp() {

    var showNamazScreen by remember {
        mutableStateOf(false)
    }

    var showTwoRakatScreen by remember {
        mutableStateOf(false)
    }

    if (showTwoRakatScreen) {

        TwoRakatNamazScreen(
            onBackClick = {
                showTwoRakatScreen = false
            }
        )

    } else if (showNamazScreen) {

        NamazScreen(
            onBackClick = {
                showNamazScreen = false
            },
            onTwoRakatClick = {
                showTwoRakatScreen = true
            }
        )

    } else {

        IslamicLearningHome(
            onNamazClick = {
                showNamazScreen = true
            }
        )
    }
}

@Composable
fun IslamicLearningHome(
    onNamazClick: () -> Unit
) {

    val menuItems = listOf(
        LearningItem(
            "🕌",
            "নামাজ শিক্ষা",
            "নামাজের সম্পূর্ণ নিয়ম"
        ),
        LearningItem(
            "💧",
            "ওযু শিক্ষা",
            "সঠিকভাবে ওযু করার নিয়ম"
        ),
        LearningItem(
            "🤲",
            "নামাজের নিয়ত",
            "বিভিন্ন নামাজের নিয়ত"
        ),
        LearningItem(
            "📖",
            "ছোট সূরা",
            "প্রয়োজনীয় ছোট সূরা"
        ),
        LearningItem(
            "🤲",
            "দোয়া",
            "প্রতিদিনের প্রয়োজনীয় দোয়া"
        ),
        LearningItem(
            "🎧",
            "অডিও",
            "শুনে শুনে শিখুন"
        ),
        LearningItem(
            "🧠",
            "ইসলামিক কুইজ",
            "জ্ঞান যাচাই করুন"
        ),
        LearningItem(
            "⭐",
            "প্রিয় বিষয়",
            "আপনার সংরক্ষিত বিষয়"
        )
    )

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = Color(0xFFF5F9F6)
    ) {

        Column(
            modifier = Modifier.fillMaxSize()
        ) {

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color(0xFF0B6B4F))
                    .padding(
                        horizontal = 20.dp,
                        vertical = 24.dp
                    )
            ) {

                Text(
                    text = "☪ Islamic Learning",
                    color = Color.White,
                    fontSize = 26.sp,
                    fontWeight = FontWeight.Bold
                )

                Spacer(
                    modifier = Modifier.height(6.dp)
                )

                Text(
                    text = "ইসলাম সম্পর্কে জানুন, শিখুন ও আমল করুন",
                    color = Color.White,
                    fontSize = 15.sp
                )
            }

            Spacer(
                modifier = Modifier.height(12.dp)
            )

            Text(
                text = "📚 শেখার বিষয়সমূহ",
                modifier = Modifier.padding(
                    horizontal = 20.dp
                ),
                fontSize = 21.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF174D3B)
            )

            Spacer(
                modifier = Modifier.height(8.dp)
            )

            LazyVerticalGrid(
                columns = GridCells.Fixed(2),
                modifier = Modifier.fillMaxSize(),
                contentPadding = PaddingValues(
                    start = 14.dp,
                    end = 14.dp,
                    bottom = 20.dp
                ),
                horizontalArrangement = Arrangement.spacedBy(12.dp),
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {

                items(menuItems) { item ->

                    LearningCard(
                        item = item,
                        onClick = {

                            if (item.title == "নামাজ শিক্ষা") {
                                onNamazClick()
                            }
                        }
                    )
                }
            }
        }
    }
}

@Composable
fun LearningCard(
    item: LearningItem,
    onClick: () -> Unit
) {

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(145.dp)
            .clickable {
                onClick()
            },
        shape = RoundedCornerShape(18.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        ),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 4.dp
        )
    ) {

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(12.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {

            Text(
                text = item.emoji,
                fontSize = 36.sp
            )

            Spacer(
                modifier = Modifier.height(6.dp)
            )

            Text(
                text = item.title,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF174D3B),
                textAlign = TextAlign.Center
            )

            Spacer(
                modifier = Modifier.height(3.dp)
            )

            Text(
                text = item.subtitle,
                fontSize = 12.sp,
                color = Color.Gray,
                textAlign = TextAlign.Center
            )
        }
    }
}