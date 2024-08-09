package base.android.data.network.services

import base.android.data.network.models.wrappers.RemoteResponse
import base.android.domain.models.BaseRequestModel
import base.android.domain.models.BaseResponseModel
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.request.header
import io.ktor.client.request.parameter
import io.ktor.client.request.post
import io.ktor.client.utils.EmptyContent.headers
import io.ktor.http.headers

class ApiServices(private val client: HttpClient) {
	
	suspend fun <T : BaseRequestModel, E : BaseResponseModel> getData(requestModel: T): RemoteResponse<E> =
		client.get(requestModel.path) {
			requestModel.requestModel().forEach { (key, value) ->
				parameter(key, value)
			}
		}.body()
//		client.get("url") {
////			url("requestModel.url")
//			headers {
//				append("X-Parse-Application-Id", "PublicData.Application_Id" )
//				append("X-Parse-REST-API-Key", "PublicData.REST_API_Key")
//				append("Content-Type", "application/json")
//			}
//			requestModel.requestModel().forEach { (key, value) ->
//				parameter(key, value)
//			}
//		}.body()
	
	
	suspend fun <T : BaseRequestModel, E : BaseResponseModel> postData(requestModel: T): RemoteResponse<E> =
		client.post {
			requestModel.requestModel().forEach { (key, value) ->
				parameter(key, value)
			}
		}.body()
	
}



//	suspend fun <T : BaseRequestModel, E : BaseResponseModel> fetchData(requestModel: T): RemoteResponse<E> =
//		client.post {
//			requestModel.requestModel().forEach { (key, value) ->
//				parameter(key, value)
//			}
//		}.body()