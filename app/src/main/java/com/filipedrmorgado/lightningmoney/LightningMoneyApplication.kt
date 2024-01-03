package com.filipedrmorgado.lightningmoney

import android.app.Application
import com.filipedrmorgado.data.di.networkingModule
import com.filipedrmorgado.data.di.repositoriesModule
import com.filipedrmorgado.di.di.databaseModule
import com.filipedrmorgado.di.di.loggerModule
import com.filipedrmorgado.lightningmoney.di.useCasesModule
import com.filipedrmorgado.lightningmoney.di.viewModelsModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class LightningMoneyApplication: Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@LightningMoneyApplication)
            modules(listOf(databaseModule, repositoriesModule, networkingModule, viewModelsModule, useCasesModule, loggerModule))
        }
    }
}