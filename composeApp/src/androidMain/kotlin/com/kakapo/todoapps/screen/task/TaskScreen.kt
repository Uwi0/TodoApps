package com.kakapo.todoapps.screen.task

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.kakapo.todoapps.common.Fun
import com.kakapo.todoapps.common.Fun1
import com.kakapo.todoapps.designSystem.CustomDrawerTopAppBar
import com.kakapo.todoapps.screen.task.component.TaskItem
import org.koin.androidx.compose.koinViewModel
import presentation.viewmodel.task.NavigateToTaskDetail
import presentation.viewmodel.task.TaskUiState
import presentation.viewmodel.task.TaskViewModel

@Composable
internal fun TaskScreenRoute(
    openDrawer: Fun,
    navigateToTaskDetail: Fun1<Int>,
    navigateToCreateTask: Fun
) {

    val viewModel = koinViewModel<TaskViewModel>()
    val uiSTate by viewModel.uiState.collectAsStateWithLifecycle()

    val onEvent: Fun1<TaskEvent> = { event ->
        when (event) {
            is OnNavigateToTaskDetail -> navigateToTaskDetail.invoke(event.task.id)
            is OnFinishTask -> viewModel.onFinishTask(event.id)
            OnOpenDrawer -> openDrawer.invoke()
            OnNavigateToCreateTask -> navigateToCreateTask.invoke()
        }
    }

    LaunchedEffect(Unit) {
        viewModel.uiEffect.collect { effect ->
            when (effect) {
                is NavigateToTaskDetail -> navigateToTaskDetail.invoke(effect.id)
            }
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
        content = { paddingValues ->
            Column(modifier = Modifier.padding(paddingValues)) {
                LazyColumn {
                    items(uiState.tasks) { task ->
                        TaskItem(
                            task = task,
                            onChecked = { onEvent.invoke(OnFinishTask(it)) },
                            onClick = { onEvent.invoke(OnNavigateToTaskDetail(task)) }
                        )
                    }
                }
            }
        },
        floatingActionButton = {
            FloatingActionButton(
                content = { Icon(imageVector = Icons.Default.Add, contentDescription = null) },
                onClick = { onEvent.invoke(OnNavigateToCreateTask) }
            )
        }
    )

}
