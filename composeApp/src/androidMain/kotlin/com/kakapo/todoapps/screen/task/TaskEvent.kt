package com.kakapo.todoapps.screen.task

sealed interface TaskEvent
data object OnOpenDrawer: TaskEvent
data class OnNavigateToTaskDetail(val id: Int): TaskEvent
