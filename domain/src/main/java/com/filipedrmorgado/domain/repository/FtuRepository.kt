package com.filipedrmorgado.domain.repository

interface FtuRepository {
    suspend fun createUserWallet(walletName: String)
}