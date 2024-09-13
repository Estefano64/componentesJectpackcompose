import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout

@Composable
fun MyConstraintLayout(modifier: Modifier = Modifier) {
    ConstraintLayout(modifier = modifier.size(300.dp)) {
        val (button1, button2, text) = createRefs()

        Button(
            onClick = { /* TODO */ },
            modifier = Modifier.constrainAs(button1) {
                top.linkTo(parent.top, margin = 16.dp)
                start.linkTo(parent.start, margin = 16.dp)
            }
        ) {
            Text("Button 1")
        }

        Button(
            onClick = { /* TODO */ },
            modifier = Modifier.constrainAs(button2) {
                top.linkTo(parent.top, margin = 16.dp)
                end.linkTo(parent.end, margin = 16.dp)
            }
        ) {
            Text("Button 2")
        }

        Text("Centered Text", modifier = Modifier.constrainAs(text) {
            top.linkTo(button1.bottom, margin = 16.dp)
            start.linkTo(parent.start)
            end.linkTo(parent.end)
        })
    }
}

@Preview(showBackground = true)
@Composable
fun ConstraintLayoutPreview() {
    MyConstraintLayout()
}