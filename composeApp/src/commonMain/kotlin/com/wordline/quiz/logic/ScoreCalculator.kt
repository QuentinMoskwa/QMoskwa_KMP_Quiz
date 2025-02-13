package com.wordline.quiz.logic

import com.wordline.quiz.network.data.QuizSettings
import kotlin.math.exp
import kotlin.math.log10

class ScoreCalculator {
    fun calculateScore(timeTaken: Long, settings: QuizSettings): Int {
        var points = when {
            timeTaken < 1000 && settings.isSpeedScoring -> 3
            timeTaken in 1000..1500 && settings.isSpeedScoring -> 2
            else -> 1
        }

        // Si Sudden Death est activé, doubler le score
        if (settings.isSuddenDeath)
        {
            println("sudden")
            points *= 2
        }

        return points
    }
}