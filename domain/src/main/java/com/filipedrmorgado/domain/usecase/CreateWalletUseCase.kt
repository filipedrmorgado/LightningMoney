package com.filipedrmorgado.domain.usecase

import com.filipedrmorgado.domain.repository.UserWalletDataRepository
import com.filipedrmorgado.domain.utils.Result
import com.filipedrmorgado.domain.utils.SimpleSuccess

class CreateWalletUseCase(
    private val userWalletDataRepository: UserWalletDataRepository,
) {
    suspend operator fun invoke(walletName: String): Result {
        //userWalletDataRepository.createUserWallet(walletName)
        return SimpleSuccess
    }
}