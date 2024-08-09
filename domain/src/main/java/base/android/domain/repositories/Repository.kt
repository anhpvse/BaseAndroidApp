package base.android.domain.repositories

import base.android.domain.models.BaseRequestModel
import base.android.domain.models.BaseResponseModel
import base.android.domain.models.wrappers.CallFailure
import base.android.domain.models.wrappers.NetworkCallResult
import kotlinx.coroutines.flow.Flow

interface Repository {
	suspend fun get(model: BaseRequestModel): Flow<NetworkCallResult<BaseResponseModel, CallFailure>>
	suspend fun post(model: BaseRequestModel): Flow<NetworkCallResult<BaseResponseModel, CallFailure>>
}