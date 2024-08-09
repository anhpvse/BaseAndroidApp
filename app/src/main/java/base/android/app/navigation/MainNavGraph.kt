package base.android.app.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import base.android.login.ui.login.LoginScreen
//import base.android.login.ui.login.LoginViewModel
import base.android.login.ui.login.SplashScreen
import org.koin.androidx.compose.koinViewModel

fun NavGraphBuilder.mainNavGraph(navController: NavController) {
	navigation<MAIN>(
		startDestination = MainScreens.Splash
	) {
		composable<MainScreens.Splash> {
			
//			val viewModel: LoginViewModel = koinViewModel()
//			SplashScreen(navController, viewModel)
			SplashScreen()
		}
		
		composable<MainScreens.Login>() {
			LoginScreen(navController)
		}
	}
}