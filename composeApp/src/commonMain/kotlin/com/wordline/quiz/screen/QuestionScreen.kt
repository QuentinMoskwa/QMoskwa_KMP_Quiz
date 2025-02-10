package com.wordline.quiz.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.selection.selectableGroup
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.LinearProgressIndicator
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
import com.wordline.quiz.network.data.Question

@Composable
fun QuestionScreen(questions: List<Question>) {

    var progress by remember { mutableStateOf(0) }
    var selectedAnswer by remember { mutableStateOf(1) }
    var score by remember { mutableStateOf(0) }

    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier.fillMaxHeight()
        ) {
            // Question Label in a Card
            Card(
                shape = RoundedCornerShape(8.dp),
                backgroundColor = Color.LightGray,
                modifier = Modifier
                    .padding(bottom = 16.dp)
            ) {
                Text(
                    text = questions[progress].label,
                    modifier = Modifier.padding(16.dp),
                    color = Color.Black
                )
            }

            // Answer Options
            Column(
                modifier = Modifier
                    .selectableGroup()
                    .padding(bottom = 32.dp),
                horizontalAlignment = Alignment.Start
            ) {
                questions[progress].answers.forEach { answer ->
                    Row(
                        modifier = Modifier.padding(vertical = 8.dp),
                        verticalAlignment = CenterVertically
                    ) {
                        RadioButton(
                            modifier = Modifier.padding(end = 16.dp),
                            selected = (selectedAnswer == answer.id),
                            onClick = { selectedAnswer = answer.id },
                        )
                        Text(text = answer.label)
                    }
                }
            }
        }

        // Footer Section (Button and Progress)
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Bottom,
            modifier = Modifier
                .fillMaxHeight()
        ) {
            Button(
                modifier = Modifier.padding(20.dp),
                onClick = {
                    if (selectedAnswer == questions[progress].correctId) {
                        score++
                    }
                    if (progress < questions.size - 1) {
                        progress++
                        selectedAnswer = 1
                    } else {
                        // Go to the score section
                    }
                }
            ) {
                if (progress < questions.size - 1) nextOrDoneButton(Icons.AutoMirrored.Filled.ArrowForward, "Next")
                else nextOrDoneButton(Icons.Filled.Done, "Done")
            }

            LinearProgressIndicator(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(20.dp),
                progress = progress.div(questions.size.toFloat()).plus(1.div(questions.size.toFloat()))
            )
        }
    }
}

@Composable
fun nextOrDoneButton(iv: ImageVector, label: String) {
    Icon(
        iv,
        contentDescription = "Localized description",
        Modifier.padding(end = 15.dp)
    )
    Text(label)
}
