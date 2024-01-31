package com.filipedrmorgado.data.repositories

import android.util.Log
import com.filipedrmorgado.data.database.dao.UserWalletDao
import com.filipedrmorgado.data.database.entities.UserWalletEntity
import com.filipedrmorgado.data.mapper.mapFromEntity
import com.filipedrmorgado.data.mapper.mapToEntity
import com.filipedrmorgado.data.remote.SafeApiRequest
import com.filipedrmorgado.domain.model.UserWallet
import com.filipedrmorgado.domain.repository.UserWalletDataRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

/**
 * Repository expected to deal with user wallet data
 */
class UserWalletDataRepositoryImpl(
    private val userWalletDao: UserWalletDao,
    private val defaultDispatcher: CoroutineDispatcher = Dispatchers.IO,
) : UserWalletDataRepository, SafeApiRequest() {

    // Stored user wallet data up to date
    private var userWalletData: UserWallet? = null

    override suspend fun cacheUserWalletData() = withContext(defaultDispatcher) {
        val storedUserData = getUserWallet()
        Log.d("UserWalletDataRepositoryImpl","Cached user wallet data.")
        if (storedUserData != null) {
            userWalletData = storedUserData
        }
        userWalletData
    }

    override suspend fun getAdminKey() = userWalletData?.adminKey

    /**
     * Retrieve the user wallet information.
     *
     * @return The [UserWallet] domain model representing the user's wallet.
     */
    override suspend fun getUserWallet(): UserWallet? = withContext(defaultDispatcher) {
        val roomUserWallet = userWalletDao.getUserWallet()
        Log.d("UserWalletDataRepositoryImpl","getUserWallet.: roomUserWallet=$roomUserWallet")
        return@withContext roomUserWallet?.mapFromEntity()
    }

    /**
     * Insert the user wallet information into the database.
     *
     * @param userWallet The [UserWalletEntity] entity to be inserted.
     */
    override suspend fun insertUserWallet(userWallet: UserWallet) = withContext(defaultDispatcher) {
        userWalletDao.insertUserWallet(userWallet.mapToEntity())
        userWalletData = userWallet
    }

    /**
     * Delete the user wallet information from the database.
     */
    override suspend fun deleteUserWallet() = withContext(defaultDispatcher) {
        userWalletDao.deleteUserWallet()
    }
}