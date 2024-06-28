package com.kakapo.todoapps

import TodoApp
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.kakapo.todoapps.navigation.rememberTodoAppState
import com.kakapo.todoapps.screen.task.navigation.TASK_ROUTE

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                val state = rememberTodoAppState(startDestination = TASK_ROUTE)
                TodoApp(state)
            }
        }
    }
}
