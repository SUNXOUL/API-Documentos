package com.sagrd.apidocumentos.di

import com.sagrd.apidocumentos.data.remote.DocumentoApi
import com.sagrd.apidocumentos.data.repository.DocumentoRepository
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

@Module
@InstallIn( SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    fun provideMoshi(): Moshi {
        return Moshi.Builder()
            .add(KotlinJsonAdapterFactory())
            .build()
    }


    @Provides
    @Singleton
    fun provideDocumentoRepository(documentoApi: DocumentoApi): DocumentoRepository {
        return DocumentoRepository(documentoApi)
    }

    @Provides
    @Singleton
    fun provideDocumentosApi(moshi: Moshi, ): DocumentoApi {
        return Retrofit.Builder()
            .baseUrl("https://my-json-server.typicode.com/enelramon/apimock/")
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .build()
            .create(DocumentoApi::class.java)
    }

}