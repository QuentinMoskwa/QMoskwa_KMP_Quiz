package com.wordline.quiz.screen

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.selection.SelectionContainer
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.wordline.quiz.network.data.Question

@Composable
fun ChooseQuizScreen(navController: NavController, quizTitle: String) {
    var isTimed by remember { mutableStateOf(false) }
    var isSuddenDeath by remember { mutableStateOf(false) }
    var isSpeedScoring by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // 🏆 Titre du quiz sélectionné
        Text(
            text = quizTitle,
            fontSize = 28.sp,
            modifier = Modifier.padding(bottom = 16.dp)
        )

        // 📌 Liste des options disponibles
        Column(modifier = Modifier.fillMaxWidth()) {
            QuizOption("⏳ Mode Chronométré", isTimed) { isTimed = it }
            QuizOption("💀 Mort Subite (1 erreur = fin)", isSuddenDeath) { isSuddenDeath = it }
            QuizOption("⚡ Réponse rapide = + de points", isSpeedScoring) { isSpeedScoring = it }
        }

        // ✅ Bouton de confirmation
        Button(
            onClick = {
                navController.navigate("quiz/$isTimed/$isSuddenDeath/$isSpeedScoring")
            },
            modifier = Modifier
                .padding(top = 20.dp)
                .fillMaxWidth(0.8f)
        ) {
            Text("Lancer le Quiz", fontSize = 18.sp)
        }
    }
}

// 📌 Composable réutilisable pour les options de quiz
@Composable
fun QuizOption(text: String, checked: Boolean, onCheckedChange: (Boolean) -> Unit) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
    ) {
        Checkbox(checked = checked, onCheckedChange = onCheckedChange)
        Text(text, fontSize = 18.sp, modifier = Modifier.padding(start = 8.dp))
    }
}
