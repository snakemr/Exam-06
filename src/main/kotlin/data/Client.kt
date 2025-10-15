package data

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.request.get
import io.ktor.serialization.gson.gson

class Client {
    // ссылка для получения данных с сервера: укажите корректную
    val url = "http://localhost:80/"

    // класс для получения данных: поменяйте название и свойства класса
    data class Test(val text: String)

    // получение данных: поменяйте название и возвращаемый тип функции
    suspend fun test(): Test = client.get(url).body()

    // Ниже этой строки ничего редактировать не нужно!!!
    private val client = HttpClient {
        install(ContentNegotiation) {
            gson()
        }
    }
}