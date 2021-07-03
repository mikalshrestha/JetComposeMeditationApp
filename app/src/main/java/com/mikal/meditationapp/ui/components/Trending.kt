package com.mikal.meditationapp.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.google.accompanist.coil.rememberCoilPainter
import com.google.accompanist.insets.statusBarsHeight
import com.mikal.meditationapp.R
import com.mikal.meditationapp.models.Trending
import com.mikal.meditationapp.ui.theme.MeditationTheme

@Composable
fun Trendings(
    trending: List<Trending>,
    modifier: Modifier = Modifier
) {
    Row(
        modifier
            .fillMaxWidth()
            .padding(start = 16.dp, top = 35.dp)
    ) {
        Text(
            text = "Trendings",
            style = MaterialTheme.typography.h6,
            color = MeditationTheme.colors.textSecondary,
            textAlign = TextAlign.Start,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
        )
    }
    LazyColumn(
        modifier
            .fillMaxSize()
            .padding(8.dp)
    ) {
        item {
            Spacer(Modifier.statusBarsHeight(additional = 0.dp))
        }
        itemsIndexed(trending) { index, trending ->
            if (index > 0) {
                meditationDivider(thickness = 0.dp)
            }
            TrendingItem(trending)
        }
    }

}

@Composable
private fun TrendingItem(
    trending: Trending,
    modifier: Modifier = Modifier
) {
    meditationCard(
        modifier = modifier
            .wrapContentWidth()
            .height(225.dp)
            .padding(8.dp)
    ) {
        Column {
            Box {
                Image(
                    painter = rememberCoilPainter(
                        request = trending.imageUrl,
                        previewPlaceholder = R.drawable.placeholder,
                    ),
                    contentDescription = null,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(240.dp),
                    contentScale = ContentScale.FillBounds
                )
                Box(modifier = Modifier.fillMaxSize()) {
                    Row(modifier.padding(16.dp)) {
                        Column(modifier.padding(0.dp)) {
                            Text(
                                text = trending.title,
                                style = MaterialTheme.typography.h6,
                                color = MeditationTheme.colors.textColorWhite,
                                textAlign = TextAlign.Center,
                                maxLines = 1,
                                overflow = TextOverflow.Ellipsis,
                                modifier = Modifier.padding(horizontal = 8.dp)
                            )
                            Spacer(modifier = Modifier.height(8.dp))
                            Text(
                                text = trending.author,
                                style = MaterialTheme.typography.body1,
                                color = MeditationTheme.colors.textColorWhite,
                                textAlign = TextAlign.Center,
                                maxLines = 1,
                                overflow = TextOverflow.Ellipsis,
                                modifier = Modifier.padding(horizontal = 8.dp)
                            )
                            Spacer(modifier = Modifier.height(65.dp))
                            Text(
                                text = trending.type,
                                style = MaterialTheme.typography.h6,
                                color = MeditationTheme.colors.textColorWhite,
                                textAlign = TextAlign.Center,
                                maxLines = 1,
                                overflow = TextOverflow.Ellipsis,
                                modifier = Modifier.padding(horizontal = 8.dp)
                            )
                            Spacer(modifier = Modifier.height(8.dp))
                            Text(
                                text = trending.totalPeriod,
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
                                text = trending.level,
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