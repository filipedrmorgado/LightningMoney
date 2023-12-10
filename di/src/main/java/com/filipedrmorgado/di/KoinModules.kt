package com.filipedrmorgado.di

import androidx.room.Room
import com.filipedrmorgado.data.database.UserWalletDatabase
import com.filipedrmorgado.data.repositories.UserWalletDataRepositoryImpl
import com.filipedrmorgado.domain.repository.UserWalletDataRepository
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module

val repositoriesModule = module {
    single<UserWalletDataRepository> { UserWalletDataRepositoryImpl(get()) }
}

val databaseModule = module {
    single {
        Room.databaseBuilder(
            androidApplication(),
            UserWalletDatabase::class.java,
            "my_database"
        ).build()
    }
}