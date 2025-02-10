package com.wordline.quiz.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
@Preview
fun CVScreen() {
    MaterialTheme {
        Column(
            Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            ProfileSection(
                name = "Quentin MOSKWA",
                title = "Expert Solution et Support",
                contactInfo = """
                    Adresse: 63 rue Henri Kolb, Lille 59000
                    Email: moskwaquentin@gmail.com
                    Téléphone: +33 6 40 36 06 86
                """.trimIndent()
            )
            Spacer(Modifier.height(16.dp))
            EducationSection(
                education = listOf(
                    "EFFICOM Lille - Bachelor Informatique (2021 - 2024)",
                    "Faculté des Humanités Lille - Musique et Musicologie (2020 - 2021)",
                    "ISTV Mont Houy Valenciennes - Licence Génie Électronique et Informatique (2018 - 2020)",
                    "Lycée Paul Duez Cambrai - Baccalauréat S Spécialisation Physique-Chimie (2018)"
                )
            )
            Spacer(Modifier.height(16.dp))
            ExperienceSection(
                experiences = listOf(
                    "Apprenti Chef de Projet Logiciel et Réseau chez White Rabbit Pictures (2022 - Présent): Élaboration de pipelines, développement d'applications, troubleshooting.",
                    "Vendeur Polyvalent chez Accromusic (2018 - 2018): Entretien des instruments, mise en rayon, conseil client."
                )
            )
            Spacer(Modifier.height(16.dp))
            ProjectSection(
                bigTitle = "Composition de Bandes Originales / Sound Design",
                projects = listOf(
                    "Alone - Court-Métrage Bachelor 3 Animation 3D RUBIKA" to "https://www.youtube.com/watch?v=TY1foSN3zqY",
                    "Mobius - Court-Métrage réalisé pour le cours de montage de l'UQAT" to "https://www.youtube.com/watch?v=C2Jh2lykqMY",
                    "Intersection - Jeux vidéo de Thomas CSIGAI" to "https://thomas-csigai.itch.io/intersection"
                )
            )
            Spacer(Modifier.height(16.dp))
            SkillsSection(
                skills = listOf(
                    "HTML/CSS/JS", "PHP", "C#/C++", "MySQL", "Python", "Unity"
                )
            )
            Spacer(Modifier.height(16.dp))
            InterestsSection(
                interests = listOf(
                    "Musique", "Lecture", "Jeux Vidéos", "Photo", "Peinture", "Philosophie", "Cuisine"
                )
            )
        }
    }
}

@Composable
fun ProfileSection(name: String, title: String, contactInfo: String) {
    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = name, fontSize = 24.sp, fontWeight = FontWeight.Bold)
        Text(text = title, fontSize = 20.sp)
        Text(text = contactInfo, fontSize = 14.sp, color = Color.Gray)
    }
}

@Composable
fun EducationSection(education: List<String>) {
    SectionHeader("Formation")
    Column(verticalArrangement = Arrangement.spacedBy(4.dp)) {
        education.forEach { edu ->
            Text(text = "• $edu", fontSize = 14.sp)
        }
    }
}

@Composable
fun ExperienceSection(experiences: List<String>) {
    SectionHeader("Expériences")
    Column(verticalArrangement = Arrangement.spacedBy(4.dp)) {
        experiences.forEach { experience ->
            Text(text = "• $experience", fontSize = 14.sp)
        }
    }
}

@Composable
fun ProjectSection(bigTitle: String, projects: List<Pair<String, String>>) {
    SectionHeader(bigTitle)
    Column(verticalArrangement = Arrangement.spacedBy(4.dp)) {
        projects.forEach { (title, link) ->
            Column {
                Text(text = title, fontSize = 16.sp, fontWeight = FontWeight.SemiBold)
                Text(text = link, fontSize = 14.sp, color = Color.Blue)
            }
        }
    }
}

@Composable
fun SkillsSection(skills: List<String>) {
    SectionHeader("Compétences")
    Column(verticalArrangement = Arrangement.spacedBy(4.dp)) {
        skills.forEach { skill ->
            Text(text = "• $skill", fontSize = 14.sp)
        }
    }
}

@Composable
fun InterestsSection(interests: List<String>) {
    SectionHeader("Centres d'intérêt")
    Column(verticalArrangement = Arrangement.spacedBy(4.dp)) {
        interests.forEach { interest ->
            Text(text = "• $interest", fontSize = 14.sp)
        }
    }
}

@Composable
fun SectionHeader(title: String) {
    Text(
        text = title,
        fontSize = 20.sp,
        fontWeight = FontWeight.Bold,
        modifier = Modifier.padding(vertical = 8.dp)
    )
}