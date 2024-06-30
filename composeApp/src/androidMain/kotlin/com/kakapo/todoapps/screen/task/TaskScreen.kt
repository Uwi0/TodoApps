package com.kakapo.todoapps.screen.task

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.kakapo.todoapps.common.Fun
import com.kakapo.todoapps.common.Fun1
import com.kakapo.todoapps.designSystem.CustomDrawerTopAppBar
import com.kakapo.todoapps.screen.task.component.TaskItem
import org.koin.androidx.compose.koinViewModel
import presentation.viewmodel.taskViewModel.TaskUiState
import presentation.viewmodel.taskViewModel.TaskViewModel

@Composable
internal fun TaskScreenRoute(openDrawer: Fun, navigateToTaskDetail: Fun1<Int>) {

    val viewModel = koinViewModel<TaskViewModel>()
    val uiSTate by viewModel.uiState.collectAsStateWithLifecycle()

    val onEvent: Fun1<TaskEvent> = { event ->
        when (event) {
            OnOpenDrawer -> openDrawer.invoke()
            is OnNavigateToTaskDetail -> navigateToTaskDetail.invoke(event.id)
        }
    }

    TaskScreen(uiState = uiSTate, onEvent = onEvent)
}

@Composable
private fun TaskScreen(uiState: TaskUiState, onEvent: Fun1<TaskEvent>) {
    Scaffold(
        topBar = {
            CustomDrawerTopAppBar(title = "Todo", onOpenDrawer = { onEvent.invoke(OnOpenDrawer) })
        },
        content = {
            Column(modifier = Modifier.padding(it)) {
                LazyColumn {
                    items(uiState.tasks) { task ->
                        TaskItem(task = task, onChecked = {})
                    }
                }
            }
        },
        floatingActionButton = {
            FloatingActionButton(
                content = { Icon(imageVector = Icons.Default.Add, contentDescription = null) },
                onClick = { onEvent.invoke(OnNavigateToTaskDetail(0)) }
            )
        }
    )

}
