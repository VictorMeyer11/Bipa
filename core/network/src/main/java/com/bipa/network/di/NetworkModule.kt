package com.bipa.network.di

import com.bipa.network.data.datasource.NetworkDataSource
import com.bipa.network.data.datasource.NetworkDataSourceImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class NetworkModule {
    @Binds
    abstract fun bindNetworkDataSource(networkDataSourceImpl: NetworkDataSourceImpl): NetworkDataSource
}
