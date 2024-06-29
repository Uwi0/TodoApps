package com.kakapo.todoapps.screen.task

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.kakapo.todoapps.common.Fun
import com.kakapo.todoapps.common.Fun1
import com.kakapo.todoapps.designSystem.CustomDrawerTopAppBar

@Composable
internal fun TaskScreenRoute(openDrawer: Fun, navigateToTaskDetail: Fun1<Int>) {

    val onEvent: Fun1<TaskEvent> = { event ->
        when (event) {
            OnOpenDrawer -> openDrawer.invoke()
            is OnNavigateToTaskDetail -> navigateToTaskDetail.invoke(event.id)
        }
    }

    TaskScreen(onEvent = onEvent)
}

@Composable
private fun TaskScreen(onEvent: Fun1<TaskEvent>) {
    Scaffold(
        topBar = {
            CustomDrawerTopAppBar(title = "Todo", onOpenDrawer = { onEvent.invoke(OnOpenDrawer) })
        },
        content = {
            Column(modifier = Modifier.padding(it)) {
                Text("Task Screen")
                Button(content = { Text("Navigate to Detail Task")}, onClick = { onEvent.invoke(OnNavigateToTaskDetail(0))})
            }
        }
    )

}
