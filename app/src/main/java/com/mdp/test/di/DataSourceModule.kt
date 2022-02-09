package com.mdp.test.di

import com.mdp.test.data.remote.api.WebService
import com.mdp.test.data.remote.user.UserRemoteDataSource
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataSourceModule {

    @Singleton
    @Provides
    fun provideUserRemoteDataSource(webService: WebService) = UserRemoteDataSource(webService)
}