package com.mikal.meditationapp.ui.home

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import com.mikal.meditationapp.models.Schedule
import com.mikal.meditationapp.models.ScheduleTutorial
import com.mikal.meditationapp.repository.ScheduleRepo
import com.mikal.meditationapp.ui.components.MeditationSurface
import com.mikal.meditationapp.ui.components.Schedules
import com.mikal.meditationapp.ui.components.ShowScheduleTutorial

//
@Composable
fun Feed(
    onSnackClick: (Long) -> Unit,
    modifier: Modifier = Modifier
) {
    val scheduleCollection = remember { ScheduleRepo.getSchedules() }
    val scheduleTutorial = remember {ScheduleRepo.getScheduleTutorial()}
    Feed(
        scheduleCollection,
        scheduleTutorial,
        onSnackClick,
        modifier
    )
}

@Composable
private fun Feed(
    scheduleCollection: List<Schedule>,
    scheduleTutorial: ScheduleTutorial,
    onSnackClick: (Long) -> Unit,
    modifier: Modifier = Modifier
) {
    MeditationSurface(modifier = modifier.fillMaxSize()) {
        Box {
            Column() {
                ShowScheduleTutorialView(scheduleTutorial)
                ScheduleCollectionList(scheduleCollection, onSnackClick)
                //DestinationBar()
            }

        }
    }
}


@Composable
private fun ScheduleCollectionList(
    scheduleCollection: List<Schedule>,
    onSnackClick: (Long) -> Unit
) {
    Schedules(
        schedules = scheduleCollection,
        onSnackClick = onSnackClick
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
