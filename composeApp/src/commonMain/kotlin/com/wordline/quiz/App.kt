package com.wordline.quiz

import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.*
import com.wordline.quiz.network.data.Answer
import com.wordline.quiz.network.data.Question
import com.wordline.quiz.screen.HomeScreen
import com.wordline.quiz.screen.QuestionScreen

@Composable
fun App() {
    MaterialTheme {
        HomeScreen()
    }
}
