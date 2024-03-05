package com.jyldyzferr.makeitsotodoapp.model.service.module

import com.jyldyzferr.makeitsotodoapp.model.service.AccountService
import com.jyldyzferr.makeitsotodoapp.model.service.impl.AccountServiceImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent


@Module
@InstallIn(SingletonComponent::class)
abstract class ServiceModule {
    @Binds
    abstract fun provideAccountService(impl: AccountServiceImpl): AccountService
}