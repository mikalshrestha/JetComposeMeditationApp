package com.mikal.meditationapp.ui.home

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.dp
import com.mikal.meditationapp.models.Profile
import com.mikal.meditationapp.repository.ProfileRepo
import com.mikal.meditationapp.ui.components.BottomProfileDesign
import com.mikal.meditationapp.ui.components.MeditationSurface
import com.mikal.meditationapp.ui.components.ProfileView
import com.mikal.meditationapp.ui.theme.MeditationTheme


private val ProfileCardWidth = 600.dp
private val ProfileCardPadding = 16.dp

@Composable
fun Settings(
    onClick: (Long) -> Unit,
    modifier: Modifier = Modifier
) {
    val profileData = remember { ProfileRepo.getProfileDetail() }
    Settings(
        profileData,
        onClick,
        modifier
    )
}

@Composable
private fun Settings(
    profileData: Profile,
    onClick: (Long) -> Unit,
    modifier: Modifier = Modifier
) {
    MeditationSurface(modifier = modifier.fillMaxSize()) {
        Box {
            Column() {
                ShowProfileView(profileData, onClick)
                BottomProfileView(profileData)
            }

        }
    }
}

@Composable
private fun ShowProfileView(
    profileData: Profile,
    onClick: (Long) -> Unit,
    index: Int = 0,
    ) {
    val left = index * with(LocalDensity.current) {
        (ProfileCardWidth + ProfileCardPadding).toPx()
    }
    val scroll = rememberScrollState(0)
    val gradient = when ((index / 2) % 2) {
        0 -> MeditationTheme.colors.gradient6_1
        else -> MeditationTheme.colors.gradient6_2
    }
    // The Cards show a gradient which spans 3 cards and scrolls with parallax.
    val gradientWidth = with(LocalDensity.current) {
        (6 * (ProfileCardWidth + ProfileCardPadding).toPx())
    }
    ProfileView(
        profileData = profileData,
        onClick = onClick,
        left,
        gradient,
        gradientWidth,
        scroll.value
    )
}

@Composable
private fun BottomProfileView(
    profileData: Profile
    ){
    BottomProfileDesign(
        profileData = profileData
    )
}