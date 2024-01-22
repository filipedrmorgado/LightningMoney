package com.filipedrmorgado.data.utils

import okhttp3.MediaType
import okhttp3.RequestBody.Companion.toRequestBody
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.RequestBody
import org.json.JSONObject

// Retrofit strings
// Lightning Network Calls
const val active_connection = "Make sure you have an active data connection"
const val lightning_base_url = "https://legend.lnbits.com/"

// Account creation requires 2 API requests: account creation and then wallet creation.
const val url_create_account = "api/v1/account"
const val url_create_wallet = "/api/v1/wallet"

//const val url_create_wallet = "usermanager/api/v1/users"
const val url_wallet_balance = "api/v1/wallet"
const val url_wallet_transactions = "usermanager/api/v1/transactions/"
const val url_create_check_pay_invoice = "api/v1/payments"
const val url_decode_invoice = "api/v1/payments/decode"
const val url_import_wallet = "usermanager/api/v1/wallets/"

// HTTP Calls
const val http_lightning_content_type = "Content-Type: application/json"

// JSON support
const val json_request_body = "application/json; charset=utf-8"

fun createJsonRequestBody(vararg params: Pair<String, String>): RequestBody {
    val json = JSONObject(mapOf(*params)).toString()
    val mediaType: MediaType? = "application/json".toMediaTypeOrNull()
    return json.toRequestBody(mediaType)
}
