package com.mikal.meditationapp.models

import androidx.compose.runtime.Immutable

@Immutable
data class Schedule(
    val id: Long,
    val title: String,
    val imageUrl: String,
    val days: String,
    val period: String,
    val description: String
)

/**
 * Static data
 */


val schedules = listOf(
    Schedule(
        id = 1L,
        title = "Breathing Practices and Introduction",
        imageUrl = "https://source.unsplash.com/p-v1DBkTrgo",
        days = "Day1",
        period = "30 min",
        description = "Yoga’s deep breathing and meditation practices help foster an inner shift from to-do lists, kids and spouse’s needs, financial concerns, and relationship struggles to something a little bit bigger than the issues you face.Meditation is often defined as thinking continuously about one object of thought. We often get stuck on this definition, however, and lose the real purpose of meditation. Meditation must reveal the true nature of that object upon which we are meditating. Such revelation comes not as a thought, but as a feeling. Therefore, meditation is a process in which we shift from thinking to feeling. It is a journey from the complexity of mind to the simplicity of heart. It is for this reason that most methods of meditation involve the heart."
    ),
    Schedule(
        id = 2L,
        title = "Spiritual Practices and Introduction",
        imageUrl = "https://source.unsplash.com/tyCVZ1Aaqxo",
        days = "Day2",
        period = "35 min",
        description = "Meditation is often defined as thinking continuously about one object of thought. We often get stuck on this definition, however, and lose the real purpose of meditation. Meditation must reveal the true nature of that object upon which we are meditating. Such revelation comes not as a thought, but as a feeling. Therefore, meditation is a process in which we shift from thinking to feeling. It is a journey from the complexity of mind to the simplicity of heart. It is for this reason that most methods of meditation involve the heart."
    ),
    Schedule(
        id = 3L,
        title = "Progressive Relaxation Meditation",
        imageUrl = "https://source.unsplash.com/NTyBbu66_SI",
        days = "Day3",
        period = "20 min",
        description = "Yoga’s deep breathing and meditation practices help foster an inner shift from to-do lists, kids and spouse’s needs, financial concerns, and relationship struggles to something a little bit bigger than the issues you face."
    ),
    Schedule(
        id = 4L,
        title = "Breathing Practices and Introduction",
        imageUrl = "https://source.unsplash.com/NTyBbu66_SI",
        days = "Day4",
        period = "30 min",
        description = "Yoga’s deep breathing and meditation practices help foster an inner shift from to-do lists, kids and spouse’s needs, financial concerns, and relationship struggles to something a little bit bigger than the issues you face."
    ),
    Schedule(
        id = 5L,
        title = "Breathing Practices and Introduction",
        imageUrl = "https://source.unsplash.com/NTyBbu66_SI",
        days = "Day5",
        period = "30 min",
        description = "Yoga’s deep breathing and meditation practices help foster an inner shift from to-do lists, kids and spouse’s needs, financial concerns, and relationship struggles to something a little bit bigger than the issues you face."
    ),
    Schedule(
        id = 6L,
        title = "Breathing Practices and Introduction",
        imageUrl = "https://source.unsplash.com/NTyBbu66_SI",
        days = "Day6",
        period = "30 min",
        description = "Yoga’s deep breathing and meditation practices help foster an inner shift from to-do lists, kids and spouse’s needs, financial concerns, and relationship struggles to something a little bit bigger than the issues you face."
    ),
    Schedule(
        id = 7L,
        title = "Breathing Practices and Introduction",
        imageUrl = "https://source.unsplash.com/NTyBbu66_SI",
        days = "Day7",
        period = "30 min",
        description = "Yoga’s deep breathing and meditation practices help foster an inner shift from to-do lists, kids and spouse’s needs, financial concerns, and relationship struggles to something a little bit bigger than the issues you face."
    ),
    Schedule(
        id = 8L,
        title = "Breathing Practices and Introduction",
        imageUrl = "https://source.unsplash.com/NTyBbu66_SI",
        days = "Day8",
        period = "30 min",
        description = "Yoga’s deep breathing and meditation practices help foster an inner shift from to-do lists, kids and spouse’s needs, financial concerns, and relationship struggles to something a little bit bigger than the issues you face."
    ),
    Schedule(
        id = 9L,
        title = "Breathing Practices and Introduction",
        imageUrl = "https://source.unsplash.com/NTyBbu66_SI",
        days = "Day9",
        period = "30 min",
        description = "Yoga’s deep breathing and meditation practices help foster an inner shift from to-do lists, kids and spouse’s needs, financial concerns, and relationship struggles to something a little bit bigger than the issues you face."
    ),
    Schedule(
        id = 10L,
        title = "Movement Meditation Practices",
        imageUrl = "https://source.unsplash.com/F2qh3yjz6Jk",
        days = "Day10",
        period = "40 min",
        description = "Yoga’s deep breathing and meditation practices help foster an inner shift from to-do lists, kids and spouse’s needs, financial concerns, and relationship struggles to something a little bit bigger than the issues you face."
    )
)