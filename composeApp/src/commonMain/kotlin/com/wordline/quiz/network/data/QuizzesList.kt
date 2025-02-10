package com.wordline.quiz.network.data

// Définition des quiz disponibles
val quizzes = listOf(
        Quiz(
            id = 1,
            name = "Histoire",
            questions = listOf(
                Question(
                    id = 1,
                    label = "Qui a été le premier président des États-Unis ?",
                    correctId = 1,
                    answers = listOf(
                        Answer(1, "George Washington"),
                        Answer(2, "Abraham Lincoln"),
                        Answer(3, "Thomas Jefferson"),
                        Answer(4, "John Adams")
                    )
                ),
                Question(
                    id = 2,
                    label = "En quelle année la Révolution française a-t-elle commencé ?",
                    correctId = 3,
                    answers = listOf(
                        Answer(1, "1785"),
                        Answer(2, "1795"),
                        Answer(3, "1789"),
                        Answer(4, "1776")
                    )
                )
            )
        ),
        Quiz(
            id = 2,
            name = "Science",
            questions = listOf(
                Question(
                    id = 3,
                    label = "Quel est l'élément chimique avec le symbole 'O' ?",
                    correctId = 1,
                    answers = listOf(
                        Answer(1, "Oxygène"),
                        Answer(2, "Or"),
                        Answer(3, "Osmium"),
                        Answer(4, "Ozone")
                    )
                ),
                Question(
                    id = 4,
                    label = "Quelle planète est la plus proche du Soleil ?",
                    correctId = 2,
                    answers = listOf(
                        Answer(1, "Terre"),
                        Answer(2, "Mercure"),
                        Answer(3, "Vénus"),
                        Answer(4, "Mars")
                    )
                )
            )
        ),
        Quiz(
            id = 3,
            name = "Géographie",
            questions = listOf(
                Question(
                    id = 5,
                    label = "Quel est le plus grand océan du monde ?",
                    correctId = 3,
                    answers = listOf(
                        Answer(1, "Atlantique"),
                        Answer(2, "Indien"),
                        Answer(3, "Pacifique"),
                        Answer(4, "Arctique")
                    )
                ),
                Question(
                    id = 6,
                    label = "Quel est le pays le plus vaste du monde ?",
                    correctId = 1,
                    answers = listOf(
                        Answer(1, "Russie"),
                        Answer(2, "Canada"),
                        Answer(3, "Chine"),
                        Answer(4, "États-Unis")
                    )
                )
            )
        )
    )
