package com.kakapo.todoapps.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.navigation.NavController
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navOptions
import com.kakapo.todoapps.screen.statistics.navigation.navigateToStatisticScreen
import com.kakapo.todoapps.screen.task.navigation.navigateToTaskScreen

@Composable
fun rememberTodoAppState(
    navController: NavHostController = rememberNavController(),
    startDestination: String
): TodoAppState {
    return remember { TodoAppState(navController = navController, startDestination) }
}

class TodoAppState(val navController: NavHostController, val startDestination: String) {
    
    private val selectedDrawerValue: MutableState<TopLevelDestination> = mutableStateOf(TopLevelDestination.Task)
    
    fun isSelected(menu: TopLevelDestination): Boolean = menu == selectedDrawerValue.value
    
    fun navigateToCurrentMenu(menu: TopLevelDestination) {
        selectedDrawerValue.value = menu
        val topLevelNavOptions = navOptionsPopBackStatck()
        when(menu) {
            TopLevelDestination.Task -> navController.navigateToTaskScreen(topLevelNavOptions)
            TopLevelDestination.Statistic -> navController.navigateToStatisticScreen(topLevelNavOptions)
        }
    }
    
    private fun navOptionsPopBackStatck() = navOptions {
        popUpTo(navController.graph.findStartDestination().id){
            saveState = true
            inclusive = true
        }
        
        launchSingleTop = true
        restoreState = true
    }
}