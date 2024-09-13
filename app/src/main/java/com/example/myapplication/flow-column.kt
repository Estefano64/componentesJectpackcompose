import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.Layout
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun FlowColumn(
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
            var maxWidth = 0

            placeables.forEach { placeable ->
                if (yPosition + placeable.height > constraints.maxHeight) {
                    yPosition = 0
                    xPosition += maxWidth
                    maxWidth = 0
                }

                placeable.placeRelative(x = xPosition, y = yPosition)

                yPosition += placeable.height
                if (placeable.width > maxWidth) {
                    maxWidth = placeable.width
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun FlowColumnPreview() {
    FlowColumn(modifier = Modifier.height(300.dp)) {
        for (i in 1..10) {
            Text(
                "Item $i",
                modifier = Modifier
                    .padding(4.dp)
                    .wrapContentHeight()
            )
        }
    }
}
