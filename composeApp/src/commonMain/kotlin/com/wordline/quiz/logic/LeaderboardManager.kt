package com.wordline.quiz.logic

import com.wordline.quiz.network.data.PlayerScore

object LeaderboardManager {
    private val scores = mutableListOf<PlayerScore>()

    fun addScore(playerName: String, score: Int) {
        scores.add(PlayerScore(playerName, score))
    }

    fun getTopScores(): List<PlayerScore> = scores.sortedByDescending { it.score }
}
