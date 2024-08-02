package base.android.app.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraph
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import base.android.app.ui.screens.LoginScreen
import base.android.app.ui.screens.SplashScreen

fun NavGraphBuilder.mainNavGraph(navController: NavController) {
	navigation<MAIN>(
		startDestination = MainScreens.Splash
	) {
		composable<MainScreens.Splash>() {
			SplashScreen(navController)
		}
		
		composable<MainScreens.Login>() {
			LoginScreen(navController)
		}
	}
}