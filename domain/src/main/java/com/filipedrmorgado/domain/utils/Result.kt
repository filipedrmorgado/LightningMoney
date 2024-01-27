package com.filipedrmorgado.domain.utils

sealed class Result

data class Success<out T : Any>(val data: T? = null) : Result()
data class Error(val exception: Exception? = null,
                 val errorMessage: String = EMPTY_STRING
) : Result()
data object SimpleSuccess : Result()
