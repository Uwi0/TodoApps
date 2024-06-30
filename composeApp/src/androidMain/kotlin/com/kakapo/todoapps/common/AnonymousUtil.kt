package com.kakapo.todoapps.common

typealias Fun = () -> Unit

typealias Fun1<T> = (T) -> Unit

typealias Fun2<T, R> = (T) -> R

typealias FunEx<T> = T.() -> Unit