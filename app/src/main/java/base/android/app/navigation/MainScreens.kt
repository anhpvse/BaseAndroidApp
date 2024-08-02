package base.android.app.navigation

import kotlinx.serialization.Serializable

@Serializable
sealed class MainScreens {
	@Serializable
	data object Splash : MainScreens()
	
	@Serializable
	data object Login : MainScreens()
}