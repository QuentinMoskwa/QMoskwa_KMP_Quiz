package com.wordline.quiz.network.data

data class QuizSettings(
    val isTimed: Boolean = false,          // Temps limité
    val isSuddenDeath: Boolean = false,    // 1 erreur = fin du quiz
    val isSpeedScoring: Boolean = false    // Bonus selon rapidité
)