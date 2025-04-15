package com.clansoft.main.di

import com.clansoft.main.data.api.MainApi
import com.clansoft.main.data.datasource.MainDataSource
import com.clansoft.main.data.mapper.NodeMapper
import com.clansoft.main.data.repository.MainRepositoryImpl
import com.clansoft.main.domain.repository.MainRepository
import com.clansoft.network.data.datasource.NetworkDataSource
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object MainModule {
    @Provides
    @Singleton
    fun provideMainApi(retrofit: Retrofit): MainApi =
        retrofit.create(MainApi::class.java)

    @Provides
    @Singleton
    fun provideMainDataSource(
        networkDataSource: NetworkDataSource,
        api: MainApi
    ): MainDataSource {
        return MainDataSource(api, networkDataSource)
    }

    @Provides
    @Singleton
    fun provideMainRepository(
        dataSource: MainDataSource,
        nodeMapper: NodeMapper
    ): MainRepository {
        return MainRepositoryImpl(
            dataSource = dataSource,
            nodeMapper = nodeMapper
        )
    }
}
