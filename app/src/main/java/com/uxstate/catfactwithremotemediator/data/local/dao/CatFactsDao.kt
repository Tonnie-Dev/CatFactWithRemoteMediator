package com.uxstate.catfactwithremotemediator.data.local.dao

import androidx.paging.PagingSource
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.uxstate.catfactwithremotemediator.data.local.entity.CatFactEntity
import com.uxstate.catfactwithremotemediator.domain.model.CatFact
import kotlinx.coroutines.flow.Flow


@Dao
interface CatFactsDao {
    //count all rows

    @Query("SELECT COUNT(id) FROM cat_facts_table")
    fun getCount():Flow<Int>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertFacts(facts:List<CatFactEntity>)

    @Query("DELETE FROM cat_facts_table")
    suspend fun deleteFacts():Int

    @Query("SELECT * FROM cat_facts_table")
    fun getFactsPagingData():PagingSource<Int, CatFact>



}

