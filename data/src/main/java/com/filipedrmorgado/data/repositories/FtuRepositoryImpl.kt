package com.filipedrmorgado.data.repositories

import android.util.Log
import com.filipedrmorgado.data.remote.SafeApiRequest
import com.filipedrmorgado.data.remote.api.LightningAPI
import com.filipedrmorgado.data.utils.createJsonRequestBody
import com.filipedrmorgado.domain.repository.FtuRepository
import com.filipedrmorgado.domain.repository.UserWalletDataRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers

/**
 * Repository expected to deal with user wallet data
 */
class FtuRepositoryImpl(
    private val userWalletDataRepository: UserWalletDataRepository,
    private val lightningAPI: LightningAPI,
    private val defaultDispatcher: CoroutineDispatcher = Dispatchers.IO,
) : FtuRepository, SafeApiRequest() {

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
    override suspend fun createUserWallet(walletName: String) {
        //todo wallet creation, create account, then wallet.

        val walletCreationResponse = apiRequest {
            lightningAPI.createAccount(
                createJsonRequestBody("name" to walletName))
        }
        Log.d("FtuRepositoryImpl","createUserWallet.: walletCreationResponse=$walletCreationResponse")
    }
}