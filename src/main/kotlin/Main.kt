import androidx.compose.material3.Scaffold
import androidx.compose.material3.Snackbar
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import data.Data

val data by lazy { Data() }

fun main() = application {
    Window(::exitApplication, title = "Экзамен ПМ.06") {
        val state = remember { SnackbarHostState() }
        LaunchedEffect(data.error) {
            data.error?.let { state.showSnackbar(it) }?.also { data.error = null }
        }
        Scaffold(snackbarHost = {
            SnackbarHost(state) { Snackbar(it, containerColor = Color(192, 0, 64)) }
        }) {
            App()
        }
    }
}
