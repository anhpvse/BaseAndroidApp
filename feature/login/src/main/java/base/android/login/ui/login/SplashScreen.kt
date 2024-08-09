package base.android.login.ui.login

import BaseViewModel
import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import base.android.core.base.mvi.CollectSideEffect
import base.android.core.base.mvi.unpack
import org.koin.androidx.compose.koinViewModel

import base.android.login.ui.login.SplashContract.UiState
import base.android.login.ui.login.SplashContract.UiAction
import base.android.login.ui.login.SplashContract.SideEffect
import kotlinx.coroutines.flow.Flow

@Composable
fun SplashScreen() {
    val vm = remember { SplashViewModel() }
    
    /*
    Use this instead of the unpack function if you want

    val uiState by vm.uiState.collectAsState()
    val sideEffect = vm.sideEffect
    val onAction = vm::onAction
    */
    
    val (uiState, onAction, sideEffect) = vm.unpack()
    SplashScreen(uiState, sideEffect, onAction)
}

@Composable
fun SplashScreen(
    uiState: UiState,
    sideEffect: Flow<SideEffect>,
    onAction: (UiAction) -> Unit,
) {
    val context = LocalContext.current
    
    CollectSideEffect(sideEffect) {
        when (it) {
            SideEffect.ShowCountCanNotBeNegativeToast -> {
                Toast.makeText(context, "Count can't be less than 0", Toast.LENGTH_SHORT).show()
            }
        }
    }
    
    Scaffold {
        Column(
            modifier = Modifier
                .padding(it)
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
        ) {
            Text(
                text = "Count: ${uiState.count}",
            )
            Row(
                modifier = Modifier.padding(top = 16.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(16.dp),
            ) {
                Button(onClick = { onAction(UiAction.OnIncreaseCountClick) }) {
                    Text("Increase")
                }
                Button(onClick = { onAction(UiAction.OnDecreaseCountClick) }) {
                    Text("Decrease")
                }
            }
        }
    }
}

//@Preview(showSystemUi = false, showBackground = true)
//@Composable
//fun PreviewSplashScreenScreen() {
//    SplashScreen(
//        navController = rememberNavController(),
//        viewModel = LoginViewModel(),
//    )
//}