package com.filipedrmorgado.domain.repository

import com.filipedrmorgado.domain.model.UserWallet

/**
 * Repository interface for managing user wallet data.
 */
interface UserWalletDataRepository {

    /**
     * Cache user wallet data.
     *
     * @return The [UserWallet] domain model representing the user's wallet.
     */
    suspend fun cacheUserWalletData(): UserWallet?

    /**
     * Get the administrative key associated with the user's wallet.
     *
     * @return The administrative key as a String.
     */
    suspend fun getAdminKey(): String?

    /**
     * Retrieve the user wallet information.
     *
     * @return The [UserWallet] domain model representing the user's wallet.
     */
    suspend fun getUserWallet(): UserWallet?

    /**
     * Insert the user wallet information into the database.
     *
     * @param userWallet The [UserWalletEntity] entity to be inserted.
     */
    suspend fun insertUserWallet(userWallet: UserWallet)

    /**
     * Delete the user wallet information from the database.
     */
    suspend fun deleteUserWallet()
}