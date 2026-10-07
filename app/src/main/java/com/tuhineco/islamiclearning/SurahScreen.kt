package com.tuhineco.islamiclearning

import androidx.activity.compose.BackHandler
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
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

data class SurahItem(
    val title: String,
    val description: String
)

@Composable
fun SurahScreen(
    onBackClick: () -> Unit,
    onSurahClick: (String) -> Unit
) {

    BackHandler {
        onBackClick()
    }

    val surahs = listOf(

        SurahItem(
            "📖 সূরা আল-ফাতিহা",
            "নামাজে পড়া অত্যন্ত গুরুত্বপূর্ণ সূরা"
        ),

        SurahItem(
            "📖 সূরা আল-ইখলাস",
            "তাওহীদের গুরুত্বপূর্ণ শিক্ষা"
        ),

        SurahItem(
            "📖 সূরা আল-ফালাক",
            "অকল্যাণ থেকে আল্লাহর কাছে আশ্রয় চাওয়ার সূরা"
        ),

        SurahItem(
            "📖 সূরা আন-নাস",
            "শয়তানের কুমন্ত্রণা থেকে আশ্রয় চাওয়ার সূরা"
        ),

        SurahItem(
            "📖 সূরা আল-কাফিরুন",
            "দ্বীনের ব্যাপারে দৃঢ়তার শিক্ষা"
        ),

        SurahItem(
            "📖 সূরা আন-নাসর",
            "আল্লাহর সাহায্য ও বিজয়ের কথা"
        ),

        SurahItem(
            "📖 সূরা আল-মাসাদ",
            "আবু লাহাবের পরিণতি সম্পর্কে সূরা"
        ),

        SurahItem(
            "📖 সূরা আল-কাউসার",
            "আল্লাহর বিশেষ নিয়ামতের কথা"
        )
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {

        Text(
            text = "📖 ছোট সূরা",
            style = MaterialTheme.typography.headlineMedium
        )

        Spacer(modifier = Modifier.height(6.dp))

        Text(
            text = "প্রয়োজনীয় ছোট সূরাগুলো শিখুন",
            style = MaterialTheme.typography.bodyMedium
        )

        Spacer(modifier = Modifier.height(16.dp))

        Card(
            modifier = Modifier
                .fillMaxWidth()
                .clickable {
                    onBackClick()
                }
        ) {

            Text(
                text = "← ফিরে যান",
                modifier = Modifier.padding(16.dp),
                style = MaterialTheme.typography.titleMedium
            )
        }

        Spacer(modifier = Modifier.height(12.dp))

        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            contentPadding = PaddingValues(bottom = 16.dp),
            verticalArrangement = Arrangement.spacedBy(10.dp)
        ) {

            items(surahs) { surah ->

                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable {
                            onSurahClick(surah.title)
                        }
                ) {

                    Column(
                        modifier = Modifier.padding(16.dp)
                    ) {

                        Text(
                            text = surah.title,
                            style = MaterialTheme.typography.titleMedium
                        )

                        Spacer(
                            modifier = Modifier.height(6.dp)
                        )

                        Text(
                            text = surah.description,
                            style = MaterialTheme.typography.bodyMedium
                        )

                        Spacer(
                            modifier = Modifier.height(8.dp)
                        )

                        Text(
                            text = "বিস্তারিত দেখতে চাপুন →",
                            style = MaterialTheme.typography.bodySmall
                        )
                    }
                }
            }
        }
    }
}