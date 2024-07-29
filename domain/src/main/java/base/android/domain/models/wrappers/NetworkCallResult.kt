package base.android.domain.models.wrappers

data class NetworkCallResult<T, E>(val value: T? = null, val error: E? = null)
