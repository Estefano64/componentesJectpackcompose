import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyBackdropScaffold(
    frontLayerContent: @Composable () -> Unit,
    backLayerContent: @Composable () -> Unit,
    modifier: Modifier = Modifier
) {
    var revealed by remember { mutableStateOf(false) }
    val alpha by animateFloatAsState(if (revealed) 1f else 0f)

    Scaffold(
        modifier = modifier,
        topBar = {
            TopAppBar(
                title = { Text("Backdrop Scaffold") },
                navigationIcon = {
                    IconButton(onClick = { revealed = !revealed }) {
                        Icon(Icons.Default.Menu, contentDescription = "Toggle backdrop")
                    }
                }
            )
        }
    ) { innerPadding ->
        Box(modifier = Modifier.padding(innerPadding)) {
            Box(modifier = Modifier.fillMaxSize()) {
                backLayerContent()
            }
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .alpha(alpha)
            ) {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.surface,
                    tonalElevation = 4.dp
                ) {
                    frontLayerContent()
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun BackdropScaffoldPreview() {
    MyBackdropScaffold(
        frontLayerContent = {
            Box(modifier = Modifier.fillMaxSize()) {
                Text("Front Layer Content", modifier = Modifier.padding(16.dp))
            }
        },
        backLayerContent = {
            Box(modifier = Modifier.fillMaxSize()) {
                Text("Back Layer Content", modifier = Modifier.padding(16.dp))
            }
        }
    )
}
