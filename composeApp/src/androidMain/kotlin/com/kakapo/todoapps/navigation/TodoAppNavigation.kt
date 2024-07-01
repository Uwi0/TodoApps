package com.kakapo.todoapps.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import com.kakapo.todoapps.common.Fun
import com.kakapo.todoapps.screen.addEditTask.navigation.addEditTaskScreen
import com.kakapo.todoapps.screen.addEditTask.navigation.navigateToAddEditTask
import com.kakapo.todoapps.screen.statistics.navigation.statisticScreen
import com.kakapo.todoapps.screen.task.navigation.taskScreen
import com.kakapo.todoapps.screen.taskDetail.navigation.navigateToTaskDetailScreen
import com.kakapo.todoapps.screen.taskDetail.navigation.taskDetailScreen

@Composable
internal fun TodoAppNavHost(
    todoAppState: TodoAppState,
    openDrawer: Fun,
) {

    val navController = todoAppState.navController

    NavHost(navController = navController, startDestination = todoAppState.startDestination) {
        taskScreen(
            openDrawer = openDrawer,
            navigateToTaskDetail = navController::navigateToTaskDetailScreen,
            navigateToCreateTask = navController::navigateToAddEditTask
        )
        taskDetailScreen(
            navigateUp = navController::popBackStack,
            navigateToEditTask = navController::navigateToAddEditTask
        )
        addEditTaskScreen()
        statisticScreen(openDrawer = openDrawer)
    }
}