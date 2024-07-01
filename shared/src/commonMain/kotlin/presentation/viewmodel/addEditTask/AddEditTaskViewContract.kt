package presentation.viewmodel.addEditTask

data class AddEditTaskUiState(
    val title: String = "",
    val description: String = "",
)

sealed interface AddEditTaskUiEffect
data object OnSuccessCreateTask: AddEditTaskUiEffect