package com.wordline.quiz.screen

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun HomeScreen(playerName: String, onNameEntered: (String) -> Unit, onStartButtonPushed: () -> Unit) {
    var name by remember { mutableStateOf(playerName) }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Enter your name:", fontSize = 20.sp)
        BasicTextField(
            value = name,
            onValueChange = { name = it; onNameEntered(it) },
            modifier = Modifier.padding(16.dp)
        )
        Button(onClick = onStartButtonPushed) {
            Text("Choose Quiz")
        }
    }
}
