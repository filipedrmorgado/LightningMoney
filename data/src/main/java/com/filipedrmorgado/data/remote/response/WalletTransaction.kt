package com.filipedrmorgado.data.remote.response
import com.squareup.moshi.Json

/**
 * Represents a transaction.
 * @property pending Indicates whether the transaction is pending.
 * @property amount The amount in mSats.
 * @property updatedAmount The updated amount as a floating-point value.
 * @property time The timestamp of the transaction.
 * @property date The formatted date of the transaction.
 * @property fee The fee associated with the transaction.
 * @property memo A memo associated with the transaction.
 * @property bolt11 The Bolt11 string of the transaction.
 * @property payment_hash The payment hash of the transaction.
 * @property wallet_id The ID of the wallet associated with the transaction.
 */
data class Transaction(
    @Json(name = "pending")
    val pending: Boolean?,
    @Json(name = "amount")
    var amount: Int?,
    var updatedAmount: Float?,
    @Json(name = "time")
    var time: Int?,
    var date: String?,
    @Json(name = "fee")
    val fee: Int?,
    @Json(name = "memo")
    val memo: String?,
    @Json(name = "bolt11")
    val bolt11: String?,
    @Json(name = "payment_hash")
    val payment_hash: String?,
    @Json(name = "wallet_id")
    val wallet_id: String?
)
