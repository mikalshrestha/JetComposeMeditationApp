package com.mikal.meditationapp.ui.components

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import androidx.compose.ui.unit.sp
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
fun Schedules(
    schedules: List<Schedule>,
    onClick: (Long) -> Unit,
    modifier: Modifier = Modifier
) {
    LazyColumn(
        modifier
            .fillMaxSize()
            .padding(start = 16.dp, top = 8.dp, bottom = 8.dp, end = 16.dp)
    ) {
        item {
            Spacer(Modifier.statusBarsHeight(additional = 0.dp))
        }
        itemsIndexed(schedules) { index, schedules ->
            if (index > 0) {
                meditationDivider(thickness = 2.dp)
            }
            SchedulesItem(schedules, onClick)
        }
    }
}

@Composable
fun ScheduleItem(
    schedule: Schedule,
    onClick: (Long) -> Unit,
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .heightIn(min = 56.dp)
                .clickable(onClick = { onClick(schedule.id) })
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
    onClick: (Long) -> Unit,
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
                        .clickable(onClick = { onClick(schedule.id) })
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
                style = MaterialTheme.typography.subtitle1,
                color = MeditationTheme.colors.textSecondary,
                modifier = Modifier.padding(horizontal = 16.dp)
            )
            Spacer(modifier = Modifier.height(40.dp))
            Row(
                modifier.padding(
                    start = 16.dp,
                    end = 60.dp
                )
            ) {
                MeditationButton(
                    onClick = { /* todo */ },
                    modifier = Modifier.size(
                        width = 90.dp,
                        height = 30.dp
                    )
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
            .width(IntrinsicSize.Max)
            .wrapContentHeight()
            .padding(bottom = 4.dp)
    ) {
        Column() {
            Column(modifier.height(225.dp)) {
            Box(modifier = Modifier.fillMaxSize()) {
                    Image(
                        painter = rememberCoilPainter(
                            request = scheduleTutorial.imageUrl,
                            previewPlaceholder = R.drawable.placeholder,
                        ),
                        contentDescription = null,
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(225.dp),
                        contentScale = ContentScale.FillBounds
                    )
                    Box(){
                        Text(
                            text = scheduleTutorial.rating,
                            maxLines = 1,
                            overflow = TextOverflow.Ellipsis,
                            style = MaterialTheme.typography.body1,
                            color = MeditationTheme.colors.textColorWhite,
                            modifier = Modifier.padding(horizontal = 16.dp)
                        )
                    }
                }
            }

            Column(
                modifier
                    .background(MeditationTheme.colors.brand)
                    .padding(bottom = 8.dp)) {
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = scheduleTutorial.title,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                    style = MaterialTheme.typography.subtitle1,
                    color = MeditationTheme.colors.textColorWhite,
                    modifier = Modifier.padding(horizontal = 16.dp)
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = scheduleTutorial.rating,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                    style = MaterialTheme.typography.body1,
                    color = MeditationTheme.colors.textColorWhite,
                    modifier = Modifier.padding(horizontal = 16.dp)
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = scheduleTutorial.description,
                    overflow = TextOverflow.Ellipsis,
                    style = MaterialTheme.typography.body1.copy(lineHeight = 16.sp),
                    color = MeditationTheme.colors.textColorWhite,
                    modifier = Modifier.padding(horizontal = 16.dp)
                )
                Spacer(modifier = Modifier.height(8.dp))
                Row(
                    modifier.fillMaxWidth()
                ) {
                    Text(
                        text = scheduleTutorial.totalPeriod,
                        maxLines = 1,
                        textAlign = TextAlign.Start,
                        overflow = TextOverflow.Ellipsis,
                        style = MaterialTheme.typography.body2,
                        color = MeditationTheme.colors.textColorWhite,
                        modifier = Modifier
                            .padding(horizontal = 16.dp)
                            .weight(1f)
                    )
                    Text(
                        text = scheduleTutorial.level,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis,
                        textAlign = TextAlign.Center,
                        style = MaterialTheme.typography.body1,
                        color = MeditationTheme.colors.textColorWhite,
                        modifier = Modifier
                            .padding(horizontal = 16.dp)
                            .weight(1f)
                    )
                    Text(
                        text = scheduleTutorial.tutorialDuration,
                        maxLines = 1,
                        textAlign = TextAlign.End,
                        overflow = TextOverflow.Ellipsis,
                        style = MaterialTheme.typography.body1,
                        color = MeditationTheme.colors.textColorWhite,
                        modifier = Modifier
                            .padding(horizontal = 16.dp)
                            .weight(1f)
                    )
                }
            }
        }

    }

}

@Composable
fun PlayImage(
    imageUrl: Int,
    contentDescription: String?,
    modifier: Modifier = Modifier,
    elevation: Dp = 0.dp
) {
    MeditationSurface(
        color = Color.LightGray,
        elevation = elevation,
        shape = CircleShape,
        modifier = modifier
    ) {
        Image(
            painter = rememberCoilPainter(
                request = imageUrl,
                previewPlaceholder = R.drawable.placeholder,
            ),
            contentDescription = contentDescription,
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop,
        )
    }
}
