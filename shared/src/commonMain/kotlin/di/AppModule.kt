package di

import org.koin.compose.viewmodel.dsl.viewModelOf
import org.koin.dsl.module
import presentation.viewmodel.addEditTask.AddEditTaskViewModel
import presentation.viewmodel.task.TaskViewModel

fun appModule() = module {
    viewModelOf(::TaskViewModel)
    viewModelOf(::AddEditTaskViewModel)
}