import androidx.compose.foundation.layout.Column
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun MyTabRow(
    tabs: List<String>,
    modifier: Modifier = Modifier
) {
    var selectedTabIndex by remember { mutableStateOf(0) }

    Column(modifier = modifier) {
        TabRow(selectedTabIndex = selectedTabIndex) {
            tabs.forEachIndexed { index, title ->
                Tab(
                    text = { Text(title) },
                    selected = selectedTabIndex == index,
                    onClick = { selectedTabIndex = index }
                )
            }
        }
        
        // Content for the selected tab
        Text(
            text = "Content for ${tabs[selectedTabIndex]}",
            modifier = Modifier.weight(1f)
        )
    }
}

@Preview
@Composable
fun TabRowPreview() {
    val tabs = listOf("Tab 1", "Tab 2", "Tab 3")
    MyTabRow(tabs = tabs)
}
