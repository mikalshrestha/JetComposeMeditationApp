package com.mikal.meditationapp.models

import androidx.compose.runtime.Immutable


@Immutable
data class MostPopular(
    val id: Long,
    val title: String,
    val imageUrl: String,
    val author: String,
    val totalPeriod: String,
    val type: String,
    val level: String,
    val totalDays: String,
    val totalTimes: String,
    val totalCalories: String
    )

/**
 * Static data
 */

val mostPopular = MostPopular(
    id = 1L,
    title = "Yoga Basic Pack",
    imageUrl = "https://source.unsplash.com/GaprWyIw66o",
    author = "By Sh Shakil",
    totalPeriod = "3 Weeks",
    type = "Body Weight",
    level = "PRO",
    totalDays = "5 day",
    totalTimes = "8h 50m",
    totalCalories = "25 Kcal"
)