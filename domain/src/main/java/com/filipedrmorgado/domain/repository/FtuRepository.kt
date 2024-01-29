package com.filipedrmorgado.domain.repository

import com.filipedrmorgado.domain.utils.Result

interface FtuRepository {
    suspend fun createUserWallet(walletName: String): Result
}