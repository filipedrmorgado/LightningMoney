package com.filipedrmorgado.di.di

import androidx.room.Room
import com.filipedrmorgado.data.database.UserWalletDatabase
import com.filipedrmorgado.data.database.dao.UserWalletDao
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module


val databaseModule = module {
    single {
        Room.databaseBuilder(
            androidContext(),
            UserWalletDatabase::class.java,
            "LightningMoneyDb"
        ).build()
    }

    single { provideUserWalletDao(get()) }

}

private fun provideUserWalletDao(userWalletDatabase: UserWalletDatabase): UserWalletDao {
    return userWalletDatabase.userWalletDao()
}