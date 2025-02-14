package com.wordline.quiz.network.data

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
            ),
            Question(
                id = 3,
                label = "Quel pays Napoléon Bonaparte a-t-il dirigé ?",
                correctId = 1,
                answers = listOf(
                    Answer(1, "France"),
                    Answer(2, "Italie"),
                    Answer(3, "Espagne"),
                    Answer(4, "Royaume-Uni")
                )
            ),
            Question(
                id = 4,
                label = "Qui a découvert l'Amérique en 1492 ?",
                correctId = 2,
                answers = listOf(
                    Answer(1, "Ferdinand Magellan"),
                    Answer(2, "Christophe Colomb"),
                    Answer(3, "Vasco de Gama"),
                    Answer(4, "James Cook")
                )
            ),
            Question(
                id = 5,
                label = "Dans quelle ville fut signée la Déclaration d'Indépendance des États-Unis ?",
                correctId = 3,
                answers = listOf(
                    Answer(1, "Boston"),
                    Answer(2, "New York"),
                    Answer(3, "Philadelphie"),
                    Answer(4, "Washington D.C.")
                )
            ),
            Question(
                id = 6,
                label = "Quelle reine d'Égypte était la compagne de Jules César ?",
                correctId = 4,
                answers = listOf(
                    Answer(1, "Néfertiti"),
                    Answer(2, "Hatchepsout"),
                    Answer(3, "Taousert"),
                    Answer(4, "Cléopâtre")
                )
            ),
            Question(
                id = 7,
                label = "Quel traité a mis fin à la Première Guerre mondiale ?",
                correctId = 2,
                answers = listOf(
                    Answer(1, "Traité de Paris"),
                    Answer(2, "Traité de Versailles"),
                    Answer(3, "Traité de Moscou"),
                    Answer(4, "Traité de Berlin")
                )
            ),
            Question(
                id = 8,
                label = "Quelle guerre a opposé les Cavaliers et les Têtes rondes au XVIIe siècle ?",
                correctId = 3,
                answers = listOf(
                    Answer(1, "La guerre de Trente Ans"),
                    Answer(2, "La guerre de Cent Ans"),
                    Answer(3, "La guerre civile anglaise"),
                    Answer(4, "La guerre des Deux Roses")
                )
            ),
            Question(
                id = 9,
                label = "En quelle année a eu lieu la chute du mur de Berlin ?",
                correctId = 1,
                answers = listOf(
                    Answer(1, "1989"),
                    Answer(2, "1979"),
                    Answer(3, "1991"),
                    Answer(4, "1986")
                )
            ),
            Question(
                id = 10,
                label = "Qui fut le premier empereur romain ?",
                correctId = 4,
                answers = listOf(
                    Answer(1, "Néron"),
                    Answer(2, "Caligula"),
                    Answer(3, "César"),
                    Answer(4, "Auguste")
                )
            )
        )
    ),
    Quiz(
        id = 2,
        name = "Science",
        questions = listOf(
            Question(
                id = 1,
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
                id = 2,
                label = "Quelle planète est la plus proche du Soleil ?",
                correctId = 2,
                answers = listOf(
                    Answer(1, "Terre"),
                    Answer(2, "Mercure"),
                    Answer(3, "Vénus"),
                    Answer(4, "Mars")
                )
            ),
            Question(
                id = 3,
                label = "Quelle est la vitesse de la lumière dans le vide (approximativement) ?",
                correctId = 3,
                answers = listOf(
                    Answer(1, "100 000 km/s"),
                    Answer(2, "200 000 km/s"),
                    Answer(3, "300 000 km/s"),
                    Answer(4, "400 000 km/s")
                )
            ),
            Question(
                id = 4,
                label = "Qui a proposé la théorie de la relativité ?",
                correctId = 1,
                answers = listOf(
                    Answer(1, "Albert Einstein"),
                    Answer(2, "Isaac Newton"),
                    Answer(3, "Galilée"),
                    Answer(4, "Nikola Tesla")
                )
            ),
            Question(
                id = 5,
                label = "Quelle molécule est la plus abondante dans l'atmosphère terrestre ?",
                correctId = 4,
                answers = listOf(
                    Answer(1, "Oxygène (O2)"),
                    Answer(2, "Dioxyde de carbone (CO2)"),
                    Answer(3, "Vapeur d'eau (H2O)"),
                    Answer(4, "Diazote (N2)")
                )
            ),
            Question(
                id = 6,
                label = "Quel est le plus grand organe du corps humain ?",
                correctId = 2,
                answers = listOf(
                    Answer(1, "Le foie"),
                    Answer(2, "La peau"),
                    Answer(3, "Les poumons"),
                    Answer(4, "Le cœur")
                )
            ),
            Question(
                id = 7,
                label = "Quelle particule subatomique possède une charge négative ?",
                correctId = 3,
                answers = listOf(
                    Answer(1, "Proton"),
                    Answer(2, "Neutron"),
                    Answer(3, "Électron"),
                    Answer(4, "Positron")
                )
            ),
            Question(
                id = 8,
                label = "Quel scientifique a découvert la pénicilline ?",
                correctId = 4,
                answers = listOf(
                    Answer(1, "Marie Curie"),
                    Answer(2, "Louis Pasteur"),
                    Answer(3, "Robert Koch"),
                    Answer(4, "Alexander Fleming")
                )
            ),
            Question(
                id = 9,
                label = "Combien de paires de chromosomes possède un être humain ?",
                correctId = 1,
                answers = listOf(
                    Answer(1, "23 paires"),
                    Answer(2, "24 paires"),
                    Answer(3, "22 paires"),
                    Answer(4, "46 paires")
                )
            ),
            Question(
                id = 10,
                label = "Quelle est la formule chimique de l'eau ?",
                correctId = 2,
                answers = listOf(
                    Answer(1, "CO2"),
                    Answer(2, "H2O"),
                    Answer(3, "O2"),
                    Answer(4, "H2O2")
                )
            )
        )
    ),
    Quiz(
        id = 3,
        name = "Géographie",
        questions = listOf(
            Question(
                id = 1,
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
                id = 2,
                label = "Quel est le pays le plus vaste du monde ?",
                correctId = 1,
                answers = listOf(
                    Answer(1, "Russie"),
                    Answer(2, "Canada"),
                    Answer(3, "Chine"),
                    Answer(4, "États-Unis")
                )
            ),
            Question(
                id = 3,
                label = "Quelle est la capitale de l'Australie ?",
                correctId = 3,
                answers = listOf(
                    Answer(1, "Sydney"),
                    Answer(2, "Melbourne"),
                    Answer(3, "Canberra"),
                    Answer(4, "Brisbane")
                )
            ),
            Question(
                id = 4,
                label = "Dans quel pays se trouve la célèbre Tour de Pise ?",
                correctId = 4,
                answers = listOf(
                    Answer(1, "Espagne"),
                    Answer(2, "France"),
                    Answer(3, "Grèce"),
                    Answer(4, "Italie")
                )
            ),
            Question(
                id = 5,
                label = "Quel est le plus long fleuve du monde ?",
                correctId = 1,
                answers = listOf(
                    Answer(1, "Le Nil"),
                    Answer(2, "L'Amazone"),
                    Answer(3, "Le Mississippi"),
                    Answer(4, "Le Yangtsé")
                )
            ),
            Question(
                id = 6,
                label = "Quelle montagne est la plus haute du monde au-dessus du niveau de la mer ?",
                correctId = 2,
                answers = listOf(
                    Answer(1, "K2"),
                    Answer(2, "Everest"),
                    Answer(3, "Kangchenjunga"),
                    Answer(4, "Lhotse")
                )
            ),
            Question(
                id = 7,
                label = "Quelle est la capitale du Canada ?",
                correctId = 4,
                answers = listOf(
                    Answer(1, "Toronto"),
                    Answer(2, "Vancouver"),
                    Answer(3, "Montréal"),
                    Answer(4, "Ottawa")
                )
            ),
            Question(
                id = 8,
                label = "Quel pays est surnommé le 'pays du soleil levant' ?",
                correctId = 3,
                answers = listOf(
                    Answer(1, "Chine"),
                    Answer(2, "Corée du Sud"),
                    Answer(3, "Japon"),
                    Answer(4, "Thaïlande")
                )
            ),
            Question(
                id = 9,
                label = "Quel désert est le plus grand du monde ?",
                correctId = 1,
                answers = listOf(
                    Answer(1, "Sahara"),
                    Answer(2, "Gobi"),
                    Answer(3, "Atacama"),
                    Answer(4, "Kalahari")
                )
            ),
            Question(
                id = 10,
                label = "Combien y a-t-il de continents sur Terre (selon la convention la plus utilisée) ?",
                correctId = 4,
                answers = listOf(
                    Answer(1, "5"),
                    Answer(2, "8"),
                    Answer(3, "4"),
                    Answer(4, "7")
                )
            )
        )
    )
)
