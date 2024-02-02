package com.filipedrmorgado.data.utils

import java.io.IOException

/**
 * Exception thrown when there is an API-related error.
 *
 * @param message The error message.
 */
class ApiException(message: String) : IOException(message)

/**
 * Exception thrown when there is no internet connection.
 *
 * @param message The error message.
 */
class NoInternetException(message: String) : IOException(message)
