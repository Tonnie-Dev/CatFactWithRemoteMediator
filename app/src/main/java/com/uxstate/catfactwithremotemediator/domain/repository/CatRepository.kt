package com.uxstate.catfacts.domain.repository

import com.uxstate.catfacts.domain.model.ApiResponse

interface CatRepository {


   suspend fun getCatFacts(page:Int):ApiResponse
}