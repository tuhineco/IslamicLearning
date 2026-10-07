package com.tuhineco.islamiclearning

import android.speech.tts.TextToSpeech
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
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import java.util.Locale

@Composable
fun DuaDetailScreen(
    title: String,
    onBackClick: () -> Unit
) {
    BackHandler {
        onBackClick()
    }

    val context = LocalContext.current

    val cleanTitle = title
        .replace("🌙 ", "")
        .replace("🌅 ", "")
        .replace("🍽️ ", "")
        .replace("🥤 ", "")
        .replace("🚪 ", "")
        .replace("🏠 ", "")
        .replace("🚗 ", "")
        .replace("🤲 ", "")
        .replace("🛡️ ", "")
        .trim()

    val arabicText: String
    val pronunciationText: String
    val meaningText: String

    when (cleanTitle) {

        "ঘুমানোর দোয়া" -> {
            arabicText =
                "بِاسْمِكَ اللَّهُمَّ أَمُوتُ وَأَحْيَا"

            pronunciationText =
                "বিসমিকা আল্লাহুম্মা আমূতু ওয়া আহইয়া।"

            meaningText =
                "হে আল্লাহ! আপনার নামেই আমি মৃত্যুবরণ করি এবং জীবিত হই।"
        }

        "ঘুম থেকে ওঠার দোয়া" -> {
            arabicText =
                "الْحَمْدُ لِلَّهِ الَّذِي أَحْيَانَا بَعْدَ مَا أَمَاتَنَا وَإِلَيْهِ النُّشُورُ"

            pronunciationText =
                "আলহামদু লিল্লাহিল্লাযী আহইয়ানা বা‘দা মা আমাতানা ওয়া ইলাইহিন্নুশূর।"

            meaningText =
                "সমস্ত প্রশংসা আল্লাহর জন্য, যিনি আমাদের মৃত্যুর পর জীবিত করেছেন এবং তাঁর কাছেই ফিরে যেতে হবে।"
        }

        "খাওয়ার দোয়া" -> {
            arabicText =
                "بِسْمِ اللَّهِ"

            pronunciationText =
                "বিসমিল্লাহ।"

            meaningText =
                "আল্লাহর নামে।"
        }

        "খাওয়ার পরের দোয়া" -> {
            arabicText =
                "الْحَمْدُ لِلَّهِ الَّذِي أَطْعَمَنِي هَذَا وَرَزَقَنِيهِ مِنْ غَيْرِ حَوْلٍ مِنِّي وَلَا قُوَّةٍ"

            pronunciationText =
                "আলহামদু লিল্লাহিল্লাযী আত‘আমানী হাযা ওয়া রাযাকানীহি মিন গাইরি হাওলিন মিন্নী ওয়ালা কুওয়াহ।"

            meaningText =
                "সমস্ত প্রশংসা আল্লাহর জন্য, যিনি আমাকে এই খাবার খাইয়েছেন এবং আমার কোনো শক্তি ও সামর্থ্য ছাড়াই তা আমাকে রিজিক হিসেবে দিয়েছেন।"
        }

        "ঘর থেকে বের হওয়ার দোয়া" -> {
            arabicText =
                "بِسْمِ اللَّهِ تَوَكَّلْتُ عَلَى اللَّهِ لَا حَوْلَ وَلَا قُوَّةَ إِلَّا بِاللَّهِ"

            pronunciationText =
                "বিসমিল্লাহি তাওয়াক্কালতু আলাল্লাহি, লা হাওলা ওয়ালা কুওয়াতা ইল্লা বিল্লাহ।"

            meaningText =
                "আল্লাহর নামে বের হচ্ছি। আমি আল্লাহর ওপর ভরসা করলাম। আল্লাহ ছাড়া কোনো শক্তি ও সামর্থ্য নেই।"
        }

        "ঘরে প্রবেশের দোয়া" -> {
            arabicText =
                "بِسْمِ اللَّهِ وَلَجْنَا، وَبِسْمِ اللَّهِ خَرَجْنَا، وَعَلَى اللَّهِ رَبِّنَا تَوَكَّلْنَا"

            pronunciationText =
                "বিসমিল্লাহি ওয়ালাজনা, ওয়া বিসমিল্লাহি খারাজনা, ওয়া আলাল্লাহি রব্বিনা তাওয়াক্কালনা।"

            meaningText =
                "আল্লাহর নামে আমরা প্রবেশ করলাম, আল্লাহর নামেই আমরা বের হলাম এবং আমাদের প্রতিপালক আল্লাহর ওপর আমরা ভরসা করলাম।"
        }

        "সফরের দোয়া" -> {
            arabicText =
                "سُبْحَانَ الَّذِي سَخَّرَ لَنَا هَذَا وَمَا كُنَّا لَهُ مُقْرِنِينَ ۝ وَإِنَّا إِلَىٰ رَبِّنَا لَمُنقَلِبُونَ"

            pronunciationText =
                "সুবহানাল্লাযী সাখখারা লানা হাযা ওয়া মা কুন্না লাহু মুকরিনীন। ওয়া ইন্না ইলা রব্বিনা লামুনকালিবূন।"

            meaningText =
                "পবিত্র তিনি, যিনি এটিকে আমাদের জন্য বশীভূত করে দিয়েছেন; অথচ আমরা নিজেরা তা বশীভূত করতে সক্ষম ছিলাম না। এবং নিশ্চয়ই আমরা আমাদের প্রতিপালকের কাছেই ফিরে যাব।"
        }

        "বাবা-মায়ের জন্য দোয়া" -> {
            arabicText =
                "رَبِّ ارْحَمْهُمَا كَمَا رَبَّيَانِي صَغِيرًا"

            pronunciationText =
                "রব্বির হামহুমা কামা রব্বাইয়ানী সাগীরা।"

            meaningText =
                "হে আমার প্রতিপালক! তাঁদের প্রতি দয়া করুন, যেমন তাঁরা শৈশবে আমাকে লালন-পালন করেছেন।"
        }

        "বিপদ থেকে রক্ষার দোয়া" -> {
            arabicText =
                "حَسْبُنَا اللَّهُ وَنِعْمَ الْوَكِيلُ"

            pronunciationText =
                "হাসবুনাল্লাহু ওয়া নি‘মাল ওয়াকীল।"

            meaningText =
                "আমাদের জন্য আল্লাহই যথেষ্ট এবং তিনিই উত্তম কর্মবিধায়ক।"
        }

        else -> {
            arabicText = "দোয়ার আরবি এখানে দেখানো হবে।"
            pronunciationText = "বাংলা উচ্চারণ এখানে দেখানো হবে।"
            meaningText = "বাংলা অর্থ এখানে দেখানো হবে।"
        }
    }

    val tts = remember {
        TextToSpeech(context) { }
    }

    LaunchedEffect(Unit) {
        tts.language = Locale("bn", "BD")
    }

    DisposableEffect(Unit) {
        onDispose {
            tts.stop()
            tts.shutdown()
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

        Button(
            onClick = {
                tts.speak(
                    pronunciationText,
                    TextToSpeech.QUEUE_FLUSH,
                    null,
                    "dua"
                )
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("🔊 শুনুন")
        }
    }
}