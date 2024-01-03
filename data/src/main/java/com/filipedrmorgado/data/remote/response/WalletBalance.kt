package com.filipedrmorgado.data.remote.response

import com.squareup.moshi.Json

/**
 * Represents the balance of a wallet.
 * @property name The name of the wallet.
 * @property balance The balance of the wallet in mSats.
 */
data class WalletBalance(
    @Json(name = "name")
    val name: String?,
    @Json(name = "balance")
    val balance: Int?
)