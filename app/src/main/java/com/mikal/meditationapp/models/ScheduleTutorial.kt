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
    title = "Breathing Practices and Introduction",
    imageUrl = "https://source.unsplash.com/F2qh3yjz6Jk",
    description = "Therefore, yoga is an extraordinary spiritual science of self-development and self-realization that shows us how to develop our full potential in our many-sided lives.",
    rating = "****(200)",
    totalPeriod = "2 Weeks",
    level = "Level 1",
    tutorialDuration = "29 min"
)
