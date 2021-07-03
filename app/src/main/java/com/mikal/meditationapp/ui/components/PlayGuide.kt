package com.mikal.meditationapp.ui.components

import android.content.res.Configuration
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.google.accompanist.coil.rememberCoilPainter
import com.google.accompanist.insets.statusBarsHeight
import com.mikal.meditationapp.R
import com.mikal.meditationapp.models.BeginnerStepGuide
import com.mikal.meditationapp.models.MostPopular
import com.mikal.meditationapp.ui.theme.MeditationTheme


@Composable
fun BeginnerGuides(
    beginnerStepGuideData: List<BeginnerStepGuide>,
    modifier: Modifier = Modifier
) {
    Row(
        modifier
            .fillMaxWidth()
            .padding(top = 8.dp, bottom = 16.dp, end = 8.dp)
    ) {
        Text(
            text = "Beginners Steps",
            style = MaterialTheme.typography.h6,
            color = MeditationTheme.colors.textSecondary,
            textAlign = TextAlign.Start,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
            modifier = Modifier.padding(horizontal = 16.dp)
        )
        Text(
            text = "See All",
            maxLines = 1,
            textAlign = TextAlign.End,
            overflow = TextOverflow.Ellipsis,
            style = MaterialTheme.typography.body1,
            color = MeditationTheme.colors.textColorWhite,
            modifier = Modifier.padding(horizontal = 16.dp)
        )
    }

    LazyRow(
        modifier
            .fillMaxSize()
            .padding(0.dp)
    ) {
        item {
            Spacer(Modifier.statusBarsHeight(additional = 0.dp))
        }
        itemsIndexed(beginnerStepGuideData) { index, beginnerStepGuideData ->
            if (index > 0) {
                meditationDivider(thickness = 2.dp)
            }
            BeginnerStepsItem(beginnerStepGuideData)
        }
    }
}


@Composable
fun BeginnerStepsItem(
    beginnerStepGuideData: BeginnerStepGuide,
    modifier: Modifier = Modifier
) {
    Row() {
        meditationCard(
            modifier = modifier
                .size(
                    width = 200.dp,
                    height = 250.dp
                )
                .padding(start = 16.dp, bottom = 16.dp, end = 16.dp)
        ) {
            Box(modifier = Modifier.fillMaxSize()) {
                Column(modifier = modifier) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier
                            .heightIn(min = 56.dp)
                    ) {
                        BeginnerStepsImage(
                            imageUrl = beginnerStepGuideData.imageUrl,
                            contentDescription = null
                        )
                    }
                }
                Box(modifier.padding(start = 8.dp, top = 140.dp, bottom = 8.dp)){
                    Column() {
                        Text(
                            text = beginnerStepGuideData.title,
                            style = MaterialTheme.typography.h6,
                            color = MeditationTheme.colors.textColorWhite,
                            textAlign = TextAlign.Center,
                            maxLines = 1,
                            overflow = TextOverflow.Ellipsis,
                            modifier = Modifier.padding(horizontal = 8.dp)
                        )
                        Text(
                            text = beginnerStepGuideData.period,
                            style = MaterialTheme.typography.body1,
                            color = MeditationTheme.colors.textColorWhite,
                            textAlign = TextAlign.Center,
                            maxLines = 1,
                            overflow = TextOverflow.Ellipsis,
                            modifier = Modifier.padding(horizontal = 8.dp)
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun BeginnerStepsImage(
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
fun ShowMostPopular(
    mostPopular: MostPopular,
    modifier: Modifier = Modifier
) {
    Row(
        modifier
            .fillMaxWidth()
            .padding(top = 8.dp, bottom = 8.dp)
    ) {
        Text(
            text = "Most Popular",
            style = MaterialTheme.typography.h6,
            color = MeditationTheme.colors.textSecondary,
            textAlign = TextAlign.Start,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
            modifier = Modifier.padding(horizontal = 16.dp)
        )
    }

    meditationCard(
        modifier = modifier
            .wrapContentWidth()
            .height(225.dp)
            .padding(start = 16.dp, top = 16.dp, bottom = 4.dp, end = 16.dp)
    ) {
        Column {
            Box {
                Image(
                    painter = rememberCoilPainter(
                        request = mostPopular.imageUrl,
                        previewPlaceholder = R.drawable.placeholder,
                    ),
                    contentDescription = null,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(225.dp),
                    contentScale = ContentScale.FillBounds
                )
                Box(modifier = Modifier.fillMaxSize()) {
                    Row(modifier.padding(16.dp)) {
                        Column(modifier.padding(0.dp)) {
                            Text(
                                text = mostPopular.title,
                                style = MaterialTheme.typography.h6,
                                color = MeditationTheme.colors.textColorWhite,
                                textAlign = TextAlign.Center,
                                maxLines = 1,
                                overflow = TextOverflow.Ellipsis,
                                modifier = Modifier.padding(horizontal = 8.dp)
                            )
                            Spacer(modifier = Modifier.height(8.dp))
                            Text(
                                text = mostPopular.author,
                                style = MaterialTheme.typography.body1,
                                color = MeditationTheme.colors.textColorWhite,
                                textAlign = TextAlign.Center,
                                maxLines = 1,
                                overflow = TextOverflow.Ellipsis,
                                modifier = Modifier.padding(horizontal = 8.dp)
                            )
                            Spacer(modifier = Modifier.height(65.dp))
                            Text(
                                text = mostPopular.type,
                                style = MaterialTheme.typography.h6,
                                color = MeditationTheme.colors.textColorWhite,
                                textAlign = TextAlign.Center,
                                maxLines = 1,
                                overflow = TextOverflow.Ellipsis,
                                modifier = Modifier.padding(horizontal = 8.dp)
                            )
                            Spacer(modifier = Modifier.height(8.dp))
                            Text(
                                text = mostPopular.totalPeriod,
                                style = MaterialTheme.typography.body1,
                                color = MeditationTheme.colors.textColorWhite,
                                textAlign = TextAlign.Center,
                                maxLines = 1,
                                overflow = TextOverflow.Ellipsis,
                                modifier = Modifier.padding(horizontal = 8.dp)
                            )
                        }
                        Spacer(modifier = Modifier.width(100.dp))
                        MeditationButton(
                            onClick = { /* todo */ }, modifier = Modifier
                                .size(
                                    width = 70.dp,
                                    height = 30.dp
                                )
                                .padding(0.dp)
                        ) {
                            Text(
                                text = mostPopular.level,
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

    }

}

@Composable
fun ShowFirstCardView(
    mostPopular: MostPopular,
    modifier: Modifier = Modifier
) {
    Row() {
        meditationCard(
            modifier = modifier
                .width(200.dp)
                .height(150.dp)
                .padding(start = 16.dp, top = 16.dp, bottom = 4.dp)
        ) {
            Column(modifier.padding(8.dp)) {
                Row() {
                    Image(
                        painter = rememberCoilPainter(
                            request = R.drawable.calendar,
                            previewPlaceholder = R.drawable.placeholder,
                        ),
                        contentDescription = null,
                        modifier = Modifier
                            .width(30.dp)
                            .height(30.dp)
                            .padding(start = 10.dp, top = 6.dp, bottom = 4.dp),
                        contentScale = ContentScale.FillBounds
                    )
                    Text(
                        text = mostPopular.totalDays,
                        style = MaterialTheme.typography.h6,
                        color = MeditationTheme.colors.textSecondary,
                        textAlign = TextAlign.Center,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis,
                        modifier = Modifier.padding(horizontal = 25.dp)
                    )
                }
                meditationDivider(thickness = 2.dp, modifier = Modifier.padding(6.dp))
                Row() {
                    Image(
                        painter = rememberCoilPainter(
                            request = R.drawable.clock,
                            previewPlaceholder = R.drawable.placeholder,
                        ),
                        contentDescription = null,
                        modifier = Modifier
                            .width(30.dp)
                            .height(30.dp)
                            .padding(start = 10.dp, top = 6.dp, bottom = 4.dp),
                        contentScale = ContentScale.FillBounds
                    )
                    Text(
                        text = mostPopular.totalTimes,
                        style = MaterialTheme.typography.h6,
                        color = MeditationTheme.colors.textSecondary,
                        textAlign = TextAlign.Center,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis,
                        modifier = Modifier.padding(horizontal = 25.dp)
                    )
                }
                meditationDivider(thickness = 2.dp, modifier = Modifier.padding(6.dp))
                Row() {
                    Image(
                        painter = rememberCoilPainter(
                            request = R.drawable.fire,
                            previewPlaceholder = R.drawable.placeholder,
                        ),
                        contentDescription = null,
                        modifier = Modifier
                            .width(30.dp)
                            .height(30.dp)
                            .padding(start = 10.dp, top = 6.dp, bottom = 4.dp),
                        contentScale = ContentScale.FillBounds
                    )
                    Text(
                        text = mostPopular.totalCalories,
                        style = MaterialTheme.typography.h6,
                        color = MeditationTheme.colors.textSecondary,
                        textAlign = TextAlign.Center,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis,
                        modifier = Modifier.padding(horizontal = 25.dp)
                    )
                }
            }

        }

        CircleShape(
            modifier
                .padding(start = 40.dp)
                .align(Alignment.CenterVertically))
    }

}

@Composable
fun CircleShape(
    modifier: Modifier = Modifier,
    elevation: Dp = 0.dp
) {
    MeditationSurface(
        color = Color.LightGray,
        elevation = elevation,
        shape = CircleShape,
        modifier = modifier
    ) {
        Text(
            text = "Beginner",
            style = MaterialTheme.typography.h6,
            color = MeditationTheme.colors.textSecondary,
            textAlign = TextAlign.Center,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
            modifier = Modifier.padding(horizontal = 16.dp)
        )
    }
}


@Preview("default")
@Preview("dark theme", uiMode = Configuration.UI_MODE_NIGHT_YES)
@Preview("large font", fontScale = 2f)
@Composable
fun Preview() {
    MeditationTheme {
        CircleShape(

        )
    }
}
