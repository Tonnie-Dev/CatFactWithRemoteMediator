package com.uxstate.catfacts.di

import com.uxstate.catfacts.data.repository.CatRepositoryImpl
import com.uxstate.catfacts.domain.repository.CatRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {
    @Binds
    @Singleton
    abstract fun bindRepository(repositoryImpl: CatRepositoryImpl):CatRepository
}