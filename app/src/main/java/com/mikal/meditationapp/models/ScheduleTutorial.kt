package com.mikal.meditationapp.models

import androidx.compose.runtime.Immutable

@Immutable
data class ScheduleTutorial(
    val id: Long,
    val title: String,
    val imageUrl: String,
    val description: String,
    val rating: String,
    val totalPeriod: String,
    val level: String,
    val tutorialDuration: String,

    )

/**
 * Static data
 */

val scheduleTutorial = ScheduleTutorial(
    id = 1L,
    title = "Follow Yoga",
    imageUrl = "https://source.unsplash.com/F2qh3yjz6Jk",
    description = "Yoga’s deep breathing and meditation practices help foster an inner shift from to-do lists, kids and spouse’s needs, financial concerns, and relationship struggles to something a little bit bigger than the issues you face.",
    rating = "****(200)",
    totalPeriod = "2 Weeks",
    level = "Level 1",
    tutorialDuration = "29 min"
)
