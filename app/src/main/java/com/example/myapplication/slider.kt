import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Slider
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun MySlider(
    value: Float,
    onValueChange: (Float) -> Unit,
    modifier: Modifier = Modifier
) {
    Slider(
        value = value,
        onValueChange = onValueChange,
        valueRange = 0f..100f,
        modifier = modifier
    )
}

@Preview
@Composable
fun SliderPreview() {
    var sliderPosition by remember { mutableStateOf(0f) }
    MySlider(
        value = sliderPosition,
        onValueChange = { sliderPosition = it },
        modifier = Modifier.padding(16.dp)
    )
    Text(
        text = sliderPosition.toInt().toString(),
        modifier = Modifier.padding(16.dp)
    )
}
