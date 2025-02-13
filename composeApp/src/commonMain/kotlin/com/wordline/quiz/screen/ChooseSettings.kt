package com.wordline.quiz.screen

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.selection.SelectionContainer
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.automirrored.filled.ArrowForward
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.Saver
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.wordline.quiz.network.data.QuizSettings

// Définition du Saver personnalisé pour QuizSettings
val quizSettingsSaver = Saver<QuizSettings, List<Boolean>>(
    save = { listOf(it.isTimed, it.isSuddenDeath, it.isSpeedScoring) },
    restore = { QuizSettings(it[0], it[1], it[2]) }
)

@Composable
fun ChooseOptionsScreen(
    navController: NavController,
    quizId: Int,
    quizSettings: QuizSettings
) {
    var settings by rememberSaveable(stateSaver = quizSettingsSaver) { mutableStateOf(quizSettings) }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Options du quiz") },
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Retour")
                    }
                }
            )
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text("Sélectionnez les options", fontSize = 24.sp)
            Spacer(modifier = Modifier.height(16.dp))

            CheckboxWithLabel("Limite de temps", settings.isTimed) {
                settings = settings.copy(isTimed = it)
            }
            CheckboxWithLabel("1 erreur = fin du jeu (x2 points)", settings.isSuddenDeath) {
                settings = settings.copy(isSuddenDeath = it)
            }
            CheckboxWithLabel("Time Attack (plus rapide = plus de points)", settings.isSpeedScoring) {
                settings = settings.copy(isSpeedScoring = it)
            }

            Button(onClick = {
                val time = if (settings.isTimed) 60 else 0
                navController.navigate("quiz/$quizId/${settings.isTimed}/${settings.isSuddenDeath}/${settings.isSpeedScoring}/$time")
            }) {
                Text("Commencer le quiz")
            }
        }
    }
}


@Composable
fun CheckboxWithLabel(label: String, checked: Boolean, onCheckedChange: (Boolean) -> Unit) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.padding(8.dp)
    ) {
        Checkbox(
            checked = checked,
            onCheckedChange = onCheckedChange
        )
        Text(label, modifier = Modifier.padding(start = 8.dp))
    }
}
