import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun MyLazyRow(items: List<String>, modifier: Modifier = Modifier) {
    LazyRow(modifier = modifier) {
        items(items) { item ->
            Text(text = item)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun LazyRowPreview() {
    val sampleItems = List(20) { "Item $it" }
    MyLazyRow(items = sampleItems)
}
