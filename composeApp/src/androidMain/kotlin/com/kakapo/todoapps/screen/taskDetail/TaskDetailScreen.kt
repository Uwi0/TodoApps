package com.kakapo.todoapps.screen.taskDetail

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.kakapo.todoapps.common.Fun
import com.kakapo.todoapps.common.Fun1
import com.kakapo.todoapps.designSystem.CustomNavigationWithActionTopAppBar

@Composable
internal fun TaskDetailRoute(navigateUp: Fun, navigateToEditTask: Fun1<Int>) {

    val onEvent: Fun1<TaskDetailEvent> = { event ->
        when (event) {
            OnDeleteTask -> {}
            OnNavigateUp -> navigateUp.invoke()
            is OnNavigateToEditTask -> navigateToEditTask.invoke(event.id)
        }
    }

    TaskDetailScreen(onEvent = onEvent)
}

@Composable
private fun TaskDetailScreen(onEvent: Fun1<TaskDetailEvent>) {
    Scaffold(
        topBar = {
            CustomNavigationWithActionTopAppBar(
                title = "Task Detail",
                onNavigateUp = { onEvent.invoke(OnNavigateUp) },
                onAction = { onEvent.invoke(OnDeleteTask) }
            )
        },
        content = {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(it)
            ) {

            }
        },
        floatingActionButton = {
            FloatingActionButton(
                content = { Icon(imageVector = Icons.Default.Edit, contentDescription = null)},
                onClick = { onEvent.invoke(OnNavigateToEditTask(0))}
            )
        }
    )
}