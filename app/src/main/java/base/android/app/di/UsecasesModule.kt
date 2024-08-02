package base.android.app.di

import base.android.domain.usecases.BaseUserCases
import org.koin.core.qualifier.named
import org.koin.dsl.module

val useCasesModule = module {
    factory {
        BaseUserCases(
            repository = get(),
            dispatcher = get(named("defaultDispatcher"))
        )
    }
}