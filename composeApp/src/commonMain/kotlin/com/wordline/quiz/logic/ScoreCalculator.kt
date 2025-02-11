package com.wordline.quiz.logic

import com.wordline.quiz.network.data.QuizSettings
import kotlin.math.exp
import kotlin.math.log10

class ScoreCalculator {
    fun calculateScore(basePoints: Int, timeTaken: Long, settings: QuizSettings): Int {
        var multiplier = 1.0

        // Si Sudden Death est activé, multiplier le score par 2
        if (settings.isSuddenDeath) multiplier *= 2.0

        // Si Speed Scoring est activé, on augmente le score en fonction du temps pris
        if (settings.isSpeedScoring) {
            println("on est en speed scoring")

            // Calcul du multiplicateur basé sur le temps pris, avec une fonction logarithmique
            val timeMultiplier = (exp(-timeTaken / 200.0) * 2 + 1).coerceAtMost(3.0)

            multiplier *= timeMultiplier
        }



        // On s'assure que le score de base est au moins égal à 1
        val finalBasePoints = basePoints.coerceAtLeast(1)

        // Calcul du score final avec le multiplicateur
        return (finalBasePoints * multiplier).toInt()
    }
}
