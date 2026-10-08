package com.tuhineco.islamiclearning

import android.content.Context
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp

@Composable
fun FavoritesScreen(
    onBackClick: () -> Unit,
    onSurahClick: (String) -> Unit,
    onDuaClick: (String) -> Unit
) {
    val context = LocalContext.current

    val preferences = remember {
        context.getSharedPreferences(
            "favorites",
            Context.MODE_PRIVATE
        )
    }

    var favoriteSurahs by remember {
        mutableStateOf<List<String>>(emptyList())
    }

    var favoriteDuas by remember {
        mutableStateOf<List<String>>(emptyList())
    }

    // Screen খুললে সর্বশেষ Favorite আবার পড়বে
    LaunchedEffect(Unit) {

        favoriteSurahs =
            preferences.getStringSet(
                "favorite_surahs",
                emptySet()
            )?.toList() ?: emptyList()

        favoriteDuas =
            preferences.getStringSet(
                "favorite_duas",
                emptySet()
            )?.toList() ?: emptyList()
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp),
        verticalArrangement = Arrangement.Top
    ) {

        Text(
            text = "⭐ প্রিয় বিষয়",
            style = MaterialTheme.typography.headlineMedium
        )

        Spacer(
            modifier = Modifier.height(20.dp)
        )

        if (favoriteSurahs.isEmpty() && favoriteDuas.isEmpty()) {

            Card(
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    text = "এখনো কোনো প্রিয় বিষয় যোগ করা হয়নি।",
                    modifier = Modifier.padding(20.dp),
                    style = MaterialTheme.typography.titleMedium
                )
            }

        } else {

            LazyColumn(
                verticalArrangement = Arrangement.spacedBy(10.dp),
                modifier = Modifier.weight(1f)
            ) {

                // =========================
                // Favorite Surahs
                // =========================

                if (favoriteSurahs.isNotEmpty()) {

                    item {
                        Text(
                            text = "📖 প্রিয় সূরা",
                            style = MaterialTheme.typography.titleLarge
                        )
                    }

                    items(favoriteSurahs) { surahTitle ->

                        Card(
                            modifier = Modifier
                                .fillMaxWidth()
                                .clickable {
                                    onSurahClick(surahTitle)
                                }
                        ) {
                            Text(
                                text = "📖 $surahTitle",
                                modifier = Modifier.padding(18.dp),
                                style = MaterialTheme.typography.titleMedium
                            )
                        }
                    }
                }


                // =========================
                // Favorite Duas
                // =========================

                if (favoriteDuas.isNotEmpty()) {

                    item {
                        Spacer(
                            modifier = Modifier.height(10.dp)
                        )

                        Text(
                            text = "🤲 প্রিয় দোয়া",
                            style = MaterialTheme.typography.titleLarge
                        )
                    }

                    items(favoriteDuas) { duaTitle ->

                        Card(
                            modifier = Modifier
                                .fillMaxWidth()
                                .clickable {
                                    onDuaClick(duaTitle)
                                }
                        ) {
                            Text(
                                text = "🤲 $duaTitle",
                                modifier = Modifier.padding(18.dp),
                                style = MaterialTheme.typography.titleMedium
                            )
                        }
                    }
                }
            }
        }

        Spacer(
            modifier = Modifier.height(20.dp)
        )

        Button(
            onClick = onBackClick,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("← ফিরে যান")
        }
    }
}