import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun MySpacer(
    size: Int,
    isVertical: Boolean = true,
    modifier: Modifier = Modifier
) {
    if (isVertical) {
        Spacer(modifier = modifier.height(size.dp))
    } else {
        Spacer(modifier = modifier.width(size.dp))
    }
}

@Preview
@Composable
fun SpacerPreview() {
    Column {
        Text("Text before spacer")
        MySpacer(size = 16)
        Text("Text after spacer")
    }
}
