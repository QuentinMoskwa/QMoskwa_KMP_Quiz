package com.wordline.quiz.logic

import com.wordline.quiz.network.data.QuizSettings

class ScoreCalculator {
    fun calculateScore(basePoints: Int, timeTaken: Long, settings: QuizSettings): Int {
        var multiplier = 1.0

        if (settings.isSuddenDeath) multiplier *= 2.0
        if (settings.isSpeedScoring) multiplier *= (1.5 - (timeTaken / 10000.0)).coerceAtLeast(0.5)

        return (basePoints * multiplier).toInt()
    }

}