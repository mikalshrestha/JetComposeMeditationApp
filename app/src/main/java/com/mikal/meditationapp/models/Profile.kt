package com.mikal.meditationapp.models

import androidx.compose.runtime.Immutable


@Immutable
data class Profile(
    val id: Long,
    val name: String,
    val imageUrl: String,
    val location: String,
    val role: String,
    val aboutDescription: String,
    val totalTrainees: String,
    val followers: String,
    val following: String,
    )

/**
 * Static data
 */

val profile = Profile(
    id = 1L,
    name = "Jonathan Patricson",
    imageUrl = "https://source.unsplash.com/F2qh3yjz6Jk",
    location = "Kathmandu, Nepal",
    role = "Meditator || Meditation Expert",
    aboutDescription = "Dynamic Yoga instructor commited to bringing an awareness of holistic mind and body through all form of healing and teaching modality to assist.",
    totalTrainees = "150",
    followers = "5000",
    following = "50"
)