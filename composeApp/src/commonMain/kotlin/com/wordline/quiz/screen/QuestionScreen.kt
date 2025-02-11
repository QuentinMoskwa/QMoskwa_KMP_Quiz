package com.wordline.quiz.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.selection.selectableGroup
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.LinearProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.RadioButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowForward
import androidx.compose.material.icons.filled.Done
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.wordline.quiz.logic.ScoreCalculator
import com.wordline.quiz.network.data.Question
import com.wordline.quiz.network.data.Quiz
import com.wordline.quiz.network.data.QuizSettings
import kotlinx.coroutines.delay
import kotlin.time.TimeSource
import kotlin.time.DurationUnit
import kotlin.time.toDuration

@Composable
fun QuestionScreen(navController: NavHostController, quiz: Quiz, settings: QuizSettings, initialTimeLeft: Int) {
    var currentQuestionIndex by remember { mutableStateOf(0) }
    var score by remember { mutableStateOf(0) }
    var timeLeft by remember { mutableStateOf(initialTimeLeft) }
    var startTime by remember { mutableStateOf(TimeSource.Monotonic.markNow()) }  // Utilisation de TimeSource.Monotonic

    val question = quiz.questions[currentQuestionIndex]
    var timeTaken by remember { mutableStateOf(0L) }  // Stockage du temps écoulé

    // Si le quiz est chronométré, décrémenter le temps toutes les secondes
    if (settings.isTimed) {
        LaunchedEffect(timeLeft) {
            var remainingTime = timeLeft
            while (remainingTime > 0) {
                delay(1000L)
                remainingTime--
                timeLeft = remainingTime // Mise à jour du temps restant
                // Si le temps est écoulé, aller directement à la page de score
                if (remainingTime == 0) {
                    navController.navigate("score/$score/${quiz.questions.size}")
                }
            }
        }
    }

    // Calcule du temps écoulé entre deux questions
    LaunchedEffect(currentQuestionIndex) {
        val elapsed = startTime.elapsedNow().inWholeMilliseconds
        timeTaken = elapsed // Mise à jour du temps écoulé

        // Réinitialisation du chrono dès que la question change
        startTime = TimeSource.Monotonic.markNow()
    }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Affichage du timer
        if (settings.isTimed) {
            Text("Time Left: $timeLeft", style = MaterialTheme.typography.h6)
        }
        Text("Score : ${score}", style = MaterialTheme.typography.h5)

        Text("Question ${currentQuestionIndex + 1}", style = MaterialTheme.typography.h5)

        // Affichage de la question
        Text(question.label, style = MaterialTheme.typography.h5)

        // Affichage des réponses possibles
        question.answers.forEach { answer ->
            Button(
                onClick = {
                    val isCorrect = answer.id == question.correctId

                    // Si la réponse est correcte, calculer et mettre à jour le score
                    if (isCorrect) {
                        // Calcul du score avec Speed Scoring et Sudden Death
                        if(settings.isSpeedScoring)
                        {
                            println("répondu en ${timeTaken}ms")
                        }
                        score = score + ScoreCalculator().calculateScore(1, timeTaken, settings)
                    } else if (settings.isSuddenDeath) {
                        // Fin du quiz en cas d'échec en mode "Sudden Death"
                        navController.navigate("score/$score/${quiz.questions.size}")
                        return@Button
                    }

                    // Si on n'est pas à la dernière question, on passe à la suivante
                    if (currentQuestionIndex < quiz.questions.size - 1) {
                        currentQuestionIndex++ // Passage à la question suivante
                    } else {
                        // Fin du quiz si on est à la dernière question
                        navController.navigate("score/$score/${quiz.questions.size}")
                    }
                },
                modifier = Modifier.padding(8.dp)
            ) {
                Text(answer.label)
            }
        }
    }
}
