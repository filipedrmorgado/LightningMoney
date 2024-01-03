package com.filipedrmorgado.data.remote

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import com.filipedrmorgado.data.utils.NoInternetException
import com.filipedrmorgado.data.utils.active_connection
import okhttp3.Interceptor
import okhttp3.Response

/**
 * An OkHttp interceptor for checking network connectivity before making API requests.
 * Throws [NoInternetException] if no internet connection is available.
 */
class NetworkConnectionInterceptor(
    context: Context
) : Interceptor {

    private val applicationContext = context.applicationContext

    /**
     * Intercepts the OkHttp request and checks for internet connectivity.
     *
     * @param chain The OkHttp interceptor chain.
     * @return The response if internet is available; otherwise, throws [NoInternetException].
     */
    override fun intercept(chain: Interceptor.Chain): Response {
        if (!isInternetAvailable())
            throw NoInternetException(active_connection)
        return chain.proceed(chain.request()
            .newBuilder()
            .build())
    }

    /**
     * Checks if the device has internet connectivity.
     *
     * @return `true` if internet is available, `false` otherwise.
     */
    private fun isInternetAvailable(): Boolean {
        var result = false
        val connectivityManager = applicationContext.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager?
        connectivityManager?.let {
            it.getNetworkCapabilities(connectivityManager.activeNetwork)?.apply {
                result = when {
                    hasTransport(NetworkCapabilities.TRANSPORT_WIFI) -> true
                    hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR) -> true
                    else -> false
                }
            }
        }
        return result
    }
}