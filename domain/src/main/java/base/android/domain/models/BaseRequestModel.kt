package base.android.domain.models

abstract class BaseRequestModel {
	open fun requestModel(): List<Pair<String, Any?>> = emptyList()
	open var path: String = ""
}
