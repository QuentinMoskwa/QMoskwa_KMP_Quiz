package com.wordline.quiz.network.data

data class Quiz(
    val id: Int,
    val name: String,
    val questions: List<Question>
)
