package com.mikal.meditationapp.ui.home

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.google.accompanist.coil.rememberCoilPainter
import com.google.accompanist.insets.statusBarsPadding
import com.mikal.meditationapp.R
import com.mikal.meditationapp.ToolBar
import com.mikal.meditationapp.commons.mirroringBackIcon
import com.mikal.meditationapp.models.Schedule
import com.mikal.meditationapp.repository.ScheduleRepo
import com.mikal.meditationapp.ui.components.MeditationSurface
import com.mikal.meditationapp.ui.components.meditationDivider
import com.mikal.meditationapp.ui.theme.MeditationTheme
import com.mikal.meditationapp.ui.theme.Neutral8


private val GradientScroll = 180.dp
private val ImageOverlap = 115.dp
private val MinTitleOffset = 56.dp
private val HzPadding = Modifier.padding(horizontal = 24.dp)

@Composable
fun ScheduleDetail(
    id: Long,
    upPress: () -> Unit
) {
    val scheduleDetail = remember(id) { ScheduleRepo.getScheduleById(id) }

    Box(Modifier.fillMaxSize()) {
        Column() {
            val scroll = rememberScrollState(0)
            ToolBar()
            HeaderImage(scheduleDetail)
            Spacer(modifier = Modifier.height(16.dp))
            Body(scheduleDetail)
            meditationDivider(thickness = 2.dp, modifier = Modifier.padding(12.dp))
            Details(scheduleDetail, scroll)

        }
        Up(upPress)

    }
}

@Composable
private fun HeaderImage(
    scheduleDetail: Schedule
){
    Column() {
        Image(
            painter = rememberCoilPainter(
                request = scheduleDetail.imageUrl,
                previewPlaceholder = R.drawable.placeholder,
            ),
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth()
                .height(240.dp),
            contentScale = ContentScale.FillBounds
        )
    }


}

@Composable
private fun Up(upPress: () -> Unit) {
    IconButton(
        onClick = upPress,
        modifier = Modifier
            .statusBarsPadding()
            .padding(horizontal = 16.dp, vertical = 10.dp)
            .size(36.dp)
            .background(
                color = Neutral8.copy(alpha = 0.32f),
                shape = CircleShape
            )
    ) {
        Icon(
            imageVector = mirroringBackIcon(),
            tint =  MeditationTheme.colors.iconInteractive,
            contentDescription = stringResource(R.string.label_back)
        )
    }
}

@Composable
private fun Body(
    scheduleDetail: Schedule
    ){

    Column(modifier = Modifier.padding(16.dp)) {
        Text(
            text = scheduleDetail.title,
            textAlign = TextAlign.Center,
            overflow = TextOverflow.Ellipsis,
            style = MaterialTheme.typography.h6,
            color = MeditationTheme.colors.textSecondary,
        )
        Spacer(modifier = Modifier.height(16.dp))
        Text(
            text = scheduleDetail.days,
            textAlign = TextAlign.Center,
            overflow = TextOverflow.Ellipsis,
            style = MaterialTheme.typography.body1,
            color = MeditationTheme.colors.textSecondary,
        )
        Spacer(modifier = Modifier.height(16.dp))
        Text(
            text = scheduleDetail.period,
            textAlign = TextAlign.Center,
            overflow = TextOverflow.Ellipsis,
            style = MaterialTheme.typography.body1,
            color = MeditationTheme.colors.textSecondary,
        )
    }

}

@Composable
private fun Details(
    scheduleDetail: Schedule,
    scroll: ScrollState
    ){

    Column {
        Column(
            modifier = Modifier.verticalScroll(scroll)
        ) {
            MeditationSurface(Modifier.fillMaxWidth()) {
                Column {
                    Text(
                        text = stringResource(R.string.detail_header),
                        style = MaterialTheme.typography.subtitle1,
                        color = MeditationTheme.colors.textHelp,
                        modifier = HzPadding
                    )
                    Spacer(Modifier.height(16.dp))
                    var seeMore by remember { mutableStateOf(true) }
                    Text(
                        text = scheduleDetail.description,
                        style = MaterialTheme.typography.body1,
                        color = MeditationTheme.colors.textHelp,
                        maxLines = if (seeMore) 5 else Int.MAX_VALUE,
                        overflow = TextOverflow.Ellipsis,
                        modifier = HzPadding
                    )
                    val textButton = if (seeMore) {
                        stringResource(id = R.string.see_more)
                    } else {
                        stringResource(id = R.string.see_less)
                    }
                    Text(
                        text = textButton,
                        style = MaterialTheme.typography.button,
                        textAlign = TextAlign.Center,
                        color = MeditationTheme.colors.textLink,
                        modifier = Modifier
                            .heightIn(20.dp)
                            .fillMaxWidth()
                            .padding(top = 15.dp)
                            .clickable {
                                seeMore = !seeMore
                            }
                    )
                    Spacer(Modifier.height(56.dp))
                    meditationDivider()

                }
            }
        }
    }

}




