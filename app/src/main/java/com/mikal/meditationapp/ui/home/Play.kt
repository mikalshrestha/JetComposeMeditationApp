package com.mikal.meditationapp.ui.home

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.mikal.meditationapp.models.BeginnerStepGuide
import com.mikal.meditationapp.models.MostPopular
import com.mikal.meditationapp.repository.BeginnerGuidePlayRepo
import com.mikal.meditationapp.ui.components.*

@Composable
fun Play(
    modifier: Modifier = Modifier
) {
    val beginnerStepGuideData = remember { BeginnerGuidePlayRepo.getBeginnerGuides() }
    val mostPopularData = remember {BeginnerGuidePlayRepo.getMostPopular()}
    Play(
        beginnerStepGuideData,
        mostPopularData,
        modifier
    )

}

@Composable
private fun Play(
    beginnerStepGuideData: List<BeginnerStepGuide>,
    mostPopular: MostPopular,
    modifier: Modifier = Modifier
) {
    MeditationSurface(modifier = modifier.fillMaxSize()) {
        Box {
            Column(modifier.padding(top = 16.dp)) {
                ShowCardView(mostPopular)
                Spacer(modifier = Modifier.height(4.dp))
                meditationDivider(thickness = 2.dp, modifier = Modifier.padding(start = 16.dp, top = 8.dp, bottom = 8.dp, end = 16.dp))
                ShowMostPopularView(mostPopular)
                Spacer(modifier = Modifier.height(4.dp))
                meditationDivider(thickness = 2.dp, modifier = Modifier.padding(start = 16.dp, top = 8.dp, bottom = 8.dp, end = 16.dp))
                BeginnersGuideLazyRowView(beginnerStepGuideData)
            }

        }
    }
}

@Composable
private fun BeginnersGuideLazyRowView(
    beginnerStepGuideData: List<BeginnerStepGuide>,
) {
    BeginnerGuides(
        beginnerStepGuideData = beginnerStepGuideData
    )
}

@Composable
private fun ShowMostPopularView(
    mostPopular: MostPopular
) {

    ShowMostPopular(
        mostPopular = mostPopular
    )

}

@Composable
private fun ShowCardView(
    mostPopular: MostPopular
) {

    ShowFirstCardView(
        mostPopular = mostPopular
    )

}