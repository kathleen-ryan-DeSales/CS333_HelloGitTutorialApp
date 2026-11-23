package edu.cs333.hellogittutorialapp
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        enableEdgeToEdge()

        setContent {
            Greeting(
                modifier = Modifier.fillMaxSize()
            )
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Greeting(
    modifier: Modifier = Modifier
) {

        val users = listOf(
            "Doctor Ryan",
            "Doctor Gupta",
            "Professor Shimkanon",
            "Professor Ruggles"
        )

    var selectedUser by remember {
        mutableStateOf(users[0])
    }

    var expanded by remember {
        mutableStateOf(false)
    }

    Box(
        modifier = modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {

        Card(
            modifier = Modifier
                .fillMaxWidth(0.8f)
                .padding(16.dp)
        ) {

            Column(
                modifier = Modifier.padding(24.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {

                Text(
                    text = "Hello Git Users",
                    fontSize = 26.sp
                )

                Text(
                    text = "Selected User: $selectedUser"
                )

                ExposedDropdownMenuBox(
                    expanded = expanded,
                    onExpandedChange = {
                        expanded = !expanded
                    }
                ) {

                    TextField(
                        value = selectedUser,
                        onValueChange = {},
                        readOnly = true,
                        label = {
                            Text("Choose User")
                        },
                        modifier = Modifier.menuAnchor()
                    )

                    ExposedDropdownMenu(
                        expanded = expanded,
                        onDismissRequest = {
                            expanded = false
                        }
                    ) {

                        users.forEach { user ->

                            DropdownMenuItem(
                                text = {
                                    Text(user)
                                },
                                onClick = {
                                    selectedUser = user
                                    expanded = false
                                }
                            )
                        }
                    }
                }
            }
        }
    }
}