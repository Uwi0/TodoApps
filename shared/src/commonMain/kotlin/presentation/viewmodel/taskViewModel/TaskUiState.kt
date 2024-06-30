package presentation.viewmodel.taskViewModel

import model.Task
import model.fakeTasks

data class TaskUiState(
    val tasks: List<Task> = fakeTasks()
)