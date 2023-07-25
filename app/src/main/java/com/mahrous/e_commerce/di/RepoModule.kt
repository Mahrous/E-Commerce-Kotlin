package com.mahrous.e_commerce.di

import com.mahrous.data.apiservice.ApiService
import com.mahrous.data.repo.HomeRepoImp
import com.mahrous.domain.repo.HomeRepo
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object RepoModule {

    @Provides
    fun provideRepo(apiService: ApiService): HomeRepo {
        return HomeRepoImp(apiService)
    }
}