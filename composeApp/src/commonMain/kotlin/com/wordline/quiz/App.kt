package com.wordline.quiz

import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.wordline.quiz.network.data.Answer
import com.wordline.quiz.network.data.Question
import com.wordline.quiz.network.data.Quiz
import com.wordline.quiz.network.data.QuizSettings
import com.wordline.quiz.network.data.quizzes
import com.wordline.quiz.screen.*

@Composable
fun App(
    navController: NavHostController = rememberNavController()
) {
    var playerName by remember { mutableStateOf("") }

    MaterialTheme {
        NavHost(
            navController = navController,
            startDestination = "welcome"
        ) {
            composable("welcome") {
                HomeScreen(
                    playerName = playerName,
                    onNameEntered = { name -> playerName = name },
                    onStartButtonPushed = { navController.navigate("choose_quiz") }
                )
            }
            composable("choose_quiz") {
                ChooseQuizScreen(
                    navController = navController,
                    quizzes = quizzes
                )
            }

            composable("choose_options/{quizId}") { backStackEntry ->
                val quizId = backStackEntry.arguments?.getString("quizId")?.toIntOrNull()
                val selectedQuiz = quizzes.find { it.id == quizId }

                if (quizId != null) {
                    ChooseOptionsScreen(navController, quizId, QuizSettings())
                }

            }
            composable("quiz/{quizId}/{isTimed}/{isSuddenDeath}/{isSpeedScoring}/{timeLeft}") { backStackEntry ->
                val quizId = backStackEntry.arguments?.getString("quizId")?.toIntOrNull()
                val isTimed = backStackEntry.arguments?.getString("isTimed")?.toBoolean() ?: false
                val isSuddenDeath = backStackEntry.arguments?.getString("isSuddenDeath")?.toBoolean() ?: false
                val isSpeedScoring = backStackEntry.arguments?.getString("isSpeedScoring")?.toBoolean() ?: false
                var timeLeft = backStackEntry.arguments?.getString("timeLeft")?.toIntOrNull() ?: 0
                val settings = QuizSettings(isTimed, isSuddenDeath, isSpeedScoring)

                val selectedQuiz = quizzes.find { it.id == quizId }

                if (selectedQuiz != null) {
                    QuestionScreen(navController, selectedQuiz, settings, timeLeft)
                }
            }

            composable("score/{score}/{total}/{quizId}/{isTimed}/{isSuddenDeath}/{isSpeedScoring}/{timeLeft}") { backStackEntry ->
                val score = backStackEntry.arguments?.getString("score")?.toIntOrNull() ?: 0
                val total = backStackEntry.arguments?.getString("total")?.toIntOrNull() ?: 1
                val quizId = backStackEntry.arguments?.getString("quizId")?.toIntOrNull()
                val isTimed = backStackEntry.arguments?.getString("isTimed")?.toBoolean() ?: false
                val isSuddenDeath = backStackEntry.arguments?.getString("isSuddenDeath")?.toBoolean() ?: false
                val isSpeedScoring = backStackEntry.arguments?.getString("isSpeedScoring")?.toBoolean() ?: false
                val settings = QuizSettings(isTimed, isSuddenDeath, isSpeedScoring)

                ScoreScreen(
                    playerName = if (playerName.isEmpty()) "Player" else playerName,
                    score = score,
                    total = total,
                    onRetry = {
                        if (quizId != null) {
                            navController.navigate("quiz/$quizId/$isTimed/$isSuddenDeath/$isSpeedScoring/60")
                        }
                    },
                    onQuizSelection = { navController.navigate("choose_quiz") },
                    onHome = { navController.navigate("welcome") }
                )
            }

        }
    }
}

//TODO bien faire la réinit de timeStart/Taken lors du switch de question