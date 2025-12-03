package com.utdb.tt2.shared.util

import com.utdb.tt2.auth.data.remote.api.AuthApis
import com.utdb.tt2.auth.data.repository.AuthRepositoryImpl
import com.utdb.tt2.auth.domain.repository.AuthRepository
import com.utdb.tt2.shared.data.remote.api.ApiClient
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    fun provideApiClient(): ApiClient {
        return ApiClient()
    }

    @Provides
    fun provideApiService(apiClient: ApiClient): AuthApis {
        return AuthApis(apiClient)
    }

    @Provides
    fun provideAuthRepository(apiService: AuthApis): AuthRepository {
        return AuthRepositoryImpl(apiService)
    }
}
