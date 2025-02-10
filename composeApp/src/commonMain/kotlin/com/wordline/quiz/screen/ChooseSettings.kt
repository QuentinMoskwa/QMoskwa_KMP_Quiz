package com.wordline.quiz.screen

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.selection.SelectionContainer
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.wordline.quiz.network.data.Question
import com.wordline.quiz.network.data.QuizSettings

@Composable
fun ChooseOptionsScreen(
    navController: NavController,
    quizId: Int,
    quizSettings: QuizSettings,
    onSettingsChanged: (QuizSettings) -> Unit,
    onStartQuiz: () -> Unit
) {

    var settings by rememberSaveable { mutableStateOf(quizSettings) }
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Select Options", fontSize = 24.sp)
        Spacer(modifier = Modifier.height(16.dp))

        CheckboxWithLabel("Time Limit", settings.isTimed) {
            settings = settings.copy(isTimed = it)
        }
        CheckboxWithLabel("1 Mistake = Game Over (x2 points)", settings.isSuddenDeath) {
            settings = settings.copy(isSuddenDeath = it)
        }
        CheckboxWithLabel("Time Attack (faster = more points)", settings.isSpeedScoring) {
            settings = settings.copy(isSpeedScoring = it)
        }

        // Utilise quizId ici
        Button(onClick = { navController.navigate("quiz/$quizId") }) {
            Text("Commencer le quiz")
        }
    }
}


@Composable
fun CheckboxWithLabel(label: String, checked: Boolean, onCheckedChange: (Boolean) -> Unit) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.padding(8.dp)
    ) {
        androidx.compose.material.Checkbox(
            checked = checked,
            onCheckedChange = onCheckedChange
        )
        Text(label, modifier = Modifier.padding(start = 8.dp))
    }
}
