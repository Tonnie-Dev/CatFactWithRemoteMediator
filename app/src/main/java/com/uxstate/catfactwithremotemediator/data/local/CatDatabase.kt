package com.uxstate.catfactwithremotemediator.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.uxstate.catfactwithremotemediator.data.local.dao.CatFactsDao
import com.uxstate.catfactwithremotemediator.data.local.dao.RemoteKeysDao
import com.uxstate.catfactwithremotemediator.data.local.entity.CatFactEntity
import com.uxstate.catfactwithremotemediator.data.local.entity.RemoteKeyEntity

@Database(
        entities = [CatFactEntity::class, RemoteKeyEntity::class],
        version = 1,
        exportSchema = true
)
abstract class CatDatabase : RoomDatabase() {

    abstract val factsDao: CatFactsDao
    abstract val keysDao: RemoteKeysDao
}