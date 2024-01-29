package com.filipedrmorgado.domain.usecase

import com.filipedrmorgado.domain.repository.FtuRepository
import com.filipedrmorgado.domain.utils.Result

class CreateWalletUseCase(
    private val ftuRepository: FtuRepository,
) {
    suspend operator fun invoke(walletName: String): Result {
        return ftuRepository.createUserWallet(walletName)
    }
}