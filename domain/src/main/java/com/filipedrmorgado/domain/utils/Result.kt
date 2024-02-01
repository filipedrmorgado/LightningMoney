package com.filipedrmorgado.domain.utils

/**
 * A sealed class representing the result of an operation, which can be either success or failure.
 */
sealed class Result

/**
 * Represents a successful result with optional associated data.
 *
 * @property data The optional data associated with the success.
 */
data class Success<out T : Any>(val data: T? = null) : Result()

/**
 * Represents an error result with optional exception and error message.
 *
 * @property exception The optional exception associated with the error.
 * @property errorMessage The error message describing the failure.
 */
data class Error(
    val exception: Exception? = null,
    val errorMessage: String = EMPTY_STRING
) : Result()

/**
 * Represents a simple success result without any associated data.
 */
data object SimpleSuccess : Result()
