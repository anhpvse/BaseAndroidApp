package base.android.data.network.models.wrappers

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class RemoteResponse<T>(
	@SerialName("data")
	val data: T?,
	@SerialName("errorCode")
	val errorCode: String?,
	@SerialName("errorDesc")
	val errorDesc: String?,
	)