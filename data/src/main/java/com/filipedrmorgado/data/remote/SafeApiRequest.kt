package com.filipedrmorgado.data.remote

import com.filipedrmorgado.data.utils.ApiException
import org.json.JSONException
import org.json.JSONObject
import retrofit2.Response

abstract class SafeApiRequest {

    suspend fun <T : Any> apiRequest(call: suspend () -> Response<T>): T {
        val response = call.invoke()

        if (response.isSuccessful) {
            return response.body() ?: throw ApiException("Response body is null")
        } else {
            val error = response.errorBody()?.string()
            val message = buildErrorMessage(response.code(), error)
            throw ApiException(message)
        }
    }

    private fun buildErrorMessage(responseCode: Int, error: String?): String {
        val messageBuilder = StringBuilder()

        error?.run {
            try {
                messageBuilder.append(JSONObject(this).getString("message"))
            } catch (e: JSONException) {
                //todo Handle JSON parsing error if needed
            }
            messageBuilder.append("\n")
        }

        messageBuilder.append("Error Code: $responseCode")
        return messageBuilder.toString()
    }
}
