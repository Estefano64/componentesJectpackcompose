import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun MySnackbar(
    message: String,
    actionLabel: String? = null,
    onActionClick: (() -> Unit)? = null,
    onDismiss: () -> Unit,
    modifier: Modifier = Modifier
) {
    Snackbar(
        action = {
            if (actionLabel != null) {
                TextButton(onClick = { 
                    onActionClick?.invoke()
                    onDismiss()
                }) {
                    Text(actionLabel)
                }
            }
        },
        modifier = modifier
    ) {
        Text(message)
    }
}

@Preview
@Composable
fun SnackbarPreview() {
    var showSnackbar by remember { mutableStateOf(true) }
    
    if (showSnackbar) {
        MySnackbar(
            message = "This is a snackbar",
            actionLabel = "Dismiss",
            onDismiss = { showSnackbar = false }
        )
    }
}
