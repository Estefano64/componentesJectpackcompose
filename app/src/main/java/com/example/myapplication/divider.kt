import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun MyDivider(
    modifier: Modifier = Modifier,
    color: Color = Color.Gray,
    thickness: Int = 1
) {
    Divider(
        modifier = modifier,
        color = color,
        thickness = thickness.dp
    )
}

@Preview
@Composable
fun DividerPreview() {
    Text("Text above divider")
    MyDivider(modifier = Modifier.padding(vertical = 8.dp))
    Text("Text below divider")
}
