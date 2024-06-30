package di

import org.koin.compose.viewmodel.dsl.viewModelOf
import org.koin.dsl.module
import presentation.viewmodel.taskViewModel.TaskViewModel

fun appModule() = module { viewModelOf(::TaskViewModel) }