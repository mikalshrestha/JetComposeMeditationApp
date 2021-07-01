package com.mikal.meditationapp.repository

import com.mikal.meditationapp.models.BeginnerStepGuide
import com.mikal.meditationapp.models.beginnerStepGuide

object BeginnerGuidePlayRepo {
    fun getBeginnerGuides(): List<BeginnerStepGuide> = beginnerStepGuide
}