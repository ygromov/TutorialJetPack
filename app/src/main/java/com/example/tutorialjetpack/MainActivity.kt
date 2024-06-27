package com.example.tutorialjetpack

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.rememberNavController
import com.example.tutorialjetpack.navigation.Navigation
import com.example.tutorialjetpack.presentation.*
import com.example.tutorialjetpack.ui.theme.TutorialJetPackTheme
import com.google.firebase.analytics.FirebaseAnalytics
import com.google.firebase.ktx.Firebase
import dagger.hilt.android.AndroidEntryPoint
import androidx.compose.foundation.Image
import androidx.compose.runtime.DisposableEffect
import androidx.compose.ui.platform.LocalContext
import com.google.firebase.analytics.ktx.analytics

private const val TAG = "MainActivity"

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    private lateinit var  firebaseAnalytics: FirebaseAnalytics
    @SuppressLint("UnusedMaterialScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        firebaseAnalytics = FirebaseAnalytics.getInstance(applicationContext)
        setContent {
            val viewModel: MainViewModel = hiltViewModel()
            TutorialJetPackTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    //TrackEvent(eventName = "Открытие приложения")
//                    Image(
//                        painter = painterResource(id = R.drawable.background_gradient),
//                        contentDescription = null,
//                        contentScale = ContentScale.Crop,
//                        modifier = Modifier.fillMaxSize(),
//                        alpha = 0.4f
//                    )
                    val navController = rememberNavController()
                    if (viewModel.state.id != -1) {
                        Navigation(
                            navController = navController,
                            startDestination = viewModel.state.route
                        )
                    }
                }
            }
        }
    }
}
@Composable
fun TrackEvent(eventName: String) {
    val firebaseAnalytics = Firebase.analytics
    val context = LocalContext.current

    DisposableEffect(Unit) {
        firebaseAnalytics.logEvent(eventName, null)
        onDispose { }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    TutorialJetPackTheme {
    }
}