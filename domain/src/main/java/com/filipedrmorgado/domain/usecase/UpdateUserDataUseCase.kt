package com.filipedrmorgado.domain.usecase

import com.filipedrmorgado.domain.repository.UserWalletDataRepository

/**
 * Use case for updating user data.
 *
 * @param userWalletDataRepository The repository responsible for managing user wallet data.
 */
class UpdateUserDataUseCase(
    private val userWalletDataRepository: UserWalletDataRepository,
) {
    /**
     * Invokes the use case to update user data by caching user wallet information.
     */
    suspend operator fun invoke() = userWalletDataRepository.cacheUserWalletData()
}