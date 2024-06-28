import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.unit.dp
import com.kakapo.todoapps.navigation.TodoAppNavHost
import com.kakapo.todoapps.navigation.TodoAppState
import com.kakapo.todoapps.navigation.TopLevelDestination
import common.Fun
import kotlinx.coroutines.launch

@Composable
fun TodoApp(todoAppState: TodoAppState) {
    val scope = rememberCoroutineScope()
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val openDrawer: Fun = { scope.launch { drawerState.open() } }
    val closeDrawer: Fun = { scope.launch { drawerState.close() } }
    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = { DrawerContent(todoAppState = todoAppState, closeDrawer = closeDrawer) },
        content = {
            TodoAppNavHost(todoAppState = todoAppState)
        }
    )
}

@Composable
private fun DrawerContent(
    todoAppState: TodoAppState,
    closeDrawer: () -> Unit
) {
    ModalDrawerSheet(drawerShape = RectangleShape) {
        Column(
            modifier = Modifier.padding(horizontal = 16.dp, vertical = 24.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            TopLevelDestination.entries.forEach { menuTopLevel ->
                DrawerMenuItem(
                    menu = menuTopLevel,
                    isSelected = todoAppState.isSelected(menuTopLevel),
                    onClick = { topLevelDestination ->
                        todoAppState.navigateToCurrentMenu(topLevelDestination)
                        closeDrawer.invoke()
                    }
                )
            }
        }
    }
}

@Composable
private fun DrawerMenuItem(
    menu: TopLevelDestination,
    isSelected: Boolean,
    onClick: (TopLevelDestination) -> Unit,
) {
    val title = menu.title
    NavigationDrawerItem(
        label = { Text(title) },
        selected = isSelected,
        onClick = { onClick.invoke(menu) }
    )
}