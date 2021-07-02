package com.mikal.meditationapp.repository

import com.mikal.meditationapp.models.BeginnerStepGuide
import com.mikal.meditationapp.models.MostPopular
import com.mikal.meditationapp.models.beginnerStepGuide
import com.mikal.meditationapp.models.mostPopular

object BeginnerGuidePlayRepo {
    fun getBeginnerGuides(): List<BeginnerStepGuide> = beginnerStepGuide
    fun getMostPopular(): MostPopular = mostPopular
}