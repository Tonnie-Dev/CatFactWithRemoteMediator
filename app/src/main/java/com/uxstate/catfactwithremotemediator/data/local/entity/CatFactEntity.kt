package com.uxstate.catfactwithremotemediator.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class CatFactEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int? = null, val fact: String, val length: Int
) {
}