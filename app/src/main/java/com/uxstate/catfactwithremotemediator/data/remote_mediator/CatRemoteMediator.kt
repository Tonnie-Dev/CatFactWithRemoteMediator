package com.uxstate.catfactwithremotemediator.data.remote_mediator

import androidx.paging.ExperimentalPagingApi
import androidx.paging.LoadType
import androidx.paging.PagingState
import androidx.paging.RemoteMediator
import androidx.room.withTransaction
import com.uxstate.catfactwithremotemediator.data.local.CatDatabase
import com.uxstate.catfactwithremotemediator.data.local.entity.RemoteKeyEntity
import com.uxstate.catfactwithremotemediator.data.mapper.toEntity
import com.uxstate.catfactwithremotemediator.data.remote.CatAPI
import com.uxstate.catfactwithremotemediator.domain.model.CatFact
import com.uxstate.catfactwithremotemediator.util.Constants
import retrofit2.HttpException
import javax.inject.Inject

private const val TAG = "REMOTE_MEDIATOR"
private const val CAT_FACTS_STARTING_PAGE_INDEX = 1


@OptIn(ExperimentalPagingApi::class)
class CatRemoteMediator @Inject constructor(
    private val api: CatAPI,
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

                    //return fist page as the load key
                    Constants.CAT_FACTS_STARTING_PAGE_INDEX
                }

                LoadType.PREPEND -> return MediatorResult.Success(endOfPaginationReached = true)

                LoadType.APPEND -> {

                    val remoteKey = keysDao.getRemoteKey()!!

                    if (remoteKey.currentPage == remoteKey.lastPage) {
                        return MediatorResult.Success(endOfPaginationReached = true)
                    }

                    remoteKey.currentPage.plus(1)
                }


            }

            val response = api.getCatFacts(loadKey)
            db.withTransaction {

                keysDao.insertKeys(
                        RemoteKeyEntity(
                                currentPage = response.currentPage,
                                lastPage = response.lastPage
                        )
                )

                factsDao.insertFacts(response.data.map { it.toEntity() })

            }

            MediatorResult.Success(endOfPaginationReached = false)


        }catch (e:HttpException){

            MediatorResult.Error(e)
        }
        catch (e:Exception  ){
            MediatorResult.Error(e)

        }


    }
}



