package com.tuhineco.islamiclearning

import android.content.Context
import androidx.activity.compose.BackHandler
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp

@Composable
fun SurahDetailScreen(
    title: String,
    onBackClick: () -> Unit
) {
    BackHandler {
        onBackClick()
    }

    val context = LocalContext.current

    val cleanTitle = title
        .replace("📖 ", "")
        .trim()

    val preferences = remember {
        context.getSharedPreferences(
            "favorites",
            Context.MODE_PRIVATE
        )
    }

    var isFavorite by remember {
        mutableStateOf(
            preferences.getStringSet("favorite_surahs", emptySet())
                ?.contains(cleanTitle) == true
        )
    }

    val arabicText: String
    val pronunciationText: String
    val meaningText: String

    when (cleanTitle) {

        "সূরা আল-ফাতিহা" -> {
            arabicText =
                "بِسْمِ اللَّهِ الرَّحْمَٰنِ الرَّحِيمِ\n" +
                        "الْحَمْدُ لِلَّهِ رَبِّ الْعَالَمِينَ\n" +
                        "الرَّحْمَٰنِ الرَّحِيمِ\n" +
                        "مَالِكِ يَوْمِ الدِّينِ\n" +
                        "إِيَّاكَ نَعْبُدُ وَإِيَّاكَ نَسْتَعِينُ\n" +
                        "اهْدِنَا الصِّرَاطَ الْمُسْتَقِيمَ\n" +
                        "صِرَاطَ الَّذِينَ أَنْعَمْتَ عَلَيْهِمْ\n" +
                        "غَيْرِ الْمَغْضُوبِ عَلَيْهِمْ وَلَا الضَّالِّينَ"

            pronunciationText =
                "বিসমিল্লাহির রাহমানির রাহীম।\n" +
                        "আলহামদু লিল্লাহি রব্বিল আলামীন।\n" +
                        "আর-রাহমানির রাহীম।\n" +
                        "মালিকি ইয়াওমিদ্দীন।\n" +
                        "ইয়্যাকা না‘বুদু ওয়া ইয়্যাকা নাসতা‘ঈন।\n" +
                        "ইহদিনাস সিরাতাল মুস্তাকীম।\n" +
                        "সিরাতাল্লাযীনা আন‘আমতা আলাইহিম।\n" +
                        "গইরিল মাগদূবি আলাইহিম ওয়ালাদ্দল্লীন।"

            meaningText =
                "পরম করুণাময়, অসীম দয়ালু আল্লাহর নামে।\n\n" +
                        "সমস্ত প্রশংসা আল্লাহর জন্য, যিনি সকল জগতের প্রতিপালক।\n" +
                        "তিনি পরম করুণাময়, অসীম দয়ালু।\n" +
                        "তিনি বিচার দিনের মালিক।\n" +
                        "আমরা শুধু আপনারই ইবাদত করি এবং শুধু আপনার কাছেই সাহায্য চাই।\n" +
                        "আমাদের সরল পথ দেখান।\n" +
                        "তাদের পথ, যাদের আপনি অনুগ্রহ করেছেন।\n" +
                        "তাদের পথ নয়, যারা আপনার ক্রোধের পাত্র এবং যারা পথভ্রষ্ট।"
        }

        "সূরা আল-ইখলাস" -> {
            arabicText =
                "قُلْ هُوَ اللَّهُ أَحَدٌ\n" +
                        "اللَّهُ الصَّمَدُ\n" +
                        "لَمْ يَلِدْ وَلَمْ يُولَدْ\n" +
                        "وَلَمْ يَكُن لَّهُ كُفُوًا أَحَدٌ"

            pronunciationText =
                "কুল হুয়াল্লাহু আহাদ।\n" +
                        "আল্লাহুস সামাদ।\n" +
                        "লাম ইয়ালিদ ওয়ালাম ইউলাদ।\n" +
                        "ওয়ালাম ইয়াকুল্লাহু কুফুওয়ান আহাদ।"

            meaningText =
                "বলুন, তিনি আল্লাহ, এক।\n" +
                        "আল্লাহ অমুখাপেক্ষী।\n" +
                        "তিনি কাউকে জন্ম দেননি এবং তাঁকেও জন্ম দেওয়া হয়নি।\n" +
                        "এবং তাঁর সমতুল্য কেউ নেই।"
        }

        "সূরা আল-ফালাক" -> {
            arabicText =
                "قُلْ أَعُوذُ بِرَبِّ الْفَلَقِ\n" +
                        "مِن شَرِّ مَا خَلَقَ\n" +
                        "وَمِن شَرِّ غَاسِقٍ إِذَا وَقَبَ\n" +
                        "وَمِن شَرِّ النَّفَّاثَاتِ فِي الْعُقَدِ\n" +
                        "وَمِن شَرِّ حَاسِدٍ إِذَا حَسَدَ"

            pronunciationText =
                "কুল আউযু বিরাব্বিল ফালাক।\n" +
                        "মিন শাররি মা খালাক।\n" +
                        "ওয়া মিন শাররি গাসিকিন ইযা ওয়াকাব।\n" +
                        "ওয়া মিন শাররিন নাফফাসাতি ফিল উকাদ।\n" +
                        "ওয়া মিন শাররি হাসিদিন ইযা হাসাদ।"

            meaningText =
                "বলুন, আমি আশ্রয় নিচ্ছি প্রভাতের প্রতিপালকের।\n" +
                        "তিনি যা সৃষ্টি করেছেন তার অনিষ্ট থেকে।\n" +
                        "রাতের অন্ধকারের অনিষ্ট থেকে যখন তা গভীর হয়।\n" +
                        "গ্রন্থিতে ফুঁকদানকারীদের অনিষ্ট থেকে।\n" +
                        "এবং হিংসুকের অনিষ্ট থেকে যখন সে হিংসা করে।"
        }

        "সূরা আন-নাস" -> {
            arabicText =
                "قُلْ أَعُوذُ بِرَبِّ النَّاسِ\n" +
                        "مَلِكِ النَّاسِ\n" +
                        "إِلَٰهِ النَّاسِ\n" +
                        "مِن شَرِّ الْوَسْوَاسِ الْخَنَّاسِ\n" +
                        "الَّذِي يُوَسْوِسُ فِي صُدُورِ النَّاسِ\n" +
                        "مِنَ الْجِنَّةِ وَالنَّاسِ"

            pronunciationText =
                "কুল আউযু বিরাব্বিন্নাস।\n" +
                        "মালিকিন্নাস।\n" +
                        "ইলাহিন্নাস।\n" +
                        "মিন শাররিল ওয়াসওয়াসিল খান্নাস।\n" +
                        "আল্লাযী ইউওয়াসওয়িসু ফী সুদূরিন্নাস।\n" +
                        "মিনাল জিন্নাতি ওয়ান্নাস।"

            meaningText =
                "বলুন, আমি আশ্রয় নিচ্ছি মানুষের প্রতিপালকের।\n" +
                        "মানুষের অধিপতির।\n" +
                        "মানুষের উপাস্যের।\n" +
                        "কুমন্ত্রণাদাতার অনিষ্ট থেকে, যে আত্মগোপন করে।\n" +
                        "যে মানুষের অন্তরে কুমন্ত্রণা দেয়।\n" +
                        "জিন ও মানুষের মধ্য থেকে।"
        }

        "সূরা আল-কাফিরুন" -> {
            arabicText =
                "قُلْ يَا أَيُّهَا الْكَافِرُونَ\n" +
                        "لَا أَعْبُدُ مَا تَعْبُدُونَ\n" +
                        "وَلَا أَنتُمْ عَابِدُونَ مَا أَعْبُدُ\n" +
                        "وَلَا أَنَا عَابِدٌ مَّا عَبَدتُّمْ\n" +
                        "وَلَا أَنتُمْ عَابِدُونَ مَا أَعْبُدُ\n" +
                        "لَكُمْ دِينُكُمْ وَلِيَ دِينِ"

            pronunciationText =
                "কুল ইয়া আইয়ুহাল কাফিরূন।\n" +
                        "লা আ‘বুদু মা তা‘বুদূন।\n" +
                        "ওয়ালা আনতুম আবিদূনা মা আ‘বুদ।\n" +
                        "ওয়ালা আনা আবিদুম মা আবাদতুম।\n" +
                        "ওয়ালা আনতুম আবিদূনা মা আ‘বুদ।\n" +
                        "লাকুম দীনুকুম ওয়ালিয়া দীন।"

            meaningText =
                "বলুন, হে কাফিরগণ!\n" +
                        "তোমরা যার ইবাদত কর আমি তার ইবাদত করি না।\n" +
                        "এবং তোমরাও তাঁর ইবাদতকারী নও যাঁর ইবাদত আমি করি।\n" +
                        "এবং আমি তার ইবাদতকারী নই যার ইবাদত তোমরা কর।\n" +
                        "এবং তোমরাও তাঁর ইবাদতকারী নও যাঁর ইবাদত আমি করি।\n" +
                        "তোমাদের ধর্ম তোমাদের জন্য এবং আমার ধর্ম আমার জন্য।"
        }

        "সূরা আন-নাসর" -> {
            arabicText =
                "إِذَا جَاءَ نَصْرُ اللَّهِ وَالْفَتْحُ\n" +
                        "وَرَأَيْتَ النَّاسَ يَدْخُلُونَ فِي دِينِ اللَّهِ أَفْوَاجًا\n" +
                        "فَسَبِّحْ بِحَمْدِ رَبِّكَ وَاسْتَغْفِرْهُ ۚ إِنَّهُ كَانَ تَوَّابًا"

            pronunciationText =
                "ইযা জা-আ নাসরুল্লাহি ওয়াল ফাতহ।\n" +
                        "ওয়া রা-আইতান্নাসা ইয়াদখুলূনা ফী দীনিল্লাহি আফওয়াজা।\n" +
                        "ফাসাব্বিহ বিহামদি রব্বিকা ওয়াস্তাগফিরহু, ইন্নাহু কানা তাওয়াবা।"

            meaningText =
                "যখন আল্লাহর সাহায্য ও বিজয় আসবে,\n" +
                        "এবং আপনি মানুষকে দলে দলে আল্লাহর দ্বীনে প্রবেশ করতে দেখবেন,\n" +
                        "তখন আপনার প্রতিপালকের প্রশংসাসহ তাঁর পবিত্রতা ঘোষণা করুন এবং তাঁর কাছে ক্ষমা চান। নিশ্চয়ই তিনি তওবা কবুলকারী।"
        }

        "সূরা আল-মাসাদ" -> {
            arabicText =
                "تَبَّتْ يَدَا أَبِي لَهَبٍ وَتَبَّ\n" +
                        "مَا أَغْنَىٰ عَنْهُ مَالُهُ وَمَا كَسَبَ\n" +
                        "سَيَصْلَىٰ نَارًا ذَاتَ لَهَبٍ\n" +
                        "وَامْرَأَتُهُ حَمَّالَةَ الْحَطَبِ\n" +
                        "فِي جِيدِهَا حَبْلٌ مِّن مَّسَدٍ"

            pronunciationText =
                "তাব্বাত ইয়াদা আবী লাহাবিও ওয়া তাব্ব।\n" +
                        "মা আগনা আনহু মালুহু ওয়া মা কাসাব।\n" +
                        "সাইয়াসলা নারান জাতা লাহাব।\n" +
                        "ওয়ামরাআতুহু হাম্মালাতাল হাতাব।\n" +
                        "ফী জীদিহা হাবলুম মিম মাসাদ।"

            meaningText =
                "আবু লাহাবের দুই হাত ধ্বংস হোক এবং সে নিজেও ধ্বংস হোক।\n" +
                        "তার সম্পদ ও তার উপার্জন তার কোনো কাজে আসেনি।\n" +
                        "অচিরেই সে লেলিহান আগুনে প্রবেশ করবে।\n" +
                        "এবং তার স্ত্রীও, যে ইন্ধন বহন করে।\n" +
                        "তার গলায় থাকবে পাকানো রশি।"
        }

        "সূরা আল-কাউসার" -> {
            arabicText =
                "إِنَّا أَعْطَيْنَاكَ الْكَوْثَرَ\n" +
                        "فَصَلِّ لِرَبِّكَ وَانْحَرْ\n" +
                        "إِنَّ شَانِئَكَ هُوَ الْأَبْتَرُ"

            pronunciationText =
                "ইন্না আ‘তাইনাকাল কাউসার।\n" +
                        "ফাসাল্লি লিরাব্বিকা ওয়ানহার।\n" +
                        "ইন্না শানিআকা হুয়াল আবতার।"

            meaningText =
                "নিশ্চয়ই আমি আপনাকে কাউসার দান করেছি।\n" +
                        "অতএব আপনার প্রতিপালকের উদ্দেশ্যে নামাজ পড়ুন এবং কুরবানি করুন।\n" +
                        "নিশ্চয়ই আপনার প্রতি বিদ্বেষ পোষণকারীই নির্বংশ।"
        }

        else -> {
            arabicText = "সূরার আরবি এখানে দেখানো হবে।"
            pronunciationText = "বাংলা উচ্চারণ এখানে দেখানো হবে।"
            meaningText = "বাংলা অর্থ এখানে দেখানো হবে।"
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {

        Button(
            onClick = onBackClick,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("← ফিরে যান")
        }

        Text(
            text = cleanTitle,
            style = MaterialTheme.typography.headlineSmall
        )

        Button(
            onClick = {

                val currentFavorites =
                    preferences.getStringSet(
                        "favorite_surahs",
                        emptySet()
                    )?.toMutableSet() ?: mutableSetOf()

                if (isFavorite) {
                    currentFavorites.remove(cleanTitle)
                    isFavorite = false
                } else {
                    currentFavorites.add(cleanTitle)
                    isFavorite = true
                }

                preferences.edit()
                    .putStringSet(
                        "favorite_surahs",
                        currentFavorites
                    )
                    .apply()
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(
                if (isFavorite) {
                    "⭐ প্রিয় থেকে সরান"
                } else {
                    "☆ প্রিয়তে যোগ করুন"
                }
            )
        }

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = "🕋 আরবি",
            style = MaterialTheme.typography.titleLarge
        )

        Text(
            text = arabicText,
            style = MaterialTheme.typography.bodyLarge
        )

        Text(
            text = "📖 বাংলা উচ্চারণ",
            style = MaterialTheme.typography.titleLarge
        )

        Text(
            text = pronunciationText,
            style = MaterialTheme.typography.bodyLarge
        )

        Text(
            text = "💡 বাংলা অর্থ",
            style = MaterialTheme.typography.titleLarge
        )

        Text(
            text = meaningText,
            style = MaterialTheme.typography.bodyLarge
        )
    }
}