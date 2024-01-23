package com.filipedrmorgado.data.repositories

import android.util.Log
import com.filipedrmorgado.data.database.Entities.UserWalletEntity
import com.filipedrmorgado.data.database.dao.UserWalletDao
import com.filipedrmorgado.data.mapper.mapFromEntity
import com.filipedrmorgado.data.mapper.mapToEntity
import com.filipedrmorgado.data.remote.SafeApiRequest
import com.filipedrmorgado.data.remote.api.LightningAPI
import com.filipedrmorgado.data.utils.createJsonRequestBody
import com.filipedrmorgado.domain.model.UserWallet
import com.filipedrmorgado.domain.repository.UserWalletDataRepository

/**
 * Repository expected to deal with user wallet data
 */
class UserWalletDataRepositoryImpl(
    private val userWalletDao: UserWalletDao,
    private val lightningAPI: LightningAPI,
    //private val defaultDispatcher: CoroutineDispatcher = Dispatchers.IO,
) : UserWalletDataRepository, SafeApiRequest() {


    init {
        //todo obtain key to sign requests to API, or, find a way to do it any other way.

    }

    /**
     * To create a LNbits account there is a need to:
     * - First: create an account
     * - Second: create a wallet in the account just created
     *
     * @return `true` if created with success, `false` otherwise
     */
    suspend fun createUserWallet(walletName: String) {

        //todo wallet creation, create account, then wallet.
        /*val result = lightningAPI.createWallet(

        )*/

        val walletCreationResponse = apiRequest {
            lightningAPI.createWallet(
            createJsonRequestBody("name" to walletName))
        }
        Log.d(Log.DEBUG.toString(),"walletCreationResponse=$walletCreationResponse")
    }


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