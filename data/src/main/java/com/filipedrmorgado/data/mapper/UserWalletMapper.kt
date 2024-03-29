package com.filipedrmorgado.data.mapper

import com.filipedrmorgado.data.database.entities.UserWalletEntity
import com.filipedrmorgado.data.remote.response.AccountCreation
import com.filipedrmorgado.domain.model.UserWallet

/**
 * Mappers related to User wallet class to transform [UserWalletEntity] entities from the database to [UserWallet] domain models.
 */

/**
 * Map a [UserWalletEntity] entity to a [UserWallet] domain model.
 *
 * @return A [UserWallet] domain model.
 */
fun UserWalletEntity.mapFromEntity(): UserWallet {
    return UserWallet(
        walletId = this.walletId,
        adminKey = this.adminKey,
        invoiceKey = this.invoiceKey,
        walletName = this.walletName,
        user = this.user,
        currency = this.currency,
        balanceMsat = this.balanceMsat,
        deleted = this.deleted,
        createdAt = this.createdAt,
        updatedAt = this.updatedAt
    )
}

/**
 * Map a [UserWallet] entity to a [UserWalletEntity] domain model.
 *
 * @return A [UserWalletEntity] domain model.
 */
fun UserWallet.mapToEntity(): UserWalletEntity {
    return UserWalletEntity(
        id = 1, // We will always have only 1 wallet.
        walletId = this.walletId,
        adminKey = this.adminKey,
        invoiceKey = this.invoiceKey,
        walletName = this.walletName,
        user = this.user,
        currency = this.currency,
        balanceMsat = this.balanceMsat,
        deleted = this.deleted,
        createdAt = this.createdAt,
        updatedAt = this.updatedAt
    )
}

/**
 * Map an [AccountCreation] response to a [UserWallet] domain model.
 *
 * @return A [UserWallet] domain model.
 */
fun AccountCreation.mapToUserWallet() = UserWallet(
    walletId = this.walletID,
    adminKey = this.adminKey,
    invoiceKey = this.invoiceKey,
    walletName = this.walletName,
    user = this.user,
    currency = this.currency,
    balanceMsat = this.balanceMsat,
    deleted = this.deleted,
    createdAt = this.createdAt,
    updatedAt = this.updatedAt
)
