package base.android.data.network.services

import base.android.data.network.models.wrappers.RemoteResponse
import base.android.domain.models.BaseRequestModel
import base.android.domain.models.BaseResponseModel
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.request.parameter
import io.ktor.client.request.post

class ApiServices(private val client: HttpClient) {
	
	suspend fun <T : BaseRequestModel, E : BaseResponseModel> fetchData(requestModel: T): RemoteResponse<E> =
		client.get {
			requestModel.requestModel().forEach { (key, value) ->
				parameter(key, value)
			}
		}.body()
	
//	suspend fun <T : BaseRequestModel, E : BaseResponseModel> fetchData(requestModel: T): RemoteResponse<E> =
//		client.post {
//			requestModel.requestModel().forEach { (key, value) ->
//				parameter(key, value)
//			}
//		}.body()
	
}