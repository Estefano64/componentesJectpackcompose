import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun MyLazyColumn(items: List<String>, modifier: Modifier = Modifier) {
    LazyColumn(modifier = modifier) {
        items(items) { item ->
            Text(text = item)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun LazyColumnPreview() {
    val sampleItems = List(100) { "Item $it" }
    MyLazyColumn(items = sampleItems)
}
