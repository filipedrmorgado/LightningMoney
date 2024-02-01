package com.filipedrmorgado.domain.repository

import com.filipedrmorgado.domain.utils.Result

/**
 * Repository interface for managing the first-time user (FTU) process.
 */
interface FtuRepository {

    /**
     * Create a user wallet with the given name.
     *
     * @param walletName The name to be assigned to the new user wallet.
     * @return A [Result] indicating the success or failure of the operation.
     */
    suspend fun createUserWallet(walletName: String): Result
}