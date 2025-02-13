package com.wordline.quiz.screen

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.selection.selectableGroup
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.automirrored.filled.ArrowForward
import androidx.compose.material.icons.filled.Done
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.wordline.quiz.logic.ScoreCalculator
import com.wordline.quiz.network.data.Question
import com.wordline.quiz.network.data.Quiz
import com.wordline.quiz.network.data.QuizSettings
import kotlinx.coroutines.delay
import kotlin.time.TimeSource

@Composable
fun QuestionScreen(
    navController: NavHostController,
    quiz: Quiz,
    settings: QuizSettings,
    initialTimeLeft: Int
) {
    var currentQuestionIndex by remember { mutableStateOf(0) }
    var score by remember { mutableStateOf(0) }
    var timeLeft by remember { mutableStateOf(initialTimeLeft) }
    var startTime by remember { mutableStateOf(TimeSource.Monotonic.markNow()) }

    val question = quiz.questions[currentQuestionIndex]
    var timeTaken by remember { mutableStateOf(0L) }

    if (settings.isTimed) {
        LaunchedEffect(timeLeft) {
            while (timeLeft > 0) {
                delay(1000L)
                timeLeft--
                if (timeLeft == 0) {
                    navController.navigate("score/$score/${quiz.questions.size}/${quiz.id}/${settings.isTimed}/${settings.isSuddenDeath}/${settings.isSpeedScoring}")
                }
            }
        }
    }

    LaunchedEffect(currentQuestionIndex) {
        startTime = TimeSource.Monotonic.markNow()
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Quiz") },
                navigationIcon = {
                    IconButton(onClick = { navController.navigate("welcome") }) {
                        Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Accueil")
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
            if (settings.isTimed) {
                Text("Time Left: $timeLeft", style = MaterialTheme.typography.h6)
            }
            Text("Score: $score", style = MaterialTheme.typography.h5)
            Text("Question ${currentQuestionIndex + 1}", style = MaterialTheme.typography.h5)
            Text(question.label, style = MaterialTheme.typography.h5)

            question.answers.forEach { answer ->
                Button(
                    onClick = {
                        timeTaken = startTime.elapsedNow().inWholeMilliseconds
                        val isCorrect = answer.id == question.correctId

                        if (isCorrect) {
                            println("Répondu en ${timeTaken}ms")
                            score += ScoreCalculator().calculateScore(timeTaken, settings)

                        } else if (settings.isSuddenDeath) {
                            navController.navigate("score/$score/${quiz.questions.size}/${quiz.id}/${settings.isTimed}/${settings.isSuddenDeath}/${settings.isSpeedScoring}/${timeLeft - 60}")
                            return@Button
                        }

                        if (currentQuestionIndex < quiz.questions.size - 1) {
                            currentQuestionIndex++
                        } else {
                            navController.navigate("score/$score/${quiz.questions.size}/${quiz.id}/${settings.isTimed}/${settings.isSuddenDeath}/${settings.isSpeedScoring}/${timeTaken - 60}")
                        }
                    },
                    modifier = Modifier.padding(8.dp)
                ) {
                    Text(answer.label)
                }
            }
        }
    }
}
