package com.mikal.meditationapp.ui

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.Lifecycle
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navArgument
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navigation
import com.mikal.meditationapp.ui.MainDestinations.ID_KEY
import com.mikal.meditationapp.ui.home.HomeSections
import com.mikal.meditationapp.ui.home.ScheduleDetail
import com.mikal.meditationapp.ui.home.addHomeGraph

/**
 * Destinations used in the App.
 */
object MainDestinations {
    const val HOME_ROUTE = "home"
    const val DETAIL_ROUTE = "schedule"
    const val ID_KEY = "id"
}

@Composable
fun meditationNavGraph(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
    startDestination: String = MainDestinations.HOME_ROUTE,
) {
    NavHost(
        navController = navController,
        startDestination = startDestination,
        modifier = modifier
    ) {
        navigation(
            route = MainDestinations.HOME_ROUTE,
            startDestination = HomeSections.FEED.route
        ) {
            addHomeGraph(
                onSelected = { id: Long, from: NavBackStackEntry ->
                    // In order to discard duplicated navigation events, we check the Lifecycle
                    if (from.lifecycleIsResumed()) {
                        navController.navigate("${MainDestinations.DETAIL_ROUTE}/$id")
                    }
                },
                modifier = modifier
            )
        }
        composable(
            "${MainDestinations.DETAIL_ROUTE}/{$ID_KEY}",
            arguments = listOf(navArgument(ID_KEY) { type = NavType.LongType })
        ) { backStackEntry ->
            val arguments = requireNotNull(backStackEntry.arguments)
            val id = arguments.getLong(ID_KEY)
            ScheduleDetail(
                id = id,
                upPress = {
                    navController.navigateUp()
                }
            )
        }
    }
}

/**
 * If the lifecycle is not resumed it means this NavBackStackEntry already processed a nav event.
 *
 * This is used to de-duplicate navigation events.
 */
private fun NavBackStackEntry.lifecycleIsResumed() =
    this.lifecycle.currentState == Lifecycle.State.RESUMED
