package com.kakapo.todoapps.screen.taskDetail.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.kakapo.todoapps.screen.taskDetail.TaskDetailRoute

const val TASK_DETAIL_ROUTE = "task_detail_route"

fun NavController.navigateToTaskDetailScreen(navOptions: NavOptions?, taskId: Int) {
    navigate("$TASK_DETAIL_ROUTE/$taskId", navOptions)
}

fun NavGraphBuilder.taskDetailScreen() {
    composable(TASK_DETAIL_ROUTE) {
        TaskDetailRoute()
    }
}