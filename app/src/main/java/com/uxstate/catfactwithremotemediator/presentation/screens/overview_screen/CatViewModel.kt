package com.uxstate.catfactwithremotemediator.presentation.screens.overview_screen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.ExperimentalPagingApi
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.cachedIn
import com.uxstate.catfactwithremotemediator.data.local.CatDatabase
import com.uxstate.catfactwithremotemediator.data.remote_mediator.CatRemoteMediator
import com.uxstate.catfactwithremotemediator.domain.model.Stats
import com.uxstate.catfactwithremotemediator.domain.repository.CatRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CatViewModel @Inject constructor(
    private val repository: CatRepository,
    mediator: CatRemoteMediator,
    private val db: CatDatabase
) : ViewModel() {

 private val _stats = MutableStateFlow(Stats(0,0,0))
    val stats = _stats.asStateFlow()

    init {

        viewModelScope.launch {

            repository.getStats().collect{

                _stats.emit(it)
            }
        }
    }

    @OptIn(ExperimentalPagingApi::class)
    val pager = Pager(
            config = PagingConfig(pageSize = 5),
            remoteMediator = mediator,
            pagingSourceFactory = { db.factsDao.getFactsPagingData() }).flow.cachedIn(viewModelScope)
}