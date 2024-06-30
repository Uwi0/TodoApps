package presentation.viewmodel.taskViewModel

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import org.koin.core.component.KoinComponent

class TaskViewModel: ViewModel(), KoinComponent {

    val uiState: StateFlow<TaskUiState> get() = _uiState.asStateFlow()
    private val _uiState = MutableStateFlow(TaskUiState())
}