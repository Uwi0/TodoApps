package com.kakapo.todoapps.screen.task.component

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Checkbox
import androidx.compose.material3.ListItem
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.kakapo.todoapps.common.Fun1
import model.Task

@Composable
internal fun TaskItem(task: Task, onChecked: Fun1<Int>, onClick: Fun1<Task>) {
    val textDecoration = if (task.isCompleted) TextDecoration.LineThrough else null
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(16.dp),
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 8.dp)
            .clickable { onClick.invoke(task) }
    ) {
        Checkbox(checked = task.isCompleted, onCheckedChange = { onChecked.invoke(task.id) })
        Text(
            text = task.title,
            style = MaterialTheme.typography.titleMedium,
            textDecoration = textDecoration
        )
    }
}


@Preview
@Composable
private fun TaskItemPreview() {
    Surface {
        val task = Task(id = 0, title = "hello", description = "world", isCompleted = false)
        TaskItem(task = task, onChecked = {}) {}
    }
}