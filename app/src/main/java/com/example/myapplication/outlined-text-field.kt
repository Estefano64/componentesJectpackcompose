import androidx.compose.foundation.layout.padding
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun MyOutlinedTextField(
    label: String,
    value: String,
    onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    OutlinedTextField(
        value = value,
        onValueChange = onValueChange,
        label = { Text(label) },
        modifier = modifier
    )
}

@Preview
@Composable
fun OutlinedTextFieldPreview() {
    var text by remember { mutableStateOf("") }
    MyOutlinedTextField(
        label = "Enter text",
        value = text,
        onValueChange = { text = it },
        modifier = Modifier.padding(16.dp)
    )
}
