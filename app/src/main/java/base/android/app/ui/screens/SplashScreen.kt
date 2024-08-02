package base.android.app.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import base.android.app.R
import base.android.app.navigation.MainScreens
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(
    navController: NavController,
) {
    Box(modifier = Modifier.fillMaxSize()) {
        Image(
            modifier = Modifier.fillMaxSize(),
            painter = painterResource(id = R.drawable.ic_launcher_background),
            contentDescription = "",
            contentScale = ContentScale.FillBounds
        )
    }

    val currentTime = System.currentTimeMillis()

    LaunchedEffect(key1 = currentTime) {
        delay(3000)
        navController.navigate(MainScreens.Login)
    }
}

@Preview(showSystemUi = false, showBackground = true)
@Composable
fun PreviewSplashScreenScreen() {
    SplashScreen(
        navController = rememberNavController(),
    )
}