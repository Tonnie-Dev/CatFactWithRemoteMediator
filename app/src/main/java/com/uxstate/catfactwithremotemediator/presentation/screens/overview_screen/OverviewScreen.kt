package com.uxstate.catfactwithremotemediator.presentation.screens.overview_screen

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.paging.compose.LazyPagingItems
import com.uxstate.catfactwithremotemediator.domain.model.CatFact
import com.uxstate.catfactwithremotemediator.presentation.screens.overview_screen.components.ErrorItem
import com.uxstate.catfactwithremotemediator.presentation.screens.overview_screen.components.LoadingItem
import com.uxstate.catfactwithremotemediator.presentation.screens.overview_screen.components.TopRow

@Composable
fun OverviewScreen(viewModel: CatViewModel = hiltViewModel()) {


    //collect paging data from viewModel

    //facts:LazyPagingItems<CatFact>
   // val facts = viewModel.pager.collectAsLazyPagingItems()

    //collect pages state
    val currentPage by viewModel.currentPage.collectAsState()
    val prevPage by viewModel.prevKey.collectAsState()
    val nextPage by viewModel.nextKey.collectAsState()

    Scaffold(topBar = {
        TopRow(
                modifier = Modifier.fillMaxWidth(),
                pos = currentPage,
                prev = prevPage,
                next = nextPage
        ) {

        }
    }){values ->}
}


fun LazyListScope.loadingItemExtension() {

    item {

        LoadingItem(modifier = Modifier.fillMaxSize())
    }
}

fun LazyListScope.errorItemExtension() {

    item {

        ErrorItem()
    }
}

fun LazyListScope.catFactsItem(facts: LazyPagingItems<CatFact>) {


}
