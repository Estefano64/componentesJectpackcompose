import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun MyBottomNavigation(
    modifier: Modifier = Modifier
) {
    var selectedItem by remember { mutableStateOf(0) }
    val items = listOf("Home", "Favorites", "Settings")
    val icons = listOf(Icons.Filled.Home, Icons.Filled.Favorite, Icons.Filled.Settings)

    NavigationBar(
        modifier = modifier
    ) {
        items.forEachIndexed { index, item ->
            NavigationBarItem(
                icon = { Icon(icons[index], contentDescription = item) },
                label = { Text(item) },
                selected = selectedItem == index,
                onClick = { selectedItem = index }
            )
        }
    }
}

@Preview
@Composable
fun BottomNavigationPreview() {
    MyBottomNavigation()
}
