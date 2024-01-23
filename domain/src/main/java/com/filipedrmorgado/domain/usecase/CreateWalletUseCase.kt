package com.filipedrmorgado.domain.usecase

import com.filipedrmorgado.domain.repository.UserWalletDataRepository

class CreateWalletUseCase(
    private val userWalletDataRepository: UserWalletDataRepository
) {
    suspend operator fun invoke(walletName: String) {
        //userWalletDataRepository.createUserWallet(walletName)
    }
}