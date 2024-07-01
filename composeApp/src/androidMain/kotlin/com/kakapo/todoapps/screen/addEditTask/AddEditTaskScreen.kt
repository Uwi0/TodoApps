package com.kakapo.todoapps.screen.addEditTask

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Save
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.kakapo.todoapps.common.Fun
import com.kakapo.todoapps.common.Fun1
import com.kakapo.todoapps.designSystem.CustomNavigationTopAppBar
import org.koin.androidx.compose.koinViewModel
import presentation.viewmodel.addEditTask.AddEditTaskUiState
import presentation.viewmodel.addEditTask.AddEditTaskViewModel
import presentation.viewmodel.addEditTask.OnSuccessCreateTask

@Composable
internal fun AddEditTaskRoute(navigateUp: Fun) {

    val viewModel = koinViewModel<AddEditTaskViewModel>()
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    val onEvent: Fun1<AddEditEvent> = { effect ->
        when (effect) {
            OnNavigateUp -> navigateUp.invoke()
            is OnDescriptionChanged -> viewModel.onDescriptionChange(effect.description)
            is OnTitleChanged -> viewModel.onTitleChange(effect.title)
            OnSaveTask -> viewModel.saveTask()
        }
    }

    LaunchedEffect(Unit) {
        viewModel.uiEffect.collect { effect ->
            when(effect) {
                OnSuccessCreateTask -> navigateUp.invoke()
            }
        }
    }

    AddEditTaskScreen(uiState = uiState, onEvent = onEvent)
}

@Composable
private fun AddEditTaskScreen(uiState: AddEditTaskUiState, onEvent: Fun1<AddEditEvent>) {
    Scaffold(
        topBar = {
            CustomNavigationTopAppBar(
                title = "New Task",
                onNavigateUp = { onEvent.invoke(OnNavigateUp) }
            )
        },
        content = { paddingValues ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues)
                    .padding(vertical = 24.dp, horizontal = 16.dp)
            ) {
                val textFieldColor = TextFieldDefaults.colors(
                    focusedContainerColor = Color.Transparent,
                    unfocusedContainerColor = Color.Transparent,
                    disabledContainerColor = Color.Transparent,
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent,
                    disabledIndicatorColor = Color.Transparent
                )
                OutlinedTextField(
                    modifier = Modifier.fillMaxWidth(),
                    value = uiState.title,
                    onValueChange = { onEvent.invoke(OnTitleChanged(it)) },
                    placeholder = {
                        Text(
                            text = "Title",
                            style = MaterialTheme.typography.titleMedium
                        )
                    },
                    maxLines = 1,
                    colors = textFieldColor,
                    textStyle = MaterialTheme.typography.titleMedium
                )
                OutlinedTextField(
                    modifier = Modifier.fillMaxWidth(),
                    value = uiState.description,
                    placeholder = {
                        Text(
                            text = "Enter your task here",
                            style = MaterialTheme.typography.bodyMedium
                        )
                    },
                    onValueChange = { onEvent.invoke(OnDescriptionChanged(it)) },
                    colors = textFieldColor,
                    textStyle = MaterialTheme.typography.bodyMedium
                )
            }
        },
        floatingActionButton = {
            FloatingActionButton(
                content = { Icon(imageVector = Icons.Default.Check, contentDescription = null) },
                onClick = { onEvent.invoke(OnSaveTask) }
            )
        }
    )
}