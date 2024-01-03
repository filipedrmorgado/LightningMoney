package com.filipedrmorgado.data.remote.response

import com.squareup.moshi.Json

/**
 * Represents the response for paying an invoice.
 * @property payment_hash The payment hash of the paid invoice.
 * @property checking_id The checking ID associated with the payment.
 * @property detail Additional details about the payment.
 */
data class WalletPayInvoice(
    @Json(name = "payment_hash")
    val payment_hash: String?,
    @Json(name = "checking_id")
    val checking_id: String?,
    @Json(name = "detail")
    val detail: String?
)