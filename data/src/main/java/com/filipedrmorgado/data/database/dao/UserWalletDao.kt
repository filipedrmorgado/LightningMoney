package com.filipedrmorgado.data.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.filipedrmorgado.data.database.entities.UserWalletEntity

/**
 * Data Access Object (DAO) interface for managing user wallet data in the Room database.
 */
@Dao
interface UserWalletDao {

    /**
     * Insert or replace the user wallet information in the database.
     *
     * @param userWalletEntity The [UserWalletEntity] to be inserted or replaced.
     */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertUserWallet(userWalletEntity: UserWalletEntity)

    /**
     * Retrieve the user wallet information from the database.
     *
     * @return The [UserWalletEntity] representing the user's wallet, or null if not found.
     */
    @Query("SELECT * FROM user_wallet LIMIT 1")
    fun getUserWallet(): UserWalletEntity?

    /**
     * Delete the user wallet information from the database.
     */
    @Query("DELETE FROM user_wallet WHERE id = 1")
    suspend fun deleteUserWallet()
}
