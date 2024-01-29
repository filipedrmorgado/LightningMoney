package com.filipedrmorgado.domain.repository

import com.filipedrmorgado.domain.model.UserWallet

interface UserWalletDataRepository {


    suspend fun setAdminKey(createdAdminKey: String)

    suspend fun cacheAdminKey()

    suspend fun getAdminKey(): String

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