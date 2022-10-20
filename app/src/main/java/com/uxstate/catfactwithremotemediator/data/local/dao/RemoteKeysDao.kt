package com.uxstate.catfactwithremotemediator.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.uxstate.catfactwithremotemediator.data.local.entity.RemoteKeyEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface RemoteKeysDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertKey(key: RemoteKeyEntity)

    @Query("SELECT * FROM remote_keys_table LIMIT 1")
    suspend fun getRemoteKey(): RemoteKeyEntity?

    @Query("DELETE FROM remote_keys_table")
    suspend fun deleteRemoteKeys(): Int

    @Query("SELECT * FROM remote_keys_table LIMIT 1")
    fun getKeyFlow(): Flow<RemoteKeyEntity?>
}