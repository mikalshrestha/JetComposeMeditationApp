package com.mikal.meditationapp.ui.home

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.google.accompanist.insets.statusBarsHeight
import com.mikal.meditationapp.models.ScheduleCollection
import com.mikal.meditationapp.repository.ScheduleRepo
import com.mikal.meditationapp.ui.components.MeditationSurface
import com.mikal.meditationapp.ui.components.ScheduleCollection
import com.mikal.meditationapp.ui.components.meditationDivider

//
@Composable
fun Feed(
    onSnackClick: (Long) -> Unit,
    modifier: Modifier = Modifier
) {
    val scheduleCollection = remember { ScheduleRepo.getSchedules() }
    Feed(
        scheduleCollection,
        onSnackClick,
        modifier
    )
}

@Composable
private fun Feed(
    scheduleCollection: List<ScheduleCollection>,
    onSnackClick: (Long) -> Unit,
    modifier: Modifier = Modifier
) {
    MeditationSurface(modifier = modifier.fillMaxSize()) {
        Box {
            ScheduleCollectionList(scheduleCollection, onSnackClick)
            DestinationBar()
        }
    }
}


@Composable
private fun ScheduleCollectionList(
    scheduleCollection: List<ScheduleCollection>,
    onSnackClick: (Long) -> Unit,
    modifier: Modifier = Modifier
) {
    LazyColumn(modifier) {
        item {
            Spacer(Modifier.statusBarsHeight(additional = 56.dp))
        }
        itemsIndexed(scheduleCollection) { index, scheduleCollection ->
            if (index > 0) {
                meditationDivider(thickness = 2.dp)
            }
            ScheduleCollection(
                scheduleCollection = scheduleCollection,
                onSnackClick = onSnackClick,
                index = index
            )
        }
    }
}
