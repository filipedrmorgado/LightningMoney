package com.filipedrmorgado.domain.usecase

import android.util.Log
import com.filipedrmorgado.domain.repository.UserWalletDataRepository

class HasWalletBeenCreatedUseCase(
    private val userWalletDataRepository: UserWalletDataRepository,
) {
    suspend operator fun invoke(): Boolean {
        val isWalletCreated = userWalletDataRepository.getUserWallet()
        Log.d("userWalletDataRepository","invoke.: isWalletCreated=$isWalletCreated")
        return isWalletCreated != null
    }
}