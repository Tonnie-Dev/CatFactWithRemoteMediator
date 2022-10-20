package com.uxstate.catfactwithremotemediator.data.local.entity

import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(tableName = "cat_facts_table",
        indices = [Index(
        value = ["fact"],
        unique = true
)]
)
data class CatFactEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int= 0,
    val fact: String,
    val length: Int
) {
}