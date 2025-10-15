package tasks

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import data
import kotlinx.coroutines.delay

@Composable
fun Task2() {
    // Пишите здесь решение второго задания

    // Проверка работы функции, удалите это:
    "8-918-123-45-67".let {
        Text("$it: " + check(it))
    }

}

// Регулярное выражение для проверки данных на корректность.
// Исправьте, чтобы соответствовало вашим данным:
private val regex = "8-\\d{3}-\\d{3}-\\d{2}-\\d{2}".toRegex()
private fun check(text: String) = if (regex.matches(text)) "верно" else "ошибка"