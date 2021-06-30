package com.mikal.meditationapp.ui.components

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ArrowBack
import androidx.compose.material.icons.outlined.ArrowForward
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.mikal.meditationapp.R
import com.google.accompanist.coil.rememberCoilPainter
import com.google.accompanist.insets.statusBarsHeight
import com.mikal.meditationapp.commons.mirroringIcon
import com.mikal.meditationapp.models.*
import com.mikal.meditationapp.ui.theme.MeditationTheme

private val HighlightCardWidth = 170.dp
private val HighlightCardPadding = 16.dp

// The Cards show a gradient which spans 3 cards and scrolls with parallax.
private val gradientWidth
    @Composable
    get() = with(LocalDensity.current) {
        (3 * (HighlightCardWidth + HighlightCardPadding).toPx())
    }

@Composable
fun ScheduleCollection(
    scheduleCollection: ScheduleCollection,
    onSnackClick: (Long) -> Unit,
    modifier: Modifier = Modifier,
    index: Int = 0,
    highlight: Boolean = true
) {
    Column(modifier = modifier) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .heightIn(min = 56.dp)
                .padding(start = 24.dp)
        ) {
            Text(
                text = scheduleCollection.name,
                style = MaterialTheme.typography.h6,
                color = MeditationTheme.colors.brand,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                modifier = Modifier
                    .weight(1f)
                    .wrapContentWidth(Alignment.Start)
            )
            IconButton(
                onClick = { /* todo */ },
                modifier = Modifier.align(Alignment.CenterVertically)
            ) {
                Icon(
                    imageVector = mirroringIcon(
                        ltrIcon = Icons.Outlined.ArrowForward,
                        rtlIcon = Icons.Outlined.ArrowBack
                    ),
                    tint = MeditationTheme.colors.brand,
                    contentDescription = null
                )
            }
        }
        if (highlight && scheduleCollection.type == CollectionType.Highlight) {
            HighlightedSchedules(index, scheduleCollection.schedule, onSnackClick)
        } else {
            Schedules(scheduleCollection.schedule, onSnackClick)
        }
    }
}

@Composable
private fun HighlightedSchedules(
    index: Int,
    snacks: List<Schedule>,
    onSnackClick: (Long) -> Unit,
    modifier: Modifier = Modifier
) {
    val scroll = rememberScrollState(0)
    val gradient = when ((index / 2) % 2) {
        0 -> MeditationTheme.colors.gradient6_1
        else -> MeditationTheme.colors.gradient6_2
    }
    // The Cards show a gradient which spans 3 cards and scrolls with parallax.
    val gradientWidth = with(LocalDensity.current) {
        (6 * (HighlightCardWidth + HighlightCardPadding).toPx())
    }
    LazyRow(
        modifier = modifier,
        horizontalArrangement = Arrangement.spacedBy(16.dp),
        contentPadding = PaddingValues(start = 24.dp, end = 24.dp)
    ) {
        itemsIndexed(snacks) { index, snack ->
            HighlightScheduleItem(
                snack,
                onSnackClick,
                index,
                gradient,
                gradientWidth,
                scroll.value
            )
        }
    }
}

@Composable
fun Schedules(
    schedules: List<Schedule>,
    onSnackClick: (Long) -> Unit,
    modifier: Modifier = Modifier
) {
    Text(
        text = "Schedule",
        style = MaterialTheme.typography.h6,
        color = MeditationTheme.colors.textSecondary,
        textAlign = TextAlign.Center,
        maxLines = 1,
        overflow = TextOverflow.Ellipsis,
        modifier = Modifier.padding(start = 16.dp, top = 16.dp)
    )
    LazyColumn(
        modifier
            .fillMaxSize()
            .padding(10.dp)
    ) {
        item {
            Spacer(Modifier.statusBarsHeight(additional = 0.dp))
        }
        itemsIndexed(schedules) { index, schedules ->
            if (index > 0) {
                meditationDivider(thickness = 2.dp)
            }
            SchedulesItem(schedules, onSnackClick)
        }
    }
}

@Composable
fun ScheduleItem(
    schedule: Schedule,
    onSnackClick: (Long) -> Unit,
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .heightIn(min = 56.dp)
                .clickable(onClick = { onSnackClick(schedule.id) })
                .padding(start = 24.dp)
        ) {
            ScheduleImage(
                imageUrl = schedule.imageUrl,
                contentDescription = null
            )
        }
    }
}

@Composable
fun SchedulesItem(
    schedule: Schedule,
    onSnackClick: (Long) -> Unit,
    modifier: Modifier = Modifier
) {
    Row() {

        meditationCard(
            modifier = modifier
                .size(
                    width = 170.dp,
                    height = 250.dp
                )
                .padding(start = 8.dp, top = 16.dp, bottom = 16.dp)
        ) {
            Column(modifier = modifier) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .heightIn(min = 56.dp)
                        .clickable(onClick = { onSnackClick(schedule.id) })
                ) {
                    ScheduleImage(
                        imageUrl = schedule.imageUrl,
                        contentDescription = null
                    )
                }
            }
        }
        Column(
            modifier
                .padding(
                    start = 8.dp,
                    top = 30.dp,
                    bottom = 16.dp
                )
        ) {
            Row() {
                Text(
                    text = schedule.days,
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis,
                    style = MaterialTheme.typography.body1,
                    color = MeditationTheme.colors.textSecondary,
                    modifier = Modifier.padding(horizontal = 16.dp)
                )
                Text(
                    text = schedule.period,
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis,
                    style = MaterialTheme.typography.body1,
                    color = MeditationTheme.colors.textSecondary,
                    modifier = Modifier
                        .padding(horizontal = 0.dp)
                        .then(modifier.padding(start = 30.dp))
                )
            }
            Spacer(modifier = Modifier.height(40.dp))
            Text(
                text = schedule.title,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis,
                style = MaterialTheme.typography.body1,
                color = MeditationTheme.colors.textSecondary,
                modifier = Modifier.padding(horizontal = 16.dp)
            )
            Spacer(modifier = Modifier.height(40.dp))
            Row(
                modifier.padding(
                    start = 8.dp,
                    end = 60.dp
                )
            ) {
                MeditationButton(
                    onClick = { /* todo */ },
                    modifier = Modifier.weight(1f)
                ) {
                    Text(
                        text = stringResource(R.string.view_all),
                        style = MaterialTheme.typography.body1,
                        modifier = Modifier.fillMaxWidth(),
                        textAlign = TextAlign.Center,
                        maxLines = 1
                    )
                }
            }

        }

    }
}

@Composable
private fun HighlightScheduleItem(
    schedule: Schedule,
    onSnackClick: (Long) -> Unit,
    index: Int,
    gradient: List<Color>,
    gradientWidth: Float,
    scroll: Int,
    modifier: Modifier = Modifier
) {
    val left = index * with(LocalDensity.current) {
        (HighlightCardWidth + HighlightCardPadding).toPx()
    }
    meditationCard(
        modifier = modifier
            .size(
                width = 170.dp,
                height = 250.dp
            )
            .padding(bottom = 16.dp)
    ) {
        Column(
            modifier = Modifier
                .clickable(onClick = { onSnackClick(schedule.id) })
                .fillMaxSize()
        ) {
            Box(
                modifier = Modifier
                    .height(160.dp)
                    .fillMaxWidth()
            ) {
                val gradientOffset = left - (scroll / 3f)
                Box(
                    modifier = Modifier
                        .height(100.dp)
                        .fillMaxWidth()
                        .offsetGradientBackground(gradient, gradientWidth, gradientOffset)
                )
                ScheduleImage(
                    imageUrl = schedule.imageUrl,
                    contentDescription = null
                )
            }
        }
    }
}

@Composable
fun ScheduleImage(
    imageUrl: String,
    contentDescription: String?,
) {
    Image(
        painter = rememberCoilPainter(
            request = imageUrl,
            previewPlaceholder = R.drawable.placeholder,
        ),
        contentDescription = contentDescription,
        modifier = Modifier.fillMaxSize(),
        contentScale = ContentScale.FillBounds
    )
}

@Composable
fun ShowScheduleTutorial(
    scheduleTutorial: ScheduleTutorial,
    modifier: Modifier = Modifier
) {
    meditationCard(
        modifier = modifier
            .size(
                width = 350.dp,
                height = 350.dp
            )
            .padding(bottom = 4.dp)
    ) {
        Column(modifier.padding(bottom = 8.dp)) {

            Image(
                painter = rememberCoilPainter(
                    request = scheduleTutorial.imageUrl,
                    previewPlaceholder = R.drawable.placeholder,
                ),
                contentDescription = null,
                modifier = Modifier.size(
                    width = 350.dp,
                    height = 175.dp
                ),
                contentScale = ContentScale.FillBounds
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = scheduleTutorial.title,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                style = MaterialTheme.typography.h6,
                color = MeditationTheme.colors.textSecondary,
                modifier = Modifier.padding(horizontal = 16.dp)
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = scheduleTutorial.rating,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                style = MaterialTheme.typography.body1,
                color = MeditationTheme.colors.textSecondary,
                modifier = Modifier.padding(horizontal = 16.dp)
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = scheduleTutorial.description,
                maxLines = 3,
                overflow = TextOverflow.Ellipsis,
                style = MaterialTheme.typography.body1,
                color = MeditationTheme.colors.textSecondary,
                modifier = Modifier.padding(horizontal = 16.dp)
            )
            Spacer(modifier = Modifier.height(8.dp))
            Row() {
                Text(
                    text = scheduleTutorial.totalPeriod,
                    maxLines = 3,
                    overflow = TextOverflow.Ellipsis,
                    style = MaterialTheme.typography.body2,
                    color = MeditationTheme.colors.textSecondary,
                    modifier = Modifier.padding(horizontal = 16.dp)
                )
                Text(
                    text = scheduleTutorial.level,
                    maxLines = 3,
                    overflow = TextOverflow.Ellipsis,
                    style = MaterialTheme.typography.body1,
                    color = MeditationTheme.colors.textSecondary,
                    modifier = Modifier.padding(horizontal = 16.dp)
                )
                Text(
                    text = scheduleTutorial.tutorialDuration,
                    maxLines = 3,
                    overflow = TextOverflow.Ellipsis,
                    style = MaterialTheme.typography.body1,
                    color = MeditationTheme.colors.textSecondary,
                    modifier = Modifier.padding(horizontal = 16.dp)
                )
            }
        }

    }

}

@Preview("default")
@Preview("dark theme", uiMode = UI_MODE_NIGHT_YES)
@Preview("large font", fontScale = 2f)
@Composable
fun ScheduleCardPreview() {
    MeditationTheme {
        val schedule = schedules.first()
        HighlightScheduleItem(
            schedule = schedule,
            onSnackClick = { },
            index = 0,
            gradient = MeditationTheme.colors.gradient6_1,
            gradientWidth = gradientWidth,
            scroll = 0
        )
    }
}
