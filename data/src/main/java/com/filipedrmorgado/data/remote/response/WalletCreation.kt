package com.filipedrmorgado.data.remote.response

import com.squareup.moshi.Json

data class WalletCreation(
    @Json(name = "id")
    val walletID: String?,
    @Json(name = "name")
    val walletName: String?,
    @Json(name = "user")
    val user: String?,
    @Json(name = "adminkey")
    val adminKey: String?,
    @Json(name = "inkey")
    val invoiceKey: String?,
    @Json(name = "currency")
    val currency: String?,
    @Json(name = "balance_msat")
    val balanceMsat: Long?,
    @Json(name = "deleted")
    val deleted: Boolean?
)
