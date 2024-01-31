package com.filipedrmorgado.data.remote.api

import com.filipedrmorgado.data.remote.NetworkConnectionInterceptor
import com.filipedrmorgado.data.remote.response.AccountCreation
import com.filipedrmorgado.data.remote.response.WalletBalance
import com.filipedrmorgado.data.remote.response.WalletCheckInvoice
import com.filipedrmorgado.data.remote.response.WalletCreation
import com.filipedrmorgado.data.remote.response.WalletDecodeInvoice
import com.filipedrmorgado.data.remote.response.WalletInvoiceCreation
import com.filipedrmorgado.data.remote.response.WalletPayInvoice
import com.filipedrmorgado.data.utils.http_lightning_content_type
import com.filipedrmorgado.data.utils.lightning_base_url
import com.filipedrmorgado.data.utils.url_create_account
import com.filipedrmorgado.data.utils.url_create_check_pay_invoice
import com.filipedrmorgado.data.utils.url_create_wallet
import com.filipedrmorgado.data.utils.url_decode_invoice
import com.filipedrmorgado.data.utils.url_wallet_balance
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import okhttp3.OkHttpClient
import okhttp3.RequestBody
import okhttp3.ResponseBody
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.*
import java.util.concurrent.TimeUnit

interface LightningAPI {

    // POSTS
    @Headers(http_lightning_content_type)
    @POST(url_create_wallet)
    suspend fun createWallet(
        @Header("X-Api-Key") apiKey: String,
        @Body params: RequestBody
    ) : Response<WalletCreation>

    @Headers(http_lightning_content_type)
    @POST(url_create_account)
    suspend fun createAccount(
        @Body params: RequestBody
    ) : Response<AccountCreation>

    @Headers(http_lightning_content_type)
    @GET
    suspend fun importWallet(
        @Header("X-Api-Key") apiKey: String,
        @Url url: String,
    ) : Response<ResponseBody>

    @Headers(http_lightning_content_type)
    @POST(url_create_check_pay_invoice)
    suspend fun createInvoice(
        @Header("X-Api-Key") apiKey: String,
        @Body params: RequestBody
    ) : Response<WalletInvoiceCreation>

    @Headers(http_lightning_content_type)
    @POST(url_decode_invoice)
    suspend fun decodeInvoice(
        @Header("X-Api-Key") apiKey: String,
        @Body params: RequestBody
    ) : Response<WalletDecodeInvoice>

    @Headers(http_lightning_content_type)
    @POST(url_create_check_pay_invoice)
    suspend fun payInvoice(
        @Header("X-Api-Key") apiKey: String,
        @Body params: RequestBody
    ) : Response<WalletPayInvoice>

    // GETTERS
    @Headers(http_lightning_content_type)
    @GET(url_wallet_balance)
    suspend fun getBalance(
        @Header("X-Api-Key") apiKey: String,
    ) : Response<WalletBalance>

    @Headers(http_lightning_content_type)
    @GET
    suspend fun getTransactions(
        @Header("X-Api-Key") apiKey: String,
        @Url url: String,
    ) : Response<ResponseBody>

    @Headers(http_lightning_content_type)
    @GET
    suspend fun checkInvoice(
        @Header("X-Api-Key") apiKey: String,
        @Url url: String,
    ) : Response<WalletCheckInvoice>

    companion object {
        operator fun invoke(
            networkConnectionInterceptor: NetworkConnectionInterceptor
        ) : LightningAPI {
            val moshi = Moshi.Builder()
                .add(KotlinJsonAdapterFactory())
                .build()

            val okHttpClient = OkHttpClient.Builder()
                .addInterceptor(networkConnectionInterceptor)
                .connectTimeout(15, TimeUnit.SECONDS)
                .readTimeout(15, TimeUnit.SECONDS)
                .writeTimeout(15, TimeUnit.SECONDS)
                .build()

            return Retrofit.Builder()
                .client(okHttpClient)
                .baseUrl(lightning_base_url)
                .addConverterFactory(MoshiConverterFactory.create(moshi))
                .build()
                .create(LightningAPI::class.java)
        }
    }
}
