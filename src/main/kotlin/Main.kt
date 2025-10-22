import androidx.compose.ui.unit.DpSize
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import androidx.compose.ui.window.rememberWindowState

// В этом файле ничего редактировать не нужно!!!

fun main() = application {
    Window(::exitApplication,
        rememberWindowState(size = DpSize(650.dp, 220.dp)),
        title = "Экзамен ПМ.06 — валидация данных") {
        Exam()
    }
}
