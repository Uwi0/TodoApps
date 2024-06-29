package com.kakapo.todoapps.screen.taskDetail

sealed interface TaskDetailEvent
data object OnNavigateUp: TaskDetailEvent
data object OnDeleteTask: TaskDetailEvent
data class OnNavigateToEditTask(val id: Int): TaskDetailEvent