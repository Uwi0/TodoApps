package com.kakapo.todoapps.screen.task.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.kakapo.todoapps.common.Fun
import com.kakapo.todoapps.screen.task.TaskScreenRoute

const val TASK_ROUTE = "task_route"

fun NavController.navigateToTaskScreen(navOptions: NavOptions? = null) {
    navigate(TASK_ROUTE, navOptions)
}

fun NavGraphBuilder.taskScreen(openDrawer: Fun) {
    composable(TASK_ROUTE) {
        TaskScreenRoute(openDrawer = openDrawer)
    }
}