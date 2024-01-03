package com.filipedrmorgado.data.remote.response

import com.squareup.moshi.Json

/**
 * Represents the decoded information of an invoice.
 * @property payment_hash The payment hash of the invoice.
 * @property amount_msat The amount in milliSats.
 * @property description The description of the invoice.
 * @property date The timestamp of the invoice.
 * @property expiry The expiry time of the invoice.
 * @property message A message associated with the invoice.
 */
data class WalletDecodeInvoice(
    @Json(name = "payment_hash")
    val payment_hash: String?,
    @Json(name = "amount_msat")
    val amount_msat: Int?,
    @Json(name = "description")
    val description: String?,
    @Json(name = "date")
    val date: Int?,
    @Json(name = "expiry")
    val expiry: Int?,
    @Json(name = "message")
    val message: String?
)