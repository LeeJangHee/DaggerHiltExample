package com.devlee.daggerhiltexample.di

import android.app.Application
import com.devlee.daggerhiltexample.data.remote.MyApi
import com.devlee.daggerhiltexample.data.repository.MyRepositoryImpl
import com.devlee.daggerhiltexample.domain.repository.MyRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Named
import javax.inject.Singleton

// 모듈을 적용하면 InstallIn이 반드시 필요하다.
@Module
// InstallIn 클래스는 Hilt에서 제공하는 Component class를 활용해야한다.
// Component는 scpoe를 포함한다.
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    // SingletonComponent와 다르게 인스턴스를 위한 어노테이션이다.
    @Singleton
    fun provideMyApi(): MyApi {
        return Retrofit.Builder()
            .baseUrl("https://test.com")
            .build()
            .create(MyApi::class.java)
    }

//    @Provides
//    @Singleton
//    fun provideMyRepository(
//        api: MyApi,
//        appContext: Application,
//        @Named("hello1") hello1: String
//    ): MyRepository {
//        return MyRepositoryImpl(api, appContext)
//    }


    @Provides
    @Singleton
    @Named("hello1")
    fun provideString1() = "Hello 1"

    @Provides
    @Singleton
    @Named("hello2")
    fun provideString2() = "Hello 2"
}