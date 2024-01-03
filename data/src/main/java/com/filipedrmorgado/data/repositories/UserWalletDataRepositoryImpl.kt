package com.filipedrmorgado.data.repositories

import com.filipedrmorgado.data.database.Entities.UserWalletEntity
import com.filipedrmorgado.data.database.dao.UserWalletDao
import com.filipedrmorgado.data.mapper.mapFromEntity
import com.filipedrmorgado.data.mapper.mapToEntity
import com.filipedrmorgado.data.remote.api.LightningAPI
import com.filipedrmorgado.domain.model.UserWallet
import com.filipedrmorgado.domain.repository.UserWalletDataRepository

/**
 * Repository expected to deal with user wallet data
 */
class UserWalletDataRepositoryImpl(
    private val userWalletDao: UserWalletDao,
    private val lightningAPI: LightningAPI,
) : UserWalletDataRepository {


    /**
     * Retrieve the user wallet information.
     *
     * @return The [UserWallet] domain model representing the user's wallet.
     */
    override suspend fun getUserWallet(): UserWallet? {
        val roomUserWallet = userWalletDao.getUserWallet()
        return roomUserWallet?.mapFromEntity()
    }

    /**
     * Insert the user wallet information into the database.
     *
     * @param userWallet The [UserWalletEntity] entity to be inserted.
     */
    override suspend fun insertUserWallet(userWallet: UserWallet) {
        userWalletDao.insertUserWallet(userWallet.mapToEntity())
    }

    /**
     * Delete the user wallet information from the database.
     */
    override suspend fun deleteUserWallet() {
        userWalletDao.deleteUserWallet()
    }
}