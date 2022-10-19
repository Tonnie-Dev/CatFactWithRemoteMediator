package com.uxstate.catfactwithremotemediator.data.repository


import com.uxstate.catfactwithremotemediator.data.mapper.toModel
import com.uxstate.catfactwithremotemediator.domain.model.ApiResponse
import com.uxstate.catfactwithremotemediator.domain.repository.CatRepository
import com.uxstate.catfactwithremotemediator.data.remote.CatAPI
import javax.inject.Inject

class CatRepositoryImpl @Inject constructor(private val api: CatAPI) :CatRepository{


    override suspend fun getCatFacts(page:Int): ApiResponse {
        return api.getCatFacts(page = page).toModel()
    }
}