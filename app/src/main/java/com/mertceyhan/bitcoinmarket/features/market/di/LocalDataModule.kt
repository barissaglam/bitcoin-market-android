package com.mertceyhan.bitcoinmarket.features.market.di

import android.content.Context
import android.content.SharedPreferences
import androidx.room.Room
import com.mertceyhan.bitcoinmarket.features.market.data.local.MarketDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object LocalDataModule {

    @Provides
    @Singleton
    fun provideMarketDatabase(
        @ApplicationContext context: Context
    ): MarketDatabase =
        Room.databaseBuilder(context, MarketDatabase::class.java, MarketDatabase.DB_NAME)
            .build()

    @Singleton
    @Provides
    fun provideSharedPreferences(
        @ApplicationContext context: Context
    ): SharedPreferences = context.getSharedPreferences(
        "MarketPreferences", Context.MODE_PRIVATE
    )
}