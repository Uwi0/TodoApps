package com.kakapo.todoapps.screen.task

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.kakapo.todoapps.common.Fun
import com.kakapo.todoapps.common.Fun1
import com.kakapo.todoapps.designSystem.CustomDrawerTopAppBar

@Composable
internal fun TaskScreenRoute(openDrawer: Fun) {

    val onEvent: Fun1<TaskEvent> = {
        when (it) {
            OnOpenDrawer -> openDrawer.invoke()
        }
    }

    TaskScreen(onEvent = onEvent)
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun TaskScreen(onEvent: Fun1<TaskEvent>) {
    Scaffold(
        topBar = {
            CustomDrawerTopAppBar(title = "Todo", onOpenDrawer = { onEvent.invoke(OnOpenDrawer) })
        },
        content = {
            Column(modifier = Modifier.padding(it)) {
                Text("Task Screen")
            }
        }
    )

}

@Composable
@OptIn(ExperimentalMaterial3Api::class)
private fun TaskTopAppBar(onEvent: Fun1<TaskEvent>) {
    TopAppBar(
        title = { Text("Todo") },
        navigationIcon = {
            IconButton(
                content = {
                    Icon(
                        imageVector = Icons.Default.Menu,
                        contentDescription = null
                    )
                },
                onClick = {
                    onEvent.invoke(OnOpenDrawer)
                }
            )
        }
    )
}