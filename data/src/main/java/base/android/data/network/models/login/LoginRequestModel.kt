package base.android.data.network.models.login

import base.android.domain.models.BaseRequestModel
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class LoginRequestModel(
	@SerialName("userName")
	val userName: String?,
	@SerialName("pwd")
	val pwd: String?

) : BaseRequestModel() {
	override fun requestModel(): List<Pair<String, Any?>> {
		return listOf(
			"userName" to userName,
			"pwd" to pwd
		)
	}
}