package com.filipedrmorgado.data.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.filipedrmorgado.data.database.entities.UserWalletEntity

@Dao
interface UserWalletDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertUserWallet(userWalletEntity: UserWalletEntity)

    @Query("SELECT * FROM user_wallet LIMIT 1")
    fun getUserWallet(): UserWalletEntity?

    @Query("DELETE FROM user_wallet WHERE id = 1")
    suspend fun deleteUserWallet()
}