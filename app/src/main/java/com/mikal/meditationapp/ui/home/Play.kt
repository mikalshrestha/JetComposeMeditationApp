package com.mikal.meditationapp.ui.home

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import com.mikal.meditationapp.models.BeginnerStepGuide
import com.mikal.meditationapp.repository.BeginnerGuidePlayRepo

@Composable
fun Play(
    onClick: (Long) -> Unit,
    modifier: Modifier = Modifier
) {
    val beginnerStepGuideData = remember { BeginnerGuidePlayRepo.getBeginnerGuides() }
    Play(
        beginnerStepGuideData,
        onClick,
        modifier
    )

}

@Composable
private fun Play(
    beginnerStepGuideData: List<BeginnerStepGuide>,
    onClick: (Long) -> Unit,
    modifier: Modifier = Modifier
) {

}