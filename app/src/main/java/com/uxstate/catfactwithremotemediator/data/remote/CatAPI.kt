package com.uxstate.catfactwithremotemediator.data.remote


import com.uxstate.catfactwithremotemediator.data.remote.dto.ApiResponseDTO
import retrofit2.http.GET
import retrofit2.http.Query

interface CatAPI {

    @GET("/facts")
    suspend fun getCatFacts(@Query("page") page:Int): ApiResponseDTO

    companion object{

        const val BASE_URL ="https://catfact.ninja"
    }
}