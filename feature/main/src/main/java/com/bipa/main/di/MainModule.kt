package com.bipa.main.di

import com.bipa.main.data.api.MainApi
import com.bipa.main.data.datasource.MainDataSource
import com.bipa.main.data.mapper.NodeMapper
import com.bipa.main.data.repository.MainRepositoryImpl
import com.bipa.main.domain.repository.MainRepository
import com.bipa.network.data.datasource.NetworkDataSource
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import retrofit2.Retrofit

@Module
@InstallIn(ViewModelComponent::class)
object MainModule {
    @Provides
    fun provideMainApi(retrofit: Retrofit): MainApi =
        retrofit.create(MainApi::class.java)

    @Provides
    fun provideMainDataSource(
        networkDataSource: NetworkDataSource,
        api: MainApi
    ): MainDataSource {
        return MainDataSource(api, networkDataSource)
    }

    @Provides
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
