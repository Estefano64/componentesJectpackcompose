import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.Layout
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun FlowRow(
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit
) {
    Layout(
        content = content,
        modifier = modifier
    ) { measurables, constraints ->
        val placeables = measurables.map { measurable ->
            measurable.measure(constraints)
        }

        layout(constraints.maxWidth, constraints.maxHeight) {
            var yPosition = 0
            var xPosition = 0
            var maxHeight = 0

            placeables.forEach { placeable ->
                if (xPosition + placeable.width > constraints.maxWidth) {
                    xPosition = 0
                    yPosition += maxHeight
                    maxHeight = 0
                }

                placeable.placeRelative(x = xPosition, y = yPosition)

                xPosition += placeable.width
                if (placeable.height > maxHeight) {
                    maxHeight = placeable.height
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun FlowRowPreview() {
    FlowRow(modifier = Modifier.width(300.dp)) {
        for (i in 1..10) {
            Text(
                "Item $i",
                modifier = Modifier
                    .padding(4.dp)
                    .wrapContentWidth()
            )
        }
    }
}
