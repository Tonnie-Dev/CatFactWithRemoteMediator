package com.uxstate.catfactwithremotemediator.data.mapper

import com.uxstate.catfactwithremotemediator.data.local.entity.CatFactEntity
import com.uxstate.catfactwithremotemediator.data.remote.dto.ApiResponseDTO
import com.uxstate.catfactwithremotemediator.data.remote.dto.CatFactDTO
import com.uxstate.catfactwithremotemediator.domain.model.ApiResponse
import com.uxstate.catfactwithremotemediator.domain.model.CatFact


//fact from dto to model
fun CatFactDTO.toModel(): CatFact {

    return CatFact(fact = this.fact, length = this.length)
}

//fact from model to dto
fun CatFact.toDto(): CatFactDTO {

    return CatFactDTO(fact = this.fact, length = this.length)
}

//CatFact -model to entity
fun CatFact.toEntity(): CatFactEntity {

    return CatFactEntity(id = this.id, fact = this.fact, length = this.length)
}

//response from dto to model
fun ApiResponseDTO.toModel(): ApiResponse {

    return ApiResponse(
            data = this.data.map { it.toModel() },
            currentPage = this.currentPage,
            lastPage = this.lastPage
    )
}

//CatFactDTO to entity

/*
fun CatFactDTO.toEntity(): CatFactEntity {

    return CatFactEntity(
            id = this.,
            fact = this.fact,
            length = this.length
    )
}*/
