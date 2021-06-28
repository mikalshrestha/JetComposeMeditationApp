package com.mikal.meditationapp.models

import androidx.compose.runtime.Immutable

@Immutable
data class ScheduleCollection(
    val id: Long,
    val name: String,
    val schedule: List<Schedule>,
    val type: CollectionType = CollectionType.Normal
)

enum class CollectionType { Normal, Highlight }


/**
 * Static data
 */

private val popular = ScheduleCollection(
    id = 1L,
    name = "Popular",
    schedule = schedules.subList(0, 9)
)

val scheduleCollection = listOf(
    popular
)