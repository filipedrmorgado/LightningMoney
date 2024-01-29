package com.filipedrmorgado.domain.model

/**
 * Represents user wallet information, including wallet ID, admin key, and invoice key.
 *
 * This class serves as a central entity used both in the core business logic (domain layer) and
 * the data layer (Room entities and DAOs). It can be shared across different layers of the application.
 *
 * @property walletId The unique identifier for the user's wallet.
 * @property adminKey The administrative key associated with the user's wallet.
 * @property invoiceKey The invoice key associated with the user's wallet.
 */
data class UserWallet(
    val walletId: String,
    val adminKey: String,
    val invoiceKey: String,
    val walletName: String,
    val user: String,
    val currency: String?,
    val balanceMsat: Long,
    val deleted: Boolean,
    val createdAt: Long,
    val updatedAt: Long
)
