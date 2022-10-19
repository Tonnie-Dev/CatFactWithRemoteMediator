package com.uxstate.catfactwithremotemediator.domain.model

data class ApiResponse(val data:List<CatFact>, val currentPage:Int, val lastPage:Int)
