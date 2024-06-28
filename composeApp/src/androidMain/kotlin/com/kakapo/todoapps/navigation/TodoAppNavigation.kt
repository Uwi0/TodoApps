package com.kakapo.todoapps.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import com.kakapo.todoapps.screen.statistics.navigation.statisticScreen
import com.kakapo.todoapps.screen.task.navigation.taskScreen
import com.kakapo.todoapps.screen.taskDetail.navigation.taskDetailScreen

@Composable
internal fun TodoAppNavHost(
    todoAppState: TodoAppState,
){
    val navController = todoAppState.navController
    NavHost(navController = navController, startDestination = todoAppState.startDestination){
        taskScreen()
        taskDetailScreen()
        statisticScreen()
    }
}