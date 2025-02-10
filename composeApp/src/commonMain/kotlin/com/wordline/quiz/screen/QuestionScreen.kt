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
import com.wordline.quiz.network.data.Question
import com.wordline.quiz.network.data.Quiz
import com.wordline.quiz.network.data.QuizSettings

@Composable
fun QuestionScreen(navController: NavHostController, quiz: Quiz, settings: QuizSettings) {
    var currentQuestionIndex by remember { mutableStateOf(0) }
    var score by remember { mutableStateOf(0) }

    val question = quiz.questions[currentQuestionIndex]

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(question.label, style = MaterialTheme.typography.h5)

        question.answers.forEach { answer ->
            Button(
                onClick = {
                    val isCorrect = answer.id == question.correctId

                    if (isCorrect) {
                        score++
                    } else if (settings.isSuddenDeath) {
                        navController.navigate("score/$score/${quiz.questions.size}")
                        return@Button
                    }

                    if (currentQuestionIndex < quiz.questions.size - 1) {
                        currentQuestionIndex++
                    } else {
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
