package base.android.domain.models.wrappers

import base.android.domain.models.ErrorModel

open class CallFailure(val errorModel: ErrorModel) : Throwable()