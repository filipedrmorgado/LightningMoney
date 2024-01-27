package com.filipedrmorgado.domain.usecase

import com.filipedrmorgado.domain.repository.FtuRepository
import com.filipedrmorgado.domain.utils.Result
import com.filipedrmorgado.domain.utils.SimpleSuccess

class CreateWalletUseCase(
    private val ftuRepository: FtuRepository,
) {
    suspend operator fun invoke(walletName: String): Result {
        ftuRepository.createUserWallet(walletName)
        return SimpleSuccess
    }
}