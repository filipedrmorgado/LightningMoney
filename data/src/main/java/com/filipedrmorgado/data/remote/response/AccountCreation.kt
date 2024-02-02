package com.filipedrmorgado.data.remote.response

import com.squareup.moshi.Json

/**
 * Represents the response data structure for account creation.
 *
 * @property walletID The unique identifier for the user's wallet.
 * @property walletName The name assigned to the user's wallet.
 * @property user The user associated with this wallet.
 * @property adminKey The administrative key associated with the user's wallet.
 * @property invoiceKey The invoice key associated with the user's wallet.
 * @property currency The currency type used in the wallet. Can be null if not specified.
 * @property balanceMsat The balance in milli-satoshis (msat) in the user's wallet.
 * @property deleted A flag indicating whether the wallet has been marked as deleted.
 * @property createdAt The timestamp representing the creation date of the user's wallet.
 * @property updatedAt The timestamp representing the last update date of the user's wallet.
 */
data class AccountCreation(
    @Json(name = "id")
    val walletID: String,
    @Json(name = "name")
    val walletName: String,
    @Json(name = "user")
    val user: String,
    @Json(name = "adminkey")
    val adminKey: String,
    @Json(name = "inkey")
    val invoiceKey: String,
    @Json(name = "currency")
    val currency: String?,
    @Json(name = "balance_msat")
    val balanceMsat: Long,
    @Json(name = "deleted")
    val deleted: Boolean,
    @Json(name = "created_at")
    val createdAt: Long,
    @Json(name = "updated_at")
    val updatedAt: Long
)
