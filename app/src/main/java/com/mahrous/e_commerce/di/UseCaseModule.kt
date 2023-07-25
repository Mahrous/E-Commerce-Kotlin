package com.mahrous.e_commerce.di

import com.mahrous.domain.repo.HomeRepo
import com.mahrous.domain.usecase.GetHome
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object UseCaseModule {
    @Provides
    fun provideUseCase(homeRepo: HomeRepo): GetHome{
        return GetHome(homeRepo)
    }
}