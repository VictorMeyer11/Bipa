package com.clansoft.network.di

import com.clansoft.network.data.datasource.NetworkDataSource
import com.clansoft.network.data.datasource.NetworkDataSourceImpl
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
