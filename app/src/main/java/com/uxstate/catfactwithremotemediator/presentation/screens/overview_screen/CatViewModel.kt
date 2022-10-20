package com.uxstate.catfactwithremotemediator.presentation.screens.overview_screen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.ExperimentalPagingApi
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.cachedIn
import com.uxstate.catfactwithremotemediator.data.local.CatDatabase
import com.uxstate.catfactwithremotemediator.data.remote_mediator.CatRemoteMediator
import com.uxstate.catfactwithremotemediator.domain.repository.CatRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class CatViewModel @Inject constructor(
    private val repository: CatRepository,
    private val mediator: CatRemoteMediator,
    val db: CatDatabase
) : ViewModel() {

    private val _currentPage = MutableStateFlow(0)
    val currentPage = _currentPage.asStateFlow()

    private val _prevKey = MutableStateFlow<Int?>(null)
    val prevKey = _prevKey.asStateFlow()

    private val _nextKey = MutableStateFlow<Int?>(null)
    val nextKey = _nextKey.asStateFlow()


    @OptIn(ExperimentalPagingApi::class)
    val pager = Pager(
            config = PagingConfig(pageSize = 1),
            remoteMediator = mediator,
            pagingSourceFactory = { db.factsDao.getFactsPagingData() }).flow.cachedIn(viewModelScope)
}