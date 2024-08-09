package base.android.domain.usecases

import base.android.domain.models.BaseRequestModel
import base.android.domain.repositories.Repository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext

class BaseUserCases(
	private val repository: Repository,
	private val dispatcher: CoroutineDispatcher
) {
	suspend fun fetchData(requestModel: BaseRequestModel) =
		withContext(dispatcher) {
			repository.get(requestModel)
		}
}