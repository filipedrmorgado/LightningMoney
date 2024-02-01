package com.filipedrmorgado.domain.usecase

import com.filipedrmorgado.domain.repository.FtuRepository
import com.filipedrmorgado.domain.utils.Result

/**
 * Use case for creating a new user wallet.
 *
 * @param ftuRepository The repository responsible for managing the first-time user (FTU) process.
 */
class CreateWalletUseCase(
    private val ftuRepository: FtuRepository,
) {
    /**
     * Invokes the use case to create a new user wallet.
     *
     * @param walletName The name to be assigned to the new user wallet.
     * @return A [Result] indicating the success or failure of the wallet creation.
     */
    suspend operator fun invoke(walletName: String): Result {
        return ftuRepository.createUserWallet(walletName)
    }
}