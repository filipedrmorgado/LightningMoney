package com.filipedrmorgado.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.filipedrmorgado.data.database.entities.UserWalletEntity
import com.filipedrmorgado.data.database.dao.UserWalletDao

@Database(entities = [UserWalletEntity::class], version = 1)
abstract class UserWalletDatabase : RoomDatabase() {
    abstract fun userWalletDao(): UserWalletDao
}