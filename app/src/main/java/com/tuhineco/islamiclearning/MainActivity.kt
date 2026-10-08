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
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            IslamicLearningApp()
        }
    }
}

@Composable
fun IslamicLearningApp() {

    var showNamazScreen by remember { mutableStateOf(false) }
    var showTwoRakatScreen by remember { mutableStateOf(false) }

    var showWuduScreen by remember { mutableStateOf(false) }
    var showNiyyahScreen by remember { mutableStateOf(false) }

    var showSurahScreen by remember { mutableStateOf(false) }
    var showSurahDetailScreen by remember { mutableStateOf(false) }

    var showDuaScreen by remember { mutableStateOf(false) }
    var showDuaDetailScreen by remember { mutableStateOf(false) }

    var showAudioScreen by remember { mutableStateOf(false) }
    var showQuizScreen by remember { mutableStateOf(false) }

    var showFavoritesScreen by remember { mutableStateOf(false) }

    var selectedSurahTitle by remember { mutableStateOf("") }
    var selectedDuaTitle by remember { mutableStateOf("") }

    // Favorite থেকে Detail-এ গেলে আবার Favorite Screen-এ ফেরার জন্য
    var returnToFavorites by remember { mutableStateOf(false) }


    when {

        // =========================
        // 2 Rakat Namaz
        // =========================
        showTwoRakatScreen -> {

            TwoRakatNamazScreen(
                onBackClick = {
                    showTwoRakatScreen = false
                    showNamazScreen = true
                }
            )
        }


        // =========================
        // Namaz Screen
        // =========================
        showNamazScreen -> {

            NamazScreen(
                onBackClick = {
                    showNamazScreen = false
                },

                onTwoRakatClick = {
                    showNamazScreen = false
                    showTwoRakatScreen = true
                }
            )
        }


        // =========================
        // Wudu Screen
        // =========================
        showWuduScreen -> {

            WuduScreen(
                onBackClick = {
                    showWuduScreen = false
                }
            )
        }


        // =========================
        // Niyyah Screen
        // =========================
        showNiyyahScreen -> {

            NiyyahScreen(
                onBackClick = {
                    showNiyyahScreen = false
                }
            )
        }


        // =========================
        // Surah Detail
        // =========================
        showSurahDetailScreen -> {

            SurahDetailScreen(
                title = selectedSurahTitle,

                onBackClick = {

                    showSurahDetailScreen = false

                    if (returnToFavorites) {
                        returnToFavorites = false
                        showFavoritesScreen = true
                    } else {
                        showSurahScreen = true
                    }
                }
            )
        }


        // =========================
        // Surah List
        // =========================
        showSurahScreen -> {

            SurahScreen(

                onBackClick = {
                    showSurahScreen = false
                },

                onSurahClick = { title ->

                    selectedSurahTitle = title

                    returnToFavorites = false

                    showSurahScreen = false
                    showSurahDetailScreen = true
                }
            )
        }


        // =========================
        // Dua Detail
        // =========================
        showDuaDetailScreen -> {

            DuaDetailScreen(
                title = selectedDuaTitle,

                onBackClick = {

                    showDuaDetailScreen = false

                    if (returnToFavorites) {
                        returnToFavorites = false
                        showFavoritesScreen = true
                    } else {
                        showDuaScreen = true
                    }
                }
            )
        }


        // =========================
        // Dua List
        // =========================
        showDuaScreen -> {

            DuaScreen(

                onBackClick = {
                    showDuaScreen = false
                },

                onDuaClick = { title ->

                    selectedDuaTitle = title

                    returnToFavorites = false

                    showDuaScreen = false
                    showDuaDetailScreen = true
                }
            )
        }


        // =========================
        // Audio Screen
        // =========================
        showAudioScreen -> {

            AudioScreen(
                onBackClick = {
                    showAudioScreen = false
                }
            )
        }


        // =========================
        // Quiz Screen
        // =========================
        showQuizScreen -> {

            QuizScreen(
                onBackClick = {
                    showQuizScreen = false
                }
            )
        }


        // =========================
        // Favorites Screen
        // =========================
        showFavoritesScreen -> {

            FavoritesScreen(

                onBackClick = {
                    showFavoritesScreen = false
                },

                // Favorite Surah থেকে Detail Screen
                onSurahClick = { title ->

                    selectedSurahTitle = title

                    returnToFavorites = true

                    showFavoritesScreen = false
                    showSurahDetailScreen = true
                },

                // Favorite Dua থেকে Detail Screen
                onDuaClick = { title ->

                    selectedDuaTitle = title

                    returnToFavorites = true

                    showFavoritesScreen = false
                    showDuaDetailScreen = true
                }
            )
        }


        // =========================
        // Home Screen
        // =========================
        else -> {

            HomeScreen(

                onNamazClick = {
                    showNamazScreen = true
                },

                onWuduClick = {
                    showWuduScreen = true
                },

                onNiyyahClick = {
                    showNiyyahScreen = true
                },

                onSurahClick = {
                    showSurahScreen = true
                },

                onDuaClick = {
                    showDuaScreen = true
                },

                onAudioClick = {
                    showAudioScreen = true
                },

                onQuizClick = {
                    showQuizScreen = true
                },

                onFavoritesClick = {
                    showFavoritesScreen = true
                }
            )
        }
    }
}


// =====================================================
// Home Screen
// =====================================================

@Composable
fun HomeScreen(
    onNamazClick: () -> Unit,
    onWuduClick: () -> Unit,
    onNiyyahClick: () -> Unit,
    onSurahClick: () -> Unit,
    onDuaClick: () -> Unit,
    onAudioClick: () -> Unit,
    onQuizClick: () -> Unit,
    onFavoritesClick: () -> Unit
) {

    val menuItems = listOf(

        "🕌 নামাজ শিক্ষা",

        "💧 ওযু শিক্ষা",

        "🤲 নামাজের নিয়ত",

        "📖 ছোট সূরা",

        "🤲 দোয়া",

        "🎧 অডিও",

        "🧠 ইসলামিক কুইজ",

        "⭐ প্রিয় বিষয়"
    )


    Column(

        modifier = Modifier
            .fillMaxSize()
            .background(
                MaterialTheme.colorScheme.background
            )
    ) {


        // =========================
        // Header
        // =========================

        Column(

            modifier = Modifier
                .fillMaxWidth()
                .background(
                    MaterialTheme.colorScheme.primary
                )
                .padding(20.dp)
        ) {

            Text(

                text = "☪ Islamic Learning",

                style = MaterialTheme.typography.headlineMedium,

                color = MaterialTheme.colorScheme.onPrimary
            )


            Spacer(
                modifier = Modifier.height(6.dp)
            )


            Text(

                text = "ইসলাম সম্পর্কে জানুন, শিখুন ও আমল করুন",

                style = MaterialTheme.typography.bodyMedium,

                color = MaterialTheme.colorScheme.onPrimary
            )
        }


        // =========================
        // Menu Grid
        // =========================

        LazyVerticalGrid(

            columns = GridCells.Fixed(2),

            modifier = Modifier.fillMaxSize(),

            contentPadding = PaddingValues(16.dp),

            horizontalArrangement = Arrangement.spacedBy(12.dp),

            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {


            items(menuItems) { item ->


                Card(

                    modifier = Modifier
                        .fillMaxWidth()
                        .height(120.dp)
                        .clickable {

                            when (item) {

                                "🕌 নামাজ শিক্ষা" -> {
                                    onNamazClick()
                                }

                                "💧 ওযু শিক্ষা" -> {
                                    onWuduClick()
                                }

                                "🤲 নামাজের নিয়ত" -> {
                                    onNiyyahClick()
                                }

                                "📖 ছোট সূরা" -> {
                                    onSurahClick()
                                }

                                "🤲 দোয়া" -> {
                                    onDuaClick()
                                }

                                "🎧 অডিও" -> {
                                    onAudioClick()
                                }

                                "🧠 ইসলামিক কুইজ" -> {
                                    onQuizClick()
                                }

                                "⭐ প্রিয় বিষয়" -> {
                                    onFavoritesClick()
                                }
                            }
                        }
                ) {


                    Column(

                        modifier = Modifier
                            .fillMaxSize()
                            .padding(16.dp),

                        verticalArrangement = Arrangement.Center
                    ) {


                        Text(

                            text = item,

                            style = MaterialTheme.typography.titleMedium
                        )
                    }
                }
            }
        }
    }
}