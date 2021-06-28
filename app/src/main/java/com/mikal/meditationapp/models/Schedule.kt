package com.mikal.meditationapp.models

import androidx.compose.runtime.Immutable

@Immutable
data class Schedule(
    val id: Long,
    val title: String,
    val imageUrl: String,
    val days: String,
    val period: String
)

/**
 * Static data
 */


val schedules = listOf(
    Schedule(
        id = 1L,
        title = "Breathing Practices and Introduction",
        imageUrl = "https://source.unsplash.com/pGM4sjt_BdQ",
        days = "Day1",
        period = "30 min"
    ),
    Schedule(
        id = 2L,
        title = "Breathing Practices and Introduction",
        imageUrl = "https://source.unsplash.com/pGM4sjt_BdQ",
        days = "Day2",
        period = "30 min"
    ),
    Schedule(
        id = 3L,
        title = "Breathing Practices and Introduction",
        imageUrl = "https://source.unsplash.com/pGM4sjt_BdQ",
        days = "Day3",
        period = "30 min"
    ),
    Schedule(
        id = 4L,
        title = "Breathing Practices and Introduction",
        imageUrl = "https://source.unsplash.com/pGM4sjt_BdQ",
        days = "Day4",
        period = "30 min"
    ),
    Schedule(
        id = 5L,
        title = "Breathing Practices and Introduction",
        imageUrl = "https://source.unsplash.com/pGM4sjt_BdQ",
        days = "Day5",
        period = "30 min"
    ),
    Schedule(
        id = 6L,
        title = "Breathing Practices and Introduction",
        imageUrl = "https://source.unsplash.com/pGM4sjt_BdQ",
        days = "Day6",
        period = "30 min"
    ),
    Schedule(
        id = 7L,
        title = "Breathing Practices and Introduction",
        imageUrl = "https://source.unsplash.com/pGM4sjt_BdQ",
        days = "Day7",
        period = "30 min"
    ),
    Schedule(
        id = 8L,
        title = "Breathing Practices and Introduction",
        imageUrl = "https://source.unsplash.com/pGM4sjt_BdQ",
        days = "Day1",
        period = "30 min"
    ),
    Schedule(
        id = 9L,
        title = "Breathing Practices and Introduction",
        imageUrl = "https://source.unsplash.com/pGM4sjt_BdQ",
        days = "Day1",
        period = "30 min"
    ),
    Schedule(
        id = 10L,
        title = "Breathing Practices and Introduction",
        imageUrl = "https://source.unsplash.com/pGM4sjt_BdQ",
        days = "Day1",
        period = "30 min"
    )
)