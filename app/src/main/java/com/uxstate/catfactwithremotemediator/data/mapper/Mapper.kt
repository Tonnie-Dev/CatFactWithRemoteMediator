package com.uxstate.catfacts.data.mapper

import com.uxstate.catfacts.data.remote.dto.ApiResponseDTO
import com.uxstate.catfacts.data.remote.dto.CatFactDTO
import com.uxstate.catfacts.domain.model.ApiResponse
import com.uxstate.catfacts.domain.model.CatFact


//fact from dto to model
fun CatFactDTO.toModel(): CatFact {

    return CatFact(fact = this.fact, length = this.length)
}

//fact from model to dto
fun CatFact.toDto(): CatFactDTO {

    return CatFactDTO(fact = this.fact, length = this.length)
}

//response from dto to model
fun ApiResponseDTO.toModel(): ApiResponse {

    return ApiResponse(
            data = this.data.map { it.toModel() },
            currentPage = this.currentPage,
            lastPage = this.lastPage
    )
}

//response from model to dto