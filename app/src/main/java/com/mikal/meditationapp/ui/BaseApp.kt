package com.mikal.meditationapp

import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.google.accompanist.insets.ProvideWindowInsets
import com.mikal.meditationapp.ui.components.meditationScaffold
import com.mikal.meditationapp.ui.home.HomeSections
import com.mikal.meditationapp.ui.home.meditationBottomBar
import com.mikal.meditationapp.ui.meditationNavGraph
import com.mikal.meditationapp.ui.theme.MeditationTheme

@Composable
fun baseApp() {
    ProvideWindowInsets {
        MeditationTheme {
            val tabs = remember { HomeSections.values() }
            val navController = rememberNavController()
            meditationScaffold(
                bottomBar = { meditationBottomBar(navController = navController, tabs = tabs) }
            ) { innerPaddingModifier ->
                meditationNavGraph(
                    navController = navController,
                    modifier = Modifier.padding(innerPaddingModifier)
                )
            }
        }
    }
}