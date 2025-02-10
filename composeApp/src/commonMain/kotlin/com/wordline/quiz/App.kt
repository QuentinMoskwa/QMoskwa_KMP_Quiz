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
                    ChooseOptionsScreen(navController, quizId, QuizSettings(), {}, {})
                }

            }
            // TODO insérer les settings dans le quiz
            composable("quiz/{quizId}") { backStackEntry ->
                val quizId = backStackEntry.arguments?.getString("quizId")?.toIntOrNull()
                val selectedQuiz = quizzes.find { it.id == quizId }

                if (selectedQuiz != null) {
                    QuestionScreen(navController, selectedQuiz)
                }
            }
            composable("score/{score}/{total}") { backStackEntry ->
                val score = backStackEntry.arguments?.getString("score")?.toIntOrNull() ?: 0
                val total = backStackEntry.arguments?.getString("total")?.toIntOrNull() ?: 1

                ScoreScreen(
                    playerName = if (playerName.isEmpty()) "Player" else playerName,
                    score = score,
                    total = total,
                    onRetry = { navController.navigate("choose_quiz") }
                )
            }
        }
    }
}
