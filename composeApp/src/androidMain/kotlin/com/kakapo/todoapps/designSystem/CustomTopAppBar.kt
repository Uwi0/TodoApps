package com.kakapo.todoapps.designSystem

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Delete
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

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CustomNavigationWithActionTopAppBar(title: String, onNavigateUp: Fun, onAction: Fun) {
    TopAppBar(
        title = { Text(title) },
        navigationIcon = {
            TopbarButton(icon = Icons.AutoMirrored.Default.ArrowBack, onClick = onNavigateUp)
        },
        actions = {
            TopbarButton(icon = Icons.Default.Delete, onClick = onAction)
        }
    )
}

@Composable
private fun TopbarButton(icon: ImageVector, onClick: Fun) {
    IconButton(
        content = { Icon(imageVector = icon, contentDescription = null) },
        onClick = { onClick.invoke() }
    )
}