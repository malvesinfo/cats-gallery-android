package com.maalves.cats.domain

sealed class Response<out T> {
    class Success<T>(val data: T) : Response<T>()
    class Loading<T> : Response<T>()
    class Error<T>(val throwable: Throwable) : Response<T>()
}