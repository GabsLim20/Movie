package com.example.movie.screens

import android.os.Looper
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import com.airbnb.lottie.compose.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.navigation.NavHostController
import com.airbnb.lottie.compose.rememberLottieComposition
import com.example.movie.R
import com.example.movie.navigation.Screens
import kotlinx.coroutines.delay
import java.util.logging.Handler


@Composable
fun Splash(menuNavController: NavHostController) {
    val composition by rememberLottieComposition(LottieCompositionSpec.RawRes(R.raw.animation))
    LaunchedEffect(true) {
        delay(3000) // Retraso de 3 segundos antes de la navegación
        menuNavController.navigate(Screens.HOME)
    }
    Surface(modifier = Modifier.fillMaxWidth(), color = Color.Black) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        LottieAnimation(composition = composition)

    }

    }
}