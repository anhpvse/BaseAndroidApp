package base.android.app.di

import base.android.data.network.di.networkModule
import base.android.data.network.services.ApiServices
import io.ktor.client.HttpClient
import org.koin.dsl.module

val servicesModule = module {
	includes(networkModule)
	single { ApiServices(get<HttpClient>()) }
}