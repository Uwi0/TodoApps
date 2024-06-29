package com.kakapo.todoapps.screen.taskDetail.navigation

import androidx.navigation.*
import androidx.navigation.compose.composable
import com.kakapo.todoapps.screen.taskDetail.TaskDetailRoute

const val TASK_DETAIL_ROUTE = "task_detail_route"
const val TASK_ID_ARGS = "todo_id"

fun NavController.navigateToTaskDetailScreen(taskId: Int, navOptions: NavOptions? = null, ) {
    navigate("$TASK_DETAIL_ROUTE/$taskId", navOptions)
}

fun NavGraphBuilder.taskDetailScreen() {
    val route = "$TASK_DETAIL_ROUTE/{$TASK_ID_ARGS}"
    val arguments = listOf(navArgument(name = TASK_ID_ARGS){ type = NavType.IntType})
    
    composable(route = route, arguments = arguments) {
        TaskDetailRoute()
    }
}