package com.kakapo.todoapps.screen.task

import model.Task

sealed interface TaskEvent
data object OnOpenDrawer: TaskEvent
data class OnNavigateToTaskDetail(val task: Task): TaskEvent
data object OnNavigateToCreateTask: TaskEvent
data class OnFinishTask(val id: Int): TaskEvent