package com.filipedrmorgado.lightningmoney.ui.ftu.viewmodel

import android.util.Log
import androidx.lifecycle.viewModelScope
import com.filipedrmorgado.domain.usecase.CreateWalletUseCase
import com.filipedrmorgado.domain.usecase.HasWalletBeenCreatedUseCase
import com.filipedrmorgado.domain.utils.Error
import com.filipedrmorgado.domain.utils.SimpleSuccess
import com.filipedrmorgado.domain.utils.Success
import com.filipedrmorgado.lightningmoney.ui.BaseViewModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class FtuViewModel(
    private val createWalletUseCase: CreateWalletUseCase,
    private val hasWalletBeenCreatedUseCase: HasWalletBeenCreatedUseCase,
    private val defaultDispatcher: CoroutineDispatcher = Dispatchers.IO,
) : BaseViewModel() {

    private val _walletCreationState = MutableStateFlow(WalletCreationState.NotStarted)
    val walletCreationState: StateFlow<WalletCreationState> = _walletCreationState.asStateFlow()

    /**
     * Will do the necessary checks for the wallet name and create it if everything is in accordance.
     *
     * @return `true` if created with success, `false` otherwise
     */
    fun createWallet(walletName: String) = viewModelScope.launch(Dispatchers.Main) {
        _walletCreationState.value = WalletCreationState.Loading
        val walletCreationResult = createWalletUseCase.invoke(walletName)
        Log.d("FtuViewModel","createWallet.: walletCreationResult=$walletCreationResult")
        when(walletCreationResult) {
            is Error ->  _walletCreationState.value = WalletCreationState.Error
            SimpleSuccess, is Success<*> -> _walletCreationState.value = WalletCreationState.Success
        }
    }

    suspend fun hasWalletBeenCreated(): Boolean {
        val hasWalletBeenCreatedUseCase = hasWalletBeenCreatedUseCase()
        Log.d("FtuViewModel","createWallet.: hasWalletBeenCreatedUseCase=$hasWalletBeenCreatedUseCase")
        return hasWalletBeenCreatedUseCase
    }

}