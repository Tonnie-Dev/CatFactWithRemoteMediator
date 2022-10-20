package com.uxstate.catfactwithremotemediator.data.remote_mediator

import androidx.paging.ExperimentalPagingApi
import androidx.paging.LoadType
import androidx.paging.PagingState
import androidx.paging.RemoteMediator
import androidx.paging.RemoteMediator.InitializeAction.*
import androidx.room.withTransaction
import com.uxstate.catfactwithremotemediator.data.local.CatDatabase
import com.uxstate.catfactwithremotemediator.data.local.entity.RemoteKeyEntity
import com.uxstate.catfactwithremotemediator.data.mapper.toEntity
import com.uxstate.catfactwithremotemediator.domain.model.CatFact
import com.uxstate.catfactwithremotemediator.domain.repository.CatRepository
import com.uxstate.catfactwithremotemediator.util.Constants
import retrofit2.HttpException
import timber.log.Timber
import javax.inject.Inject

private const val TAG = "REMOTE_MEDIATOR"
private const val CAT_FACTS_STARTING_PAGE_INDEX = 1


@OptIn(ExperimentalPagingApi::class)
class CatRemoteMediator @Inject constructor(
    private val repository: CatRepository,
    private val db: CatDatabase
) : RemoteMediator<Int, CatFact>() {

    private val factsDao = db.factsDao
    private val keysDao = db.keysDao

    override suspend fun load(
        loadType: LoadType,
        state: PagingState<Int, CatFact>
    ): MediatorResult {

        //Determine which page to load from the network depending on the LoadType
        return try {

            val loadKey = when (loadType) {

                //is over enum is not permitted
                LoadType.REFRESH -> {

                    //clear all tables
                    factsDao.deleteFacts()
                    keysDao.deleteRemoteKeys()

                    //return fist page as the load key and trip
                   1

                }

                //short circuit
                LoadType.PREPEND -> return MediatorResult.Success(endOfPaginationReached = true)

                LoadType.APPEND -> {
//when we get here we already have some remote key saved
                    val remoteKey = keysDao.getRemoteKey()!!

                    Timber.i("The RemoteKey is $remoteKey")
                    if (remoteKey.currentPage == remoteKey.lastPage) {
                        return MediatorResult.Success(endOfPaginationReached = true)
                    }

                    //return current page + 1
                    remoteKey.currentPage.plus(1)
                }


            }
//appi response with availed load key
            val response = repository.getCatFacts(loadKey)
            db.withTransaction {

                keysDao.insertKey(
                        RemoteKeyEntity(
                                currentPage = response.currentPage,
                                lastPage = response.lastPage
                        )
                )
                factsDao.insertFacts(response.data.map { it.toEntity() })

            }
            MediatorResult.Success(endOfPaginationReached = false)


        } catch (e: HttpException) {

            MediatorResult.Error(e)
        } catch (e: Exception) {
            MediatorResult.Error(e)

        }


    }

    override suspend fun initialize(): InitializeAction {

        //retrieve the saved key from dao
        val remoteKey = keysDao.getRemoteKey()

        return if (remoteKey == null) LAUNCH_INITIAL_REFRESH else SKIP_INITIAL_REFRESH
    }
}



