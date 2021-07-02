package com.mikal.meditationapp.ui.home

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.mikal.meditationapp.models.Schedule
import com.mikal.meditationapp.models.ScheduleTutorial
import com.mikal.meditationapp.repository.ScheduleRepo
import com.mikal.meditationapp.ui.components.MeditationSurface
import com.mikal.meditationapp.ui.components.Schedules
import com.mikal.meditationapp.ui.components.ShowScheduleTutorial
import com.mikal.meditationapp.ui.theme.MeditationTheme

//
@Composable
fun Feed(
    onClick: (Long) -> Unit,
    modifier: Modifier = Modifier
) {
    val scheduleCollection = remember { ScheduleRepo.getSchedules() }
    val scheduleTutorial = remember {ScheduleRepo.getScheduleTutorial()}
    Feed(
        scheduleCollection,
        scheduleTutorial,
        onClick,
        modifier
    )
}

@Composable
private fun Feed(
    scheduleCollection: List<Schedule>,
    scheduleTutorial: ScheduleTutorial,
    onClick: (Long) -> Unit,
    modifier: Modifier = Modifier
) {
    MeditationSurface(modifier = modifier.fillMaxSize()) {
        Box {
            Column() {
                ShowScheduleTutorialView(scheduleTutorial)
                Column() {
                    Text(
                        text = "Schedule",
                        style = MaterialTheme.typography.h6,
                        color = MeditationTheme.colors.textSecondary,
                        textAlign = TextAlign.Center,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis,
                        modifier = Modifier.padding(start = 20.dp, top = 16.dp)
                    )
                    ScheduleCollectionList(scheduleCollection, onClick)
                }
            }

        }
    }
}


@Composable
private fun ScheduleCollectionList(
    scheduleCollection: List<Schedule>,
    onClick: (Long) -> Unit
) {
    Schedules(
        schedules = scheduleCollection,
        onClick = onClick
    )

}

@Composable
private fun ShowScheduleTutorialView(
    scheduleTutorial: ScheduleTutorial
) {

    ShowScheduleTutorial(
        scheduleTutorial = scheduleTutorial
    )

}
