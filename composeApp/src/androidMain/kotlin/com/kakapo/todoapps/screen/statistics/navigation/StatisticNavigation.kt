package com.kakapo.todoapps.screen.statistics.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.kakapo.todoapps.screen.statistics.StatisticRoute

const val STATISTIC_ROUTE = "statistic_route"

fun NavController.navigateToStatisticScreen(navOptions: NavOptions? = null) {
    navigate(STATISTIC_ROUTE, navOptions)
}

fun NavGraphBuilder.statisticScreen() {
    composable(STATISTIC_ROUTE) {
        StatisticRoute()
    }
}