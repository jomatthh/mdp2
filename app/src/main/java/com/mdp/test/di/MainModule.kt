package com.mdp.test.di

import com.mdp.test.data.repository.UserRepositoryImpl
import com.mdp.test.domain.repository.UserRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class MainModule {
    @Singleton
    @Binds
    abstract fun bindUserRepositoryImpl(impl: UserRepositoryImpl): UserRepository
}