package com.uxstate.catfactwithremotemediator.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "remote_keys_table")
data class RemoteKeyEntity(
    @PrimaryKey
    val id: Int = 1,
    val currentPage: Int,
    val lastPage: Int
)
