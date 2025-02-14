package com.wordline.quiz.network.data

import kotlinx.serialization.Serializable

@Serializable
data class LeaderboardEntry(val quizId: Int, val pseudo: String, val score: Int)
