import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import base.android.core.base.DataState
import base.android.core.base.SingleLiveEvent
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

//T represents our ViewState
//U represents our ViewEffect
abstract class BaseViewModel<T, U> : ViewModel() {
	//It will be accessed by child classes to update the view states
	private val _dataStates: MutableLiveData<DataState<T>> = MutableLiveData()
	//Will be accessed by the view to observe view state updates
	val dataStates: LiveData<DataState<T>> = _dataStates
	
	//It will be accessed by child classes to update the view effects
	private val _viewEffects: SingleLiveEvent<U> = SingleLiveEvent()
	//It will be accessed by the view to observe view effects updates
	val viewEffects: SingleLiveEvent<U> = _viewEffects
	
	//This is a wrapper for making network/room calls (use the latest version of room and retrofit that supports suspend functions)
	//This way we don't have to manually set our error and loading states in our child view models.
	protected fun launchRequest(block: suspend () -> Unit): Job {
		val currentViewState = getViewState()
		return viewModelScope.launch {
			try {
				_dataStates.postValue(DataState.Loading(currentViewState))
				block()
			} catch (exception: Exception) {
				_dataStates.postValue(DataState.Error(currentViewState, exception))
			}
		}
	}
	
	private fun getViewState() : T? = _dataStates.value?.toData()
}