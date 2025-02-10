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
fun HomeScreen(navController: NavController) {
    // État pour le pseudo
    var userName by remember { mutableStateOf(TextFieldValue("")) }

    Box(modifier = Modifier.fillMaxSize().padding(16.dp)) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            // Titre de l'app
            Text(
                text = "Quiz App",
                fontSize = 32.sp,
                modifier = Modifier.padding(16.dp),
                color = Color.Black
            )

            // Bouton pour choisir un quiz
            Button(
                modifier = Modifier.padding(top = 16.dp),
                onClick = {
                    // Navigue vers l'écran de choix du quiz
                    navController.navigate("chooseQuiz/General Knowledge")
                }
            ) {
                Text("Choose a Quiz", color = Color.White)
            }

            // Champ d'entrée pour le pseudo
            Column(
                modifier = Modifier
                    .padding(top = 32.dp)
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text("Enter your username", fontSize = 18.sp)
                Spacer(modifier = Modifier.height(8.dp))

                TextField(
                    value = userName,
                    onValueChange = { userName = it },
                    label = { Text("Username") },
                    modifier = Modifier.fillMaxWidth()
                )
            }
        }
    }
}
