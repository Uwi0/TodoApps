package com.kakapo.todoapps.screen.addEditTask.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.kakapo.todoapps.screen.addEditTask.AddEditTaskRoute

const val ADD_EDIT_TASK_ROUTE = "add_edit_task_route"

fun NavController.navigateToAddEditTask(id: Int, navOptions: NavOptions? = null) {
    navigate(ADD_EDIT_TASK_ROUTE)
}

fun NavGraphBuilder.addEditTaskScreen(){
    composable(ADD_EDIT_TASK_ROUTE) {
        AddEditTaskRoute()
    }
}