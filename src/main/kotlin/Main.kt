import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import data.Data
import tasks.Task1
import tasks.Task2

val data by lazy { Data() }

// В этом файле ничего редактировать не нужно!!!

fun main() = application {
    Window(::exitApplication, title = "Экзамен ПМ.06") {
        val state = remember { SnackbarHostState() }
        LaunchedEffect(data.error) {
            data.error?.let { state.showSnackbar(it, withDismissAction = true) }?.also { data.error = null }
        }
        Scaffold(snackbarHost = {
            SnackbarHost(state) { Snackbar(it, containerColor = MaterialTheme.colorScheme.error) }
        }) {
            Row {
                Box(Modifier.fillMaxHeight().weight(1f).padding(5.dp).border(Dp.Hairline, Color.LightGray)) {
                    Text("Задание 1", Modifier.align(Alignment.TopCenter).offset(y = (-10).dp), Color.Gray)
                    Task1()
                }
                Box(Modifier.fillMaxHeight().weight(1f).padding(5.dp).border(Dp.Hairline, Color.LightGray)) {
                    Text("Задание 2", Modifier.align(Alignment.TopCenter).offset(y = (-10).dp), Color.Gray)
                    Task2()
                }
            }
        }
    }
}
