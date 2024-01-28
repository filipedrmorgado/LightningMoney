package com.filipedrmorgado.data.database.Entities

import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * Represents user wallet information for Room database, including wallet ID, admin key, and invoice key.
 *
 * This class is specifically annotated with [@Entity] for use with Room database. It is intended
 * for the data layer and should not be used directly in the core business logic.
 *
 * @property id The primary key for the database entry. It is set to a constant value indicating there
 *           should be only one row in the table.
 * @property walletId The unique identifier for the user's wallet.
 * @property adminKey The administrative key associated with the user's wallet.
 * @property invoiceKey The invoice key associated with the user's wallet.
 */
@Entity(tableName = "user_wallet")
data class UserWalletEntity(
    @PrimaryKey
    val id: Int = 1, // There should be only one wallet.
    val walletId: String,
    val adminKey: String,
    val invoiceKey: String,
    val walletName: String?,
    val user: String?,
    val currency: String?,
    val balanceMsat: Long?,
    val deleted: Boolean?,
    val createdAt: Long?,
    val updatedAt: Long?
)
