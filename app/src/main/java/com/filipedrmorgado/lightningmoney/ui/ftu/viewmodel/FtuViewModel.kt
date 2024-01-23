package com.filipedrmorgado.lightningmoney.ui.ftu.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.filipedrmorgado.domain.usecase.CreateWalletUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class FtuViewModel(
    private val createWalletUseCase: CreateWalletUseCase
) : ViewModel() {


    /**
     * Will do the necessary checks for the wallet name and create it if everything is in accordance.
     *
     * @return `true` if created with success, `false` otherwise
     */
    fun createWallet(walletName: String) {
        viewModelScope.launch(Dispatchers.IO) {
            createWalletUseCase.invoke(walletName)
        }
    }

}