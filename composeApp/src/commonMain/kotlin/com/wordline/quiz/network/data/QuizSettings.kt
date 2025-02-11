package com.wordline.quiz.network.data


data class QuizSettings(
    val isTimed: Boolean = false,
    val isSuddenDeath: Boolean = false,
    val isSpeedScoring: Boolean = false
)
