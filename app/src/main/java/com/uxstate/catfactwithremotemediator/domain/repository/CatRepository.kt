package com.uxstate.catfactwithremotemediator.domain.repository

import com.uxstate.catfactwithremotemediator.domain.model.ApiResponse
import com.uxstate.catfactwithremotemediator.domain.model.Stats
import kotlinx.coroutines.flow.Flow

interface CatRepository {


   suspend fun getCatFacts(page:Int):ApiResponse
   fun getStats():Flow<Stats>
}