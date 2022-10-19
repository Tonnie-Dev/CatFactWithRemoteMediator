package com.uxstate.catfactwithremotemediator.di

import android.content.Context
import androidx.room.Room
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import com.uxstate.catfactwithremotemediator.data.local.CatDatabase
import com.uxstate.catfactwithremotemediator.data.remote.CatAPI
import com.uxstate.catfactwithremotemediator.util.DATABASE_NAME
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.create
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideCatAPI(): CatAPI {

        val moshi = Moshi.Builder()
                .addLast(KotlinJsonAdapterFactory())
                .build()

        return Retrofit.Builder()
                .baseUrl(CatAPI.BASE_URL)
                .addConverterFactory(MoshiConverterFactory.create(moshi))
                .build()
                .create()
    }

    @Provides
    @Singleton
    fun provideCatDatabase(@ApplicationContext context: Context): CatDatabase {

        return Room.databaseBuilder(
                context,
                CatDatabase::class.java,
                DATABASE_NAME
        )
                .build()
    }
}