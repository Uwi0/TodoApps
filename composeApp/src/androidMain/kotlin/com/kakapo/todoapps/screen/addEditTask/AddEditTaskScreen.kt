package com.kakapo.todoapps.screen.addEditTask

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
internal fun AddEditTaskRoute() {
    AddEditTaskScreen()
}

@Composable
private fun AddEditTaskScreen() {
    Scaffold(
        content = {
            Column(modifier = Modifier.fillMaxSize().padding(it)) {
                Text("AddEditTask")
            }
        }
    )
}