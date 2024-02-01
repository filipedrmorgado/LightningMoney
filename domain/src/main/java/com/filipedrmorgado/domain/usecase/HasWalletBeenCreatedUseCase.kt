package com.filipedrmorgado.domain.usecase

import android.util.Log
import com.filipedrmorgado.domain.repository.UserWalletDataRepository

/**
 * Use case for checking if a user wallet has been created.
 *
 * @param userWalletDataRepository The repository responsible for managing user wallet data.
 */
class HasWalletBeenCreatedUseCase(
    private val userWalletDataRepository: UserWalletDataRepository,
) {
    /**
     * Invokes the use case to check if a user wallet has been created.
     *
     * @return `true` if a wallet has been created, `false` otherwise.
     */
    suspend operator fun invoke(): Boolean {
        val isWalletCreated = userWalletDataRepository.getUserWallet()
        Log.d("userWalletDataRepository", "invoke.: isWalletCreated=$isWalletCreated")
        return isWalletCreated != null
    }
}