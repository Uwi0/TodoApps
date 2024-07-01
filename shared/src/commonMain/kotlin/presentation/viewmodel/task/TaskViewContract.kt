package presentation.viewmodel.task

import model.Task
import model.fakeTasks

data class TaskUiState(
    val tasks: List<Task> = fakeTasks()
)

sealed interface TaskUiEffect
data class NavigateToTaskDetail(val id: Int) : TaskUiEffect