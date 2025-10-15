package tasks

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import data
import database.User

@Composable
fun Task1() {
    // Пишите здесь решение первого задания

    // Это пример получения информации из БД, замените своим:
    val users by remember { data.users() }.collectAsState(emptyList())
    users.forEach { Text(it) }
}
