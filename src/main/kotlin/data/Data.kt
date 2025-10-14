package data

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import app.cash.sqldelight.Query
import app.cash.sqldelight.coroutines.asFlow
import app.cash.sqldelight.coroutines.mapToList
import app.cash.sqldelight.driver.jdbc.sqlite.JdbcSqliteDriver
import database.Database
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class Data() {

    fun users() = database.userQueries.all().flow()

    fun add(name: String) = request { database.userQueries.insert(name) }

    fun delete(name: String) = request { database.userQueries.delete(name) }

    //"jdbc:sqlite:database.s3db"
    private val driver = JdbcSqliteDriver(JdbcSqliteDriver.IN_MEMORY, schema = Database.Schema)
    private val database = Database(driver)

    var error: String? by mutableStateOf(null)

    private fun <T: Any> Query<T>.flow() = asFlow().mapToList(Dispatchers.IO)
    private fun request(block: () -> Unit) = CoroutineScope(Dispatchers.IO).launch {
        runCatching { block() }.onFailure { error = it.message }
    }
}