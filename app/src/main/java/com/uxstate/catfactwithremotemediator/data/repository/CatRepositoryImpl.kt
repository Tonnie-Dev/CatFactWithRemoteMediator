package com.uxstate.catfactwithremotemediator.data.repository


import com.uxstate.catfactwithremotemediator.data.local.CatDatabase
import com.uxstate.catfactwithremotemediator.data.mapper.toModel
import com.uxstate.catfactwithremotemediator.data.remote.CatAPI
import com.uxstate.catfactwithremotemediator.domain.model.ApiResponse
import com.uxstate.catfactwithremotemediator.domain.model.Stats
import com.uxstate.catfactwithremotemediator.domain.repository.CatRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.combine
import javax.inject.Inject

class CatRepositoryImpl @Inject constructor(private val api: CatAPI, private val db: CatDatabase) :
    CatRepository {

    private val factsDao = db.factsDao
    private val keysDao = db.keysDao
    override suspend fun getCatFacts(page: Int): ApiResponse {
        return api.getCatFacts(page = page)
                .toModel()
    }

    override fun getStats(): Flow<Stats> {
        return keysDao.getKeyFlow()
                .combine(factsDao.getCount()) { key, count ->

                    Stats(
                            currentPage = key?.currentPage ?: 0,
                            lastPage = key?.lastPage ?: 0,
                            factsCount = count
                    )
                }
    }
}