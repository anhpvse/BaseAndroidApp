package base.android.login.ui.login

interface SplashContract {
	data class UiState(
		val count: Int,
		val isSelected: Boolean = false
	)
	
	sealed interface UiAction {
		data object OnIncreaseCountClick : UiAction
		data object OnDecreaseCountClick : UiAction
	}
	
	sealed interface SideEffect {
		data object ShowCountCanNotBeNegativeToast : SideEffect
	}
}