package com.uxstate.catfacts.presentation.screens.overview_screen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.cachedIn
import com.uxstate.catfacts.data.paging_source.CatPagingSource
import com.uxstate.catfacts.domain.repository.CatRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class CatViewModel @Inject constructor(private val repository: CatRepository) : ViewModel() {

    private val _currentPage = MutableStateFlow(0)
    val currentPage = _currentPage.asStateFlow()

    private val _prevKey = MutableStateFlow<Int?>(null)
    val prevKey = _prevKey.asStateFlow()

    private val _nextKey = MutableStateFlow<Int?>(null)
    val nextKey = _nextKey.asStateFlow()

    /*Pager is responsible for incrementally pulling chunks of data
    from the PagingSource as requested by the UI.*/


    //instantiate a Pager instance
    val pager =
        Pager(config = PagingConfig(pageSize = 1)) //1st Arg
        { CatPagingSource(repository){ position, prev, next->

            _currentPage.value = position
            _prevKey.value = prev
            _nextKey.value = next

        }



        } // 2nd Arg - PagingSource
                .flow                   //access flow property
                .cachedIn(viewModelScope)//cache loaded data in VM

}