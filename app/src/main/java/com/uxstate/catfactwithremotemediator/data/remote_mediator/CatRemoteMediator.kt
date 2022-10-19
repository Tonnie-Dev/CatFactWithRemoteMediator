package com.uxstate.catfactwithremotemediator.data.remote_mediator

import androidx.paging.ExperimentalPagingApi
import androidx.paging.LoadType
import androidx.paging.PagingState
import androidx.paging.RemoteMediator
import com.uxstate.catfactwithremotemediator.data.local.CatDatabase
import com.uxstate.catfactwithremotemediator.data.remote.CatAPI
import com.uxstate.catfactwithremotemediator.domain.model.CatFact
import javax.inject.Inject

@OptIn(ExperimentalPagingApi::class)
class CatRemoteMediator @Inject constructor(private val api: CatAPI, private val db:CatDatabase) :
    RemoteMediator<Int, CatFact>() {
    override suspend fun load(
        loadType: LoadType,
        state: PagingState<Int, CatFact>
    ): MediatorResult {
        TODO("Not yet implemented")
    }
}