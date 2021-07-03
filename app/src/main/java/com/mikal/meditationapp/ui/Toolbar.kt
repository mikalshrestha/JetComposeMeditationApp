package com.mikal.meditationapp

import androidx.compose.foundation.layout.Column
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.google.accompanist.insets.statusBarsPadding
import com.mikal.meditationapp.ui.components.meditationDivider
import com.mikal.meditationapp.ui.theme.AlphaNearOpaque
import com.mikal.meditationapp.ui.theme.MeditationTheme

@Composable
fun ToolBar(modifier: Modifier = Modifier) {
    Column(modifier = modifier.statusBarsPadding()) {
        TopAppBar(
            backgroundColor = MeditationTheme.colors.brandSecondary.copy(alpha = AlphaNearOpaque),
            contentColor = MeditationTheme.colors.textColorWhite,
            elevation = 0.dp
        ) {
            Text(
                text = "Schedule Detail",
                style = MaterialTheme.typography.subtitle1,
                color = MeditationTheme.colors.textSecondary,
                textAlign = TextAlign.Center,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                modifier = Modifier
                    .weight(1f)
                    .align(Alignment.CenterVertically)
            )
        }
        meditationDivider()
    }
}