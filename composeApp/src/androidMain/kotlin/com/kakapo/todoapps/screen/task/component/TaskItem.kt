package com.kakapo.todoapps.screen.task.component

import androidx.compose.material3.Checkbox
import androidx.compose.material3.ListItem
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import model.Task

@Composable
internal fun TaskItem(task: Task, onChecked: (Int) -> Unit) {
    ListItem(
        headlineContent = { Text(task.title) },
        leadingContent = {
            Checkbox(
                checked = task.isCompleted,
                onCheckedChange = { onChecked.invoke(task.id) }
            )
        }
    )
}


@Preview
@Composable
private fun TaskItemPreview() {
    Surface {
        val task = Task(id = 0, title = "hello", description = "world", isCompleted = false)
        TaskItem(task = task, onChecked = {})
    }
}