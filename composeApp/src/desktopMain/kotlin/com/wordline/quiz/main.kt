package com.wordline.quiz

import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import com.wordline.quiz.network.data.Question
import com.wordline.quiz.network.data.Quiz
import com.wordline.quiz.screen.CVScreen

fun main() = application {
    Window(
        onCloseRequest = ::exitApplication,
        title = "quiz",
    ) {
        CVScreen()
    }
}