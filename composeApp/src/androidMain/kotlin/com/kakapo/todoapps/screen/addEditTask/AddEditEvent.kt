package com.kakapo.todoapps.screen.addEditTask

sealed interface AddEditEvent
data object OnNavigateUp: AddEditEvent
data class OnTitleChanged(val title: String): AddEditEvent
data class OnDescriptionChanged(val description: String): AddEditEvent
data object OnSaveTask: AddEditEvent