package com.mikal.meditationapp.models

import androidx.compose.runtime.Immutable

@Immutable
data class BeginnerStepGuide(
    val id: Long,
    val title: String,
    val imageUrl: String,
    val period: String
)

/**
 * Static data
 */


val beginnerStepGuide = listOf(
    BeginnerStepGuide(
        id = 1L,
        title = "Completed",
        imageUrl = "https://source.unsplash.com/F2qh3yjz6Jk",
        period = "2 Week"
    ),
    BeginnerStepGuide(
        id = 2L,
        title = "Body Weight",
        imageUrl = "https://source.unsplash.com/p-v1DBkTrgo",
        period = "3 Week"
    ),
    BeginnerStepGuide(
        id = 3L,
        title = "Completed",
        imageUrl = "https://source.unsplash.com/F2qh3yjz6Jk",
        period = "1 Week"
    ),
    BeginnerStepGuide(
        id = 4L,
        title = "Body Weight",
        imageUrl = "https://source.unsplash.com/NTyBbu66_SI",
        period = "1 Week"
    ),
    BeginnerStepGuide(
        id = 5L,
        title = "Body Weight",
        imageUrl = "https://source.unsplash.com/tyCVZ1Aaqxo",
        period = "1 Week"
    ),
    BeginnerStepGuide(
        id = 6L,
        title = "Body Weight",
        imageUrl = "https://source.unsplash.com/F2qh3yjz6Jk",
        period = "1 Week"
    ),
    BeginnerStepGuide(
        id = 7L,
        title = "Body Weight",
        imageUrl = "https://source.unsplash.com/F2qh3yjz6Jk",
        period = "1 Week"
    )
)