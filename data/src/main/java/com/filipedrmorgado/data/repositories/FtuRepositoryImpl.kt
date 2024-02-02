package com.filipedrmorgado.data.repositories

import android.util.Log
import com.filipedrmorgado.data.mapper.mapToUserWallet
import com.filipedrmorgado.data.remote.SafeApiRequest
import com.filipedrmorgado.data.remote.api.LightningAPI
import com.filipedrmorgado.data.utils.ApiException
import com.filipedrmorgado.data.utils.createJsonRequestBody
import com.filipedrmorgado.domain.repository.FtuRepository
import com.filipedrmorgado.domain.repository.UserWalletDataRepository
import com.filipedrmorgado.domain.utils.Error
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import com.filipedrmorgado.domain.utils.Result
import com.filipedrmorgado.domain.utils.Success

/**
 * Repository expected to deal with user wallet data
 *
 * @param userWalletDataRepository The repository responsible for managing user wallet data.
 * @param lightningAPI The Lightning API service for making API requests.
 * @param defaultDispatcher The coroutine dispatcher to be used for IO operations. Default is [Dispatchers.IO].
 */
class FtuRepositoryImpl(
    private val userWalletDataRepository: UserWalletDataRepository,
    private val lightningAPI: LightningAPI,
    private val defaultDispatcher: CoroutineDispatcher = Dispatchers.IO,
) : FtuRepository, SafeApiRequest() {

    /**
     * To create a LNbits account there is a need to:
     * - First: create an account
     * - Second: create a wallet in the account just created
     *
     * @return [Success] if created with success, [Error] otherwise
     */
    override suspend fun createUserWallet(walletName: String): Result = withContext(defaultDispatcher) {
        try {
            val accountCreationResponse = apiRequest {
                lightningAPI.createAccount(
                    createJsonRequestBody("name" to walletName))
            }

            val userWalletData = accountCreationResponse.mapToUserWallet()

            val walletCreationResponse = apiRequest {
                lightningAPI.createWallet(
                    apiKey = userWalletData.adminKey,
                    createJsonRequestBody("name" to walletName))
            }
            // Store the data in DB and caches it.
            userWalletDataRepository.insertUserWallet(userWalletData)
            Success(walletCreationResponse)
        } catch(apiException: ApiException) {
            Log.e("FtuRepositoryImpl","createUserWallet.: Error creating wallet.")
            return@withContext Error(apiException, "Error creating the wallet.")
        }
    }
}
