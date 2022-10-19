package com.uxstate.catfactwithremotemediator.presentation.screens.overview_screen

import androidx.lifecycle.ViewModel
import com.uxstate.catfactwithremotemediator.domain.repository.CatRepository
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



}