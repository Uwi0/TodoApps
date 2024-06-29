package com.kakapo.todoapps.screen.statistics

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.kakapo.todoapps.common.Fun
import com.kakapo.todoapps.common.Fun1
import com.kakapo.todoapps.designSystem.CustomDrawerTopAppBar

@Composable
internal fun StatisticRoute(openDrawer: Fun) {

    val onEvent: Fun1<StatisticUiEvent> = {
        when (it) {
            OnOpenDrawer -> openDrawer.invoke()
        }
    }

    StatisticScreen(onEvent = onEvent)
}

@Composable
private fun StatisticScreen(onEvent: Fun1<StatisticUiEvent>) {
    Scaffold(
        topBar = { CustomDrawerTopAppBar(title = "Statistic", onOpenDrawer = { onEvent.invoke(OnOpenDrawer) }) },
        content = {
            Column(modifier = Modifier.padding(it)) {
                Text("Statistic Screen")
            }
        }
    )

}