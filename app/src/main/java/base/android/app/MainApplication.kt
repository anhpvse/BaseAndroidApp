package base.android.app

import android.app.Application
import org.koin.core.context.startKoin

class MainActivity : Application() {
	
	override fun onCreate() {
		super.onCreate()
		startKoin {
		
		}
	}
}