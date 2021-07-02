package com.mikal.meditationapp.repository

import com.mikal.meditationapp.models.Profile
import com.mikal.meditationapp.models.profile


object ProfileRepo {
    fun getProfileDetail(): Profile = profile
}