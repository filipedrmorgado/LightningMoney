package com.filipedrmorgado.data.remote.response

import com.squareup.moshi.Json

/**
 * Represents the response for checking an invoice status.
 * @property paid Indicates whether the invoice has been paid.
 * @property details Additional details about the checked invoice.
 */
data class WalletCheckInvoice(
    @Json(name = "paid")
    val paid: Boolean?,
    @Json(name = "details")
    val details: WalletCheckInvoiceDetails?
)

/**
 * Details about a checked invoice.
 * @property pending The pending status of the invoice.
 * @property amount The amount in mSats.
 * @property fee The fee associated with the invoice.
 * @property memo A memo associated with the invoice.
 * @property time The timestamp of the invoice.
 * @property bolt11 The Bolt11 string of the invoice.
 * @property payment_hash The payment hash of the invoice.
 */
data class WalletCheckInvoiceDetails(
    @Json(name = "pending")
    val pending: String?,
    @Json(name = "amount")
    val amount: Int?,
    @Json(name = "fee")
    val fee: Int?,
    @Json(name = "memo")
    val memo: String?,
    @Json(name = "time")
    val time: Int?,
    @Json(name = "bolt11")
    val bolt11: String?,
    @Json(name = "payment_hash")
    val payment_hash: String?
)