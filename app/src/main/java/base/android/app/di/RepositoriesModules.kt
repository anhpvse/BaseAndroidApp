package base.android.app.di

import base.android.data.repositories.RepositoryImpl
import base.android.domain.repositories.Repository
import org.koin.core.qualifier.named
import org.koin.dsl.module

val repositoriesModule = module {
    single<Repository> {
        RepositoryImpl(
            apiServices = get(),
            dispatcher = get(named("ioDispatcher"))
        )
    }
}