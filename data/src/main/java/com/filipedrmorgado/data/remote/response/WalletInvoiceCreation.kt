package com.filipedrmorgado.data.remote.response

import com.squareup.moshi.Json

/**
 * Represents the response for creating a wallet invoice.
 * @property payment_hash The payment hash of the invoice.
 * @property payment_request The payment request string.
 * @property checking_id The checking ID associated with the invoice.
 */
data class WalletInvoiceCreation(
    @Json(name = "payment_hash")
    val payment_hash: String?,
    @Json(name = "payment_request")
    val payment_request: String?,
    @Json(name = "checking_id")
    val checking_id: String?
)
