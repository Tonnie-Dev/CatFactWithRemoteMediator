package com.uxstate.catfactwithremotemediator.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.uxstate.catfactwithremotemediator.data.local.dao.CatFactsDao
import com.uxstate.catfactwithremotemediator.data.local.dao.RemoteKeysDao
import com.uxstate.catfactwithremotemediator.data.local.entity.CatFactsEntity

@Database(entities = [CatFactsEntity::class], version = 1)
abstract class CatDatabase: RoomDatabase() {

    abstract val factsDao:CatFactsDao
    abstract val keysDao:RemoteKeysDao
}