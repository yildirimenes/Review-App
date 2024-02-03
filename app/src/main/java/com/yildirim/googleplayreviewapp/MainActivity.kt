package com.yildirim.googleplayreviewapp
import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import com.yildirim.googleplayreviewapp.ui.theme.GooglePlayReviewAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GooglePlayReviewAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    AppReview()
                }
            }
        }
    }
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun AppReview() {
    val context = LocalContext.current
    Scaffold {
        Column(
            modifier = Modifier
                .fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,

            ) {
            Button(onClick = {
                reviewGooglePlay(context,"https://play.google.com/store/apps/details?id=com.microsoft.office.officehubrow&hl=tr&gl=US")
            }) {
                Text(text = "App Review")
            }
        }
    }
}

fun reviewGooglePlay(activityContext: Context, appURL: String) {
    val playIntent: Intent = Intent().apply {
        action = Intent.ACTION_VIEW
        data = Uri.parse(appURL)
    }
    try {
        activityContext.startActivity(playIntent)
    } catch (e: Exception) {
        e.printStackTrace()
    }
}
