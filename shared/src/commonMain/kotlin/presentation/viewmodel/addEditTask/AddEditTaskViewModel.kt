package presentation.viewmodel.addEditTask

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import org.koin.core.component.KoinComponent

class AddEditTaskViewModel: ViewModel(), KoinComponent {

    val uiState: StateFlow<AddEditTaskUiState> get() = _uiState.asStateFlow()
    private val _uiState: MutableStateFlow<AddEditTaskUiState> = MutableStateFlow(AddEditTaskUiState())

    val uiEffect: SharedFlow<AddEditTaskUiEffect> get() = _uiEffect.asSharedFlow()
    private val _uiEffect: MutableSharedFlow<AddEditTaskUiEffect> = MutableSharedFlow()

    fun onTitleChange(title: String) {
        _uiState.update { it.copy(title = title) }
    }

    fun onDescriptionChange(description: String) {
        _uiState.value = _uiState.value.copy(description = description)
    }

    fun saveTask() {
        emitSidEffect(OnSuccessCreateTask)
    }

    private fun emitSidEffect(effect: AddEditTaskUiEffect) = viewModelScope.launch {
        _uiEffect.emit(effect)
    }
}