package com.uxstate.catfactwithremotemediator.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.uxstate.catfactwithremotemediator.data.local.dao.CatDao
import com.uxstate.catfactwithremotemediator.data.local.dao.RemoteKeysDao
import com.uxstate.catfactwithremotemediator.data.local.entity.CatFactEntity

@Database(entities = [CatFactEntity::class], version = 1)
abstract class CatDatabase: RoomDatabase() {

    abstract val factsDao:CatDao
    abstract val keysDao:RemoteKeysDao
}