package com.mikal.meditationapp.models

import androidx.compose.runtime.Immutable


@Immutable
data class Trending(
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

val trending = listOf(
    Trending(
        id = 1L,
        title = "Yoga Basic Pack",
        imageUrl = "https://source.unsplash.com/F2qh3yjz6Jk",
        author = "By Sh Shakil",
        totalPeriod = "3 Weeks",
        type = "Body Weight",
        level = "PRO",
        totalDays = "5 day",
        totalTimes = "8h 50m",
        totalCalories = "25 Kcal"
    ),
    Trending(
        id = 2L,
        title = "Yoga Basic Pack",
        imageUrl = "https://source.unsplash.com/F2qh3yjz6Jk",
        author = "By Sh Shakil",
        totalPeriod = "3 Weeks",
        type = "Body Weight",
        level = "PRO",
        totalDays = "5 day",
        totalTimes = "8h 50m",
        totalCalories = "25 Kcal"
    ),
    Trending(
        id = 3L,
        title = "Yoga Basic Pack",
        imageUrl = "https://source.unsplash.com/F2qh3yjz6Jk",
        author = "By Sh Shakil",
        totalPeriod = "3 Weeks",
        type = "Body Weight",
        level = "PRO",
        totalDays = "5 day",
        totalTimes = "8h 50m",
        totalCalories = "25 Kcal"
    ),
    Trending(
        id = 4L,
        title = "Yoga Basic Pack",
        imageUrl = "https://source.unsplash.com/F2qh3yjz6Jk",
        author = "By Sh Shakil",
        totalPeriod = "3 Weeks",
        type = "Body Weight",
        level = "PRO",
        totalDays = "5 day",
        totalTimes = "8h 50m",
        totalCalories = "25 Kcal"
    ),
    Trending(
        id = 5L,
        title = "Yoga Basic Pack",
        imageUrl = "https://source.unsplash.com/F2qh3yjz6Jk",
        author = "By Sh Shakil",
        totalPeriod = "3 Weeks",
        type = "Body Weight",
        level = "PRO",
        totalDays = "5 day",
        totalTimes = "8h 50m",
        totalCalories = "25 Kcal"
    ),
    Trending(
        id = 6L,
        title = "Yoga Basic Pack",
        imageUrl = "https://source.unsplash.com/F2qh3yjz6Jk",
        author = "By Sh Shakil",
        totalPeriod = "3 Weeks",
        type = "Body Weight",
        level = "PRO",
        totalDays = "5 day",
        totalTimes = "8h 50m",
        totalCalories = "25 Kcal"
    ),
    Trending(
        id = 7L,
        title = "Yoga Basic Pack",
        imageUrl = "https://source.unsplash.com/F2qh3yjz6Jk",
        author = "By Sh Shakil",
        totalPeriod = "3 Weeks",
        type = "Body Weight",
        level = "PRO",
        totalDays = "5 day",
        totalTimes = "8h 50m",
        totalCalories = "25 Kcal"
    )


)