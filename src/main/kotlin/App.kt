import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember

@Composable
fun App() {
    val users by remember { data.users() }.collectAsState(emptyList())
    Column {
        users.forEach { user ->
            Text(text = user)
        }
        Row {
            IconButton({ data.add("Юзер") }) {
                Icon(Icons.Default.Add, null, tint = MaterialTheme.colorScheme.primary)
            }
            IconButton({ data.delete("Юзер") }) {
                Icon(Icons.Default.Delete, null, tint = MaterialTheme.colorScheme.error)
            }
        }
    }
}

//enum class Dummy { One, Two, Three }
//val d: Dummy = One
//val e = listOf(Dummy.Two, Three)