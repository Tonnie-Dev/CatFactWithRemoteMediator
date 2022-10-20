package com.uxstate.catfactwithremotemediator.presentation.screens.overview_screen

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.material.FabPosition
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.paging.LoadState
import androidx.paging.compose.LazyPagingItems
import androidx.paging.compose.collectAsLazyPagingItems
import androidx.paging.compose.items
import com.uxstate.catfactwithremotemediator.domain.model.CatFact
import com.uxstate.catfactwithremotemediator.presentation.screens.overview_screen.components.*

@Composable
fun OverviewScreen(viewModel: CatViewModel = hiltViewModel()) {


    //collect paging data from viewModel

    //facts:LazyPagingItems<CatFact>
    val facts = viewModel.pager.collectAsLazyPagingItems()

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
    },

            floatingActionButton = {FabButton {}},
            floatingActionButtonPosition = FabPosition.Center,
            content = { values ->

        LazyColumn(contentPadding = values, content = {

            //Refresh - PagingData content being refreshed
            when (facts.loadState.refresh) {
                is LoadState.Loading -> loadingItemExtension()

                //// display the items only when loadState.refresh is not loading
                is LoadState.NotLoading ->catFactsItem(facts)
                is LoadState.Error -> errorItemExtension()
            }

            //Prepend - Load at the start of a Paging Data
            when (facts.loadState.prepend) {
                is LoadState.Loading -> loadingItemExtension()
                is LoadState.NotLoading -> Unit
                is LoadState.Error -> errorItemExtension()
            }

            //Append -  Load at the end of a PagingData
            when (facts.loadState.append) {
                is LoadState.Loading -> loadingItemExtension()
                is LoadState.NotLoading -> Unit
                is LoadState.Error -> errorItemExtension()


        }})





    }
)}


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

   items(facts) { fact ->

    fact?.let { 
        
        FactRow(fact = it.fact)
    }
        
    }

}
