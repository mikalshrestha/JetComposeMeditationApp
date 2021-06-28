package com.mikal.meditationapp.repository

import com.mikal.meditationapp.models.ScheduleCollection
import com.mikal.meditationapp.models.scheduleCollection
import com.mikal.meditationapp.models.schedules

object ScheduleRepo {
    fun getSchedules(): List<ScheduleCollection> = scheduleCollection
    fun getSchedule(id: Long) = schedules.find { it.id == id }!!
}