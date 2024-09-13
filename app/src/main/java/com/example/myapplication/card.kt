import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun MyCard(
    title: String,
    content: String,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier,
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Text(
            text = title,
            modifier = Modifier.padding(16.dp, 16.dp, 16.dp, 8.dp)
        )
        Text(
            text = content,
            modifier = Modifier.padding(16.dp, 0.dp, 16.dp, 16.dp)
        )
    }
}

@Preview
@Composable
fun CardPreview() {
    MyCard(
        title = "Card Title",
        content = "This is the content of the card.",
        modifier = Modifier.padding(16.dp)
    )
}
