package com.kakapo.todoapps.screen.task

sealed interface TaskEvent
data object OnOpenDrawer: TaskEvent
