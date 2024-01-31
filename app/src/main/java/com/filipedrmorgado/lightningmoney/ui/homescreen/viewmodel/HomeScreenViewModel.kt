package com.filipedrmorgado.lightningmoney.ui.homescreen.viewmodel

import androidx.lifecycle.viewModelScope
import com.filipedrmorgado.domain.model.UserWallet
import com.filipedrmorgado.domain.usecase.UpdateUserDataUseCase
import com.filipedrmorgado.lightningmoney.ui.BaseViewModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class HomeScreenViewModel(
    private val updateUserDataUseCase: UpdateUserDataUseCase,
    defaultDispatcher: CoroutineDispatcher = Dispatchers.IO,
): BaseViewModel() {

    private val _userWalletData = MutableStateFlow<UserWallet?>(null)
    val userWalletData = _userWalletData.asStateFlow()

    init {
        //todo set homscreen values, obtained from the wallet.
        viewModelScope.launch(defaultDispatcher){
            // Caches the adminKey to be used in lightningAPI requests
            _userWalletData.value = updateUserDataUseCase()
        }
    }

}