package com.hsmnzaydn.daily_horoscope.di.modules.horoscope_module

import com.hsmnzaydn.daily_horoscope.horoscope.data.repository.HoroscopeRepositoryImpl
import com.hsmnzaydn.daily_horoscope.horoscope.domain.repository.HoroscopeRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import retrofit2.Retrofit
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
class HoroscopeModule {

    @Provides
    @Singleton
    fun provideHoroscopeRepository(retrofit: Retrofit): HoroscopeRepository {
        return HoroscopeRepositoryImpl(retrofit)
    }
}