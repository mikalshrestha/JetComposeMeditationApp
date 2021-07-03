package com.mikal.meditationapp.repository

import com.mikal.meditationapp.models.Trending
import com.mikal.meditationapp.models.trending

object TrendingRepo {
    fun getTrending(): List<Trending> = trending
}