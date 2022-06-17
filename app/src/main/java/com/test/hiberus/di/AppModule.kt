package com.test.hiberus.di

import com.test.hiberus.data.repository.CardRepositoryImpl
import com.test.hiberus.data.source.remote.retrofit.API
import com.test.hiberus.domain.repository.CardRepository
import com.test.hiberus.utils.Constants
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module(includes = [AppModule.BindsModule::class])
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideRetrofit(httpClient: OkHttpClient): API {
        return Retrofit.Builder()
            .baseUrl(Constants.API_BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(httpClient)
            .build()
            .create(API::class.java)
    }

    @Provides
    fun getOkHttpClient(): OkHttpClient = OkHttpClient.Builder().build()

    @Module
    @InstallIn(SingletonComponent::class)
    interface BindsModule {
        @Binds
        abstract fun bindStockRepository(cardRepositoryImpl: CardRepositoryImpl): CardRepository
    }
}