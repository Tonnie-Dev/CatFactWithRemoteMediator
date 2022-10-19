package com.uxstate.catfactwithremotemediator.domain.repository

import com.uxstate.catfactwithremotemediator.domain.model.ApiResponse

interface CatRepository {


   suspend fun getCatFacts(page:Int):ApiResponse
}