import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.*
import androidx.compose.ui.unit.dp
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.request.get
import io.ktor.serialization.gson.gson
import kotlinx.coroutines.launch
import org.apache.poi.xwpf.usermodel.XWPFDocument
import java.io.FileInputStream
import java.io.FileOutputStream

@Composable
fun Exam() {
    // Пишите здесь основной код для выполнения вашего задания

}


//** Средства получения данных **//
// Клиент сетевого сервиса
val client = {}
// Адрес страницы для получения данных
const val URL = ""
// Класс данных для получения информации
class Data
// Функция для получения искомого значения
suspend fun data() = "данные"


//** Средства проверки строки на правильность **//
val regex = "".toRegex()
fun check(s: String) = "результат"


//** Средства записи результатов в файл **//
fun write(data: String, result: String) {
    val file = "ТестКейс.docx"

}