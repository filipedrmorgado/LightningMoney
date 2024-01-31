package com.filipedrmorgado.domain.usecase

import com.filipedrmorgado.domain.repository.UserWalletDataRepository

class UpdateUserDataUseCase(
    private val userWalletDataRepository: UserWalletDataRepository,
) {
    suspend operator fun invoke() = userWalletDataRepository.cacheUserWalletData()
}