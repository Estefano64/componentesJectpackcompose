import androidx.compose.foundation.layout.padding
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyTooltip(
    tooltip: String,
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit
) {
    val tooltipState = rememberTooltipState()

    TooltipBox(
        state = tooltipState,
        positionProvider = TooltipDefaults.rememberPlainTooltipPositionProvider(),
        tooltip = {
            PlainTooltip {
                Text(tooltip)
            }
        },
        modifier = modifier
    ) {
        // Aquí definimos explícitamente el contenido
        content()
    }
}

@Preview
@Composable
fun TooltipPreview() {
    MyTooltip(
        tooltip = "Este es un tooltip",
        modifier = Modifier.padding(16.dp)
    ) {
        // Este es el contenido que se muestra junto con el tooltip
        Button(onClick = { }) {
            Text("Pásame el ratón")
        }
    }
}
