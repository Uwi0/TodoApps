package model

data class Task(
    val id: Int,
    val title: String,
    val description: String,
    val isCompleted: Boolean
)

fun fakeTasks() = listOf(
    Task(id = 0, title = "hello", description = "world", isCompleted = false),
    Task(id = 1, title = "world", description = "hello", isCompleted = false),
)