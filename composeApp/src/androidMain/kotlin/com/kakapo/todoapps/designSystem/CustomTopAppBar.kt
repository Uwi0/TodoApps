package com.kakapo.todoapps.designSystem

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.RowScope
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector
import com.kakapo.todoapps.common.Fun
import com.kakapo.todoapps.common.FunEx

@Composable
fun CustomDrawerTopAppBar(title: String, onOpenDrawer: Fun) {
    DividerTopAppBar(
        title = title,
        navigationIcon = {
            TopbarButton(Icons.Default.Menu, onOpenDrawer)
        }
    )
}

@Composable
fun CustomNavigationWithActionTopAppBar(title: String, onNavigateUp: Fun, onAction: Fun) {
    DividerTopAppBar(
        title = title,
        navigationIcon = {
            TopbarButton(icon = Icons.AutoMirrored.Default.ArrowBack, onClick = onNavigateUp)
        },
        actions = {
            TopbarButton(icon = Icons.Default.Delete, onClick = onAction)
        }
    )
}

@Composable
fun CustomNavigationTopAppBar(title: String, onNavigateUp: Fun) {
    DividerTopAppBar(
        title = title,
        navigationIcon = {
            TopbarButton(icon = Icons.AutoMirrored.Default.ArrowBack, onClick = onNavigateUp)
        }
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun DividerTopAppBar(
    title: String,
    navigationIcon: @Composable () -> Unit,
    actions: @Composable RowScope.() -> Unit = {}
) {
    Column {
        TopAppBar(title = { Text(title) }, navigationIcon = navigationIcon, actions = actions)
        HorizontalDivider()
    }
}

@Composable
private fun TopbarButton(icon: ImageVector, onClick: Fun) {
    IconButton(
        content = { Icon(imageVector = icon, contentDescription = null) },
        onClick = { onClick.invoke() }
    )
}