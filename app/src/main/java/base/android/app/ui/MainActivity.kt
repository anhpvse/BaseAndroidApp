package base.android.app.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import base.android.app.navigation.MAIN
import base.android.app.navigation.mainNavGraph
import base.android.app.ui.ui.theme.BaseTheme

class MainActivity : ComponentActivity() {
	
	private lateinit var navController: NavHostController
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		enableEdgeToEdge()
		setContent {
			navController = rememberNavController()
			
			
			println("---------MainActivity-----------")
			CompositionLocalProvider(
			) {
				BaseTheme {
					NavHost(navController = navController, startDestination = MAIN) {
						mainNavGraph(navController)
					}
				}
			}
//			BaseAndroidAppTheme {
//				Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
//					Greeting(
//						name = "Android",
//						modifier = Modifier.padding(innerPadding)
//					)
//				}
//			}
		}
	}
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
	Text(
		text = "Hello $name!",
		modifier = modifier
	)
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
	BaseTheme {
		Greeting("Android")
	}
}