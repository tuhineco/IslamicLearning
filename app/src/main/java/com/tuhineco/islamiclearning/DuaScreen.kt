package com.tuhineco.islamiclearning

import androidx.activity.compose.BackHandler
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
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

data class DuaItem(
    val title: String,
    val description: String
)

@Composable
fun DuaScreen(
    onBackClick: () -> Unit,
    onDuaClick: (String) -> Unit
) {

    BackHandler {
        onBackClick()
    }

    val duas = listOf(

        DuaItem(
            "🌙 ঘুমানোর দোয়া",
            "ঘুমানোর সময় পড়ার দোয়া"
        ),

        DuaItem(
            "🌅 ঘুম থেকে ওঠার দোয়া",
            "ঘুম থেকে জাগার পর পড়ার দোয়া"
        ),

        DuaItem(
            "🍽️ খাওয়ার দোয়া",
            "খাওয়ার আগে পড়ার দোয়া"
        ),

        DuaItem(
            "🥤 খাওয়ার পরের দোয়া",
            "খাবার খাওয়ার পর আল্লাহর শুকরিয়া আদায়ের দোয়া"
        ),

        DuaItem(
            "🚪 ঘর থেকে বের হওয়ার দোয়া",
            "বাড়ি থেকে বের হওয়ার সময় পড়ার দোয়া"
        ),

        DuaItem(
            "🏠 ঘরে প্রবেশের দোয়া",
            "বাড়িতে প্রবেশের সময় আল্লাহকে স্মরণ করার দোয়া"
        ),

        DuaItem(
            "🚗 সফরের দোয়া",
            "সফর শুরু করার সময় পড়ার দোয়া"
        ),

        DuaItem(
            "🤲 বাবা-মায়ের জন্য দোয়া",
            "বাবা-মায়ের জন্য কুরআনের দোয়া"
        ),

        DuaItem(
            "🛡️ বিপদ থেকে রক্ষার দোয়া",
            "বিপদ ও অকল্যাণ থেকে আল্লাহর কাছে আশ্রয় চাওয়ার দোয়া"
        )
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
            .padding(16.dp)
    ) {

        Text(
            text = "🤲 প্রয়োজনীয় দোয়া",
            style = MaterialTheme.typography.headlineSmall
        )

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = "দৈনন্দিন জীবনের গুরুত্বপূর্ণ দোয়াগুলো শিখুন",
            style = MaterialTheme.typography.bodyMedium
        )

        Spacer(modifier = Modifier.height(16.dp))

        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            contentPadding = PaddingValues(bottom = 16.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {

            item {
                Text(
                    text = "← ফিরে যেতে Back চাপুন",
                    style = MaterialTheme.typography.bodySmall
                )
            }

            items(duas) { dua ->

                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable {
                            onDuaClick(dua.title)
                        }
                ) {

                    Column(
                        modifier = Modifier.padding(16.dp),
                        horizontalAlignment = Alignment.Start
                    ) {

                        Text(
                            text = dua.title,
                            style = MaterialTheme.typography.titleMedium
                        )

                        Spacer(modifier = Modifier.height(6.dp))

                        Text(
                            text = dua.description,
                            style = MaterialTheme.typography.bodyMedium
                        )
                    }
                }
            }
        }
    }
}