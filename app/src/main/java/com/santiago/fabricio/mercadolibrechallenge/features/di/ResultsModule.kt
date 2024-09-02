package com.santiago.fabricio.mercadolibrechallenge.features.di

import com.santiago.fabricio.mercadolibrechallenge.core.data.remote.service.ResultsService
import com.santiago.fabricio.mercadolibrechallenge.core.data.remote.service.util.SafeApiCaller
import com.santiago.fabricio.mercadolibrechallenge.features.data.repository.ResultsRepositoryImpl
import com.santiago.fabricio.mercadolibrechallenge.features.data.source.ResultsRemoteDataSourceImpl
import com.santiago.fabricio.mercadolibrechallenge.features.domain.repository.ResultsRepository
import com.santiago.fabricio.mercadolibrechallenge.features.domain.source.ResultsRemoteDataSource
import com.santiago.fabricio.mercadolibrechallenge.features.domain.usecase.ResultsUseCase
import com.santiago.fabricio.mercadolibrechallenge.features.domain.usecase.ResultsUseCaseImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ResultsModule {

    @Provides
    @Singleton
    fun provideResultsRemoteDataSource(
        service: ResultsService,
        safeApiCaller: SafeApiCaller
    ): ResultsRemoteDataSource {
        return ResultsRemoteDataSourceImpl(service = service, safeApiCaller = safeApiCaller)
    }

    @Provides
    @Singleton
    fun provideResultsRepository(remoteDataSource: ResultsRemoteDataSource): ResultsRepository {
        return ResultsRepositoryImpl(remoteDataSource = remoteDataSource)
    }

    @Provides
    @Singleton
    fun provideResultsUseCase(repository: ResultsRepository): ResultsUseCase {
        return ResultsUseCaseImpl(repository = repository)
    }
}