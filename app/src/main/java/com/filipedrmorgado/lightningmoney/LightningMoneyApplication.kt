package com.filipedrmorgado.lightningmoney

import android.app.Application
import com.filipedrmorgado.di.databaseModule
import com.filipedrmorgado.di.repositoriesModule
import com.filipedrmorgado.lightningmoney.di.useCasesModule
import com.filipedrmorgado.lightningmoney.di.viewModelsModule
import org.koin.core.context.startKoin

class LightningMoneyApplication: Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            modules(listOf(databaseModule, repositoriesModule, viewModelsModule, useCasesModule))
        }
    }
}