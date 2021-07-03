package com.mikal.meditationapp.ui.home

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import com.mikal.meditationapp.models.Trending
import com.mikal.meditationapp.repository.TrendingRepo
import com.mikal.meditationapp.ui.components.MeditationSurface
import com.mikal.meditationapp.ui.components.Trendings

@Composable
fun Trending(
    modifier: Modifier = Modifier
) {
    val trendingData = remember { TrendingRepo.getTrending() }
    Trending(
        trendingData,
        modifier
    )
}

@Composable
private fun Trending(
    trendingData: List<Trending>,
    modifier: Modifier = Modifier
) {
    MeditationSurface(modifier = modifier.fillMaxSize()) {
        Box {
            Column() {
                TrendingView(trendingData)
            }
        }
    }
}

@Composable
private fun TrendingView(
    trendingData: List<Trending>
) {
    Trendings(trending = trendingData)

}


