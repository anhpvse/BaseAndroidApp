package base.android.app

import android.app.Application
import base.android.app.di.repositoriesModule
import base.android.app.di.servicesModule
import base.android.app.di.useCasesModule
import base.android.app.di.viewModelsModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class MainApplication : Application() {
	
	override fun onCreate() {
		super.onCreate()
		startKoin {
			// Log Koin into Android logger
			androidLogger()
			
			// Reference Android context
			androidContext(this@MainApplication)
			modules(
				listOf(
					viewModelsModule,
					repositoriesModule,
					useCasesModule,
					servicesModule,
				)
			)
		}
	}
	
}