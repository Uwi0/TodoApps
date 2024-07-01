package presentation.viewmodel.taskViewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import model.Task
import org.koin.core.component.KoinComponent

class TaskViewModel: ViewModel(), KoinComponent {

    val uiState: StateFlow<TaskUiState> get() = _uiState.asStateFlow()
    private val _uiState = MutableStateFlow(TaskUiState())

    val uiEffect: SharedFlow<TaskUiEffect> get() = _uiEffect.asSharedFlow()
    private val _uiEffect = MutableSharedFlow<TaskUiEffect>()

    fun onFinishTask(id: Int){

    }

    private fun emitSidEffect(effect: TaskUiEffect) = viewModelScope.launch {
        _uiEffect.emit(effect)
    }
}