import androidx.compose.foundation.layout.Box
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun MyDropDownMenu(
    items: List<String>,
    onItemSelected: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    var expanded by remember { mutableStateOf(false) }
    var selectedIndex by remember { mutableStateOf(0) }

    Box(modifier = modifier) {
        TextButton(onClick = { expanded = true }) {
            Text(items[selectedIndex])
        }
        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false }
        ) {
            items.forEachIndexed { index, item ->
                DropdownMenuItem(
                    text = { Text(item) },
                    onClick = {
                        selectedIndex = index
                        expanded = false
                        onItemSelected(item)
                    }
                )
            }
        }
    }
}

@Preview
@Composable
fun DropDownMenuPreview() {
    val items = listOf("Item 1", "Item 2", "Item 3")
    MyDropDownMenu(items = items, onItemSelected = { })
}
