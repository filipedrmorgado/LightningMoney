package com.filipedrmorgado.lightningmoney.ui.homescreen.viewmodel

import androidx.lifecycle.viewModelScope
import com.filipedrmorgado.domain.usecase.CacheUserDataUseCase
import com.filipedrmorgado.lightningmoney.ui.BaseViewModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class HomeScreenViewModel(
    private val cacheUserDataUseCase: CacheUserDataUseCase,
    defaultDispatcher: CoroutineDispatcher = Dispatchers.IO,
): BaseViewModel() {

    init {
        //todo set homscreen values, obtained from the wallet.
        viewModelScope.launch(defaultDispatcher){
            // Caches the adminKey to be used in lightningAPI requests
            cacheUserDataUseCase()
        }
    }

}