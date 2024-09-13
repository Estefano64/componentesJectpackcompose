import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog

@Composable
fun MyDialog(
    onDismissRequest: () -> Unit,
    onConfirmation: () -> Unit,
    dialogTitle: String,
    dialogText: String,
) {
    Dialog(onDismissRequest = { onDismissRequest() }) {
        Card(
            modifier = Modifier
                .padding(16.dp),
            shape = MaterialTheme.shapes.medium,
        ) {
            Column(
                modifier = Modifier.padding(16.dp)
            ) {
                Text(
                    text = dialogTitle,
                    style = MaterialTheme.typography.headlineSmall
                )
                Text(
                    text = dialogText,
                    modifier = Modifier.padding(top = 16.dp, bottom = 24.dp)
                )
                Button(
                    onClick = {
                        onConfirmation()
                    },
                    modifier = Modifier.padding(top = 8.dp)
                ) {
                    Text("Confirm")
                }
            }
        }
    }
}

@Preview
@Composable
fun DialogPreview() {
    var showDialog by remember { mutableStateOf(true) }
    if (showDialog) {
        MyDialog(
            onDismissRequest = { showDialog = false },
            onConfirmation = { showDialog = false },
            dialogTitle = "Dialog Title",
            dialogText = "This is the content of the dialog."
        )
    }
}
