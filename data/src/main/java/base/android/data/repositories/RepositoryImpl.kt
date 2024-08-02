package base.android.data.repositories

import base.android.data.network.services.ApiServices
import base.android.domain.models.BaseRequestModel
import base.android.domain.models.BaseResponseModel
import base.android.domain.models.ErrorModel
import base.android.domain.models.wrappers.CallFailure
import base.android.domain.models.wrappers.NetworkCallResult
import base.android.domain.repositories.Repository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class RepositoryImpl(
	private val apiServices: ApiServices,
	private val dispatcher: CoroutineDispatcher
) : Repository {
	override suspend fun login(model: BaseRequestModel) =
		flow<NetworkCallResult<BaseResponseModel, CallFailure>> {
			val result = apiServices.fetchData<BaseRequestModel, BaseResponseModel>(model)
			
			result.data?.let {
				println("--------------data-------------------")
				println(result.data)
//			emit(NetworkCallResult(value = it.toMovieModelList()))
			} ?: run {
				emit(
					NetworkCallResult(
						error = CallFailure(
							ErrorModel(
								errorCode = result.errorCode ?: "",
								errorMessage = result.errorDesc ?: ""
							)
						)
					)
				)
			}
			
		}.flowOn(dispatcher)
			.catch { e ->
				emit(
					NetworkCallResult(
						error = CallFailure(
							ErrorModel(
								errorCode = "-1",
								errorMessage = e.message ?: ""
							)
						)
					)
				)
			}
	
	override suspend fun getUserInfo(model: BaseRequestModel): Flow<NetworkCallResult<BaseResponseModel, CallFailure>> {
		TODO("Not yet implemented")
	}

//	private suspend fun <T : BaseRequestModel, E : BaseResponseModel> performNetworkCall(
//		model: T
//	): Flow<NetworkCallResult<E, CallFailure>> = flow {
//		val result = apiServices.fetchData<T, E>(model)
//
//		result.data?.let {
////			emit(NetworkCallResult<T, E>(value = it))
//		} ?: run {
//			emit(
//				NetworkCallResult(
//					error = CallFailure(
//						ErrorModel(
//							errorCode = result.errorCode ?: "",
//							errorMessage = result.errorDesc ?: ""
//						)
//					)
//				)
//			)
//		}
//	}.flowOn(dispatcher).catch { e ->
//		emit(
//			NetworkCallResult(
//				error = CallFailure(
//					ErrorModel(
//						errorCode = "-1",
//						errorMessage = e.message ?: ""
//					)
//				)
//			)
//		)
//	}
}