package com.kakapo.todoapps.designSystem

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector
import com.kakapo.todoapps.common.Fun

@Composable
@OptIn(ExperimentalMaterial3Api::class)
fun CustomDrawerTopAppBar(title: String, onOpenDrawer: Fun) {
    TopAppBar(
        title = { Text(title) },
        navigationIcon = {
            TopbarButton(Icons.Default.Menu, onOpenDrawer)
        }
    )
}

@Composable
private fun TopbarButton(icon: ImageVector, onOpenDrawer: Fun) {
    IconButton(
        content = { Icon(imageVector = icon, contentDescription = null) },
        onClick = { onOpenDrawer.invoke() }
    )
}