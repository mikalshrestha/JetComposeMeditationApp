package com.mikal.meditationapp.repository

import com.mikal.meditationapp.models.*

object ScheduleRepo {
    fun getSchedules(): List<Schedule> = schedules
    fun getScheduleTutorial(): ScheduleTutorial = scheduleTutorial
    fun getScheduleById(id: Long) = schedules.find { it.id == id }!!
}