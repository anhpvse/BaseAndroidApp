package base.android.data.network.di

import base.android.data.BuildConfig
import base.android.data.network.factory.KtorClientFactory
import org.koin.core.qualifier.named
import org.koin.dsl.module

val networkModule = module {
    single(named("baseUrl")) { BuildConfig.BASE_URL }

    single {
        KtorClientFactory.getInstance(
            baseUrl = get(named("baseUrl")),
        )
    }
}