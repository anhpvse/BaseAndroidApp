package base.android.login.ui.login

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import base.android.core.base.mvi.MVI
import base.android.core.base.mvi.mvi
import base.android.login.ui.login.SplashContract.UiState
import base.android.login.ui.login.SplashContract.UiAction
import base.android.login.ui.login.SplashContract.SideEffect

class SplashViewModel : ViewModel(), MVI<UiState, UiAction, SideEffect> by mvi(initialUiState()) {
	
	override fun onAction(uiAction: UiAction) {
		when (uiAction) {
			UiAction.OnIncreaseCountClick -> increaseCount()
			UiAction.OnDecreaseCountClick -> onDecreaseCountClick()
		}
	}
	
	private fun increaseCount() {
		updateUiState { copy(count = count + 1) }
	}
	
	private fun onDecreaseCountClick() {
		if (uiState.value.count > 0) {
			updateUiState { copy(count = count - 1) }
		} else {
			viewModelScope.emitSideEffect(SideEffect.ShowCountCanNotBeNegativeToast)
		}
	}
}

private fun initialUiState(): UiState = UiState(count = 0)