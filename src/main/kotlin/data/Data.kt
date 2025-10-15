package data

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import app.cash.sqldelight.Query
import app.cash.sqldelight.coroutines.asFlow
import app.cash.sqldelight.coroutines.mapToList
import app.cash.sqldelight.driver.jdbc.sqlite.JdbcSqliteDriver
import database.Database
import database.User
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.launch

class Data() {
    // Задание 1.
    // Измените этот набор функций работы с БД и их параметры,
    // чтобы они соответствовали вашим SQL-запросам:

    // Получение списка всех пользователей
    fun users() = database.userQueries.all().flow()

    // Добавление пользователя с указанным именем
    fun add(name: String) =
        request { database.userQueries.insert(name) }

    // Редактирование пользователя: изменение имени
    fun update(user: String, name: String) =
        request { database.userQueries.update(name, user) }

    // Удаление пользователя
    fun delete(name: String) =
        request { database.userQueries.delete(name) }

    // Задание 2.
    // Измените эту функцию для работы с API,
    // чтобы она соответствовала возможностям вашего API-клиента:

    // получение информации через API-клиент
    fun clientTest() =
        client { client.test().text }



    // Ниже этой строки ничего редактировать не нужно!!!
    var error: String? by mutableStateOf(null)

    private val driver = JdbcSqliteDriver(JdbcSqliteDriver.IN_MEMORY, schema = Database.Schema)
    private val database = Database(driver)

    private fun <T: Any> Query<T>.flow() = asFlow().mapToList(Dispatchers.IO)
    private fun request(block: () -> Unit) = CoroutineScope(Dispatchers.IO).launch {
        runCatching { block() }.onFailure { error = it.message }
    }

    private val client = Client()
    private fun <T> client(block: suspend () -> T) =
        flow { emit(block()) }.flowOn(Dispatchers.IO).catch { error = it.message }
}