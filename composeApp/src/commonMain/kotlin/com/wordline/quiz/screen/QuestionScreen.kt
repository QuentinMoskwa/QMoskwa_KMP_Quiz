@file:OptIn(ExperimentalAnimationApi::class)

package com.wordline.quiz.screen

import androidx.compose.animation.Crossfade
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
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

    var showResult by remember { mutableStateOf<Boolean?>(null) }

    var lastIsCorrect by remember { mutableStateOf(false) }

    var timeTaken by remember { mutableStateOf(0L) }

    var justAnswered by remember { mutableStateOf(false) }

    if (settings.isTimed) {
        LaunchedEffect(timeLeft) {
            while (timeLeft > 0) {
                delay(1000L)
                timeLeft--
                if (timeLeft == 0) {
                    navController.navigate(
                        "score/$score/${quiz.questions.size}/${quiz.id}/" +
                                "${settings.isTimed}/${settings.isSuddenDeath}/${settings.isSpeedScoring}"
                    )
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
        val question = quiz.questions[currentQuestionIndex]

        Crossfade(
            targetState = showResult,
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
        ) { result ->
            if (result == null) {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(16.dp),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    if (settings.isTimed) {
                        Text("Temps restant : $timeLeft s", style = MaterialTheme.typography.h6)
                    }
                    Text("Score : $score", style = MaterialTheme.typography.h6)
                    Spacer(modifier = Modifier.height(8.dp))

                    Text("Question ${currentQuestionIndex + 1}", fontSize = 20.sp, fontWeight = FontWeight.Bold)
                    Spacer(modifier = Modifier.height(8.dp))

                    Text(question.label, fontSize = 18.sp)
                    Spacer(modifier = Modifier.height(16.dp))

                    question.answers.forEach { answer ->
                        Button(
                            onClick = {
                                timeTaken = startTime.elapsedNow().inWholeMilliseconds
                                val isCorrect = (answer.id == question.correctId)
                                lastIsCorrect = isCorrect

                                if (!isCorrect && settings.isSuddenDeath) {
                                    navController.navigate(
                                        "score/$score/${quiz.questions.size}/${quiz.id}/" +
                                                "${settings.isTimed}/${settings.isSuddenDeath}/${settings.isSpeedScoring}/${timeLeft - 60}"
                                    )
                                } else {
                                    showResult = isCorrect
                                    justAnswered = true
                                }
                            },
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(vertical = 4.dp),
                            shape = MaterialTheme.shapes.small
                        ) {
                            Text(answer.label)
                        }
                    }
                }
            } else {
                val bgColor = if (result) Color(0xFF4CAF50) else Color(0xFFFF5252)
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(bgColor),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = if (result) "Bonne réponse !" else "Mauvaise réponse...",
                        fontSize = 24.sp,
                        color = Color.White
                    )
                }
            }
        }
    }

    LaunchedEffect(showResult, justAnswered) {
        if (showResult != null && justAnswered) {
            delay(1000L)

            if (lastIsCorrect) {
                score += ScoreCalculator().calculateScore(timeTaken, settings)
            }

            if (currentQuestionIndex < quiz.questions.size - 1) {
                currentQuestionIndex++
            } else {
                navController.navigate(
                    "score/$score/${quiz.questions.size}/${quiz.id}/" +
                            "${settings.isTimed}/${settings.isSuddenDeath}/${settings.isSpeedScoring}/${timeTaken - 60}"
                )
            }

            showResult = null
            justAnswered = false
        }
    }
}
