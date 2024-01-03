package com.filipedrmorgado.data.remote.response

import com.squareup.moshi.Json

/**
 * Represents information about a wallet.
 * @property user The user associated with the wallet.
 * @property walletID The ID of the wallet.
 * @property adminKey The admin key of the wallet.
 * @property invoiceKey The invoice key of the wallet.
 * @property walletName The name of the wallet.
 */
data class WalletInfo(
    @Json(name = "user")
    val user: String?,
    @Json(name = "id")
    val walletID: String?,
    @Json(name = "adminkey")
    val adminKey: String?,
    @Json(name = "inkey")
    val invoiceKey: String?,
    @Json(name = "name")
    val walletName: String?
)

/**
 * Details about wallet creation.
 * @property wallets List of wallet information.
 */
data class WalletCreationDetails(
    @Json(name = "wallets")
    val wallets: List<WalletInfo>?
)
