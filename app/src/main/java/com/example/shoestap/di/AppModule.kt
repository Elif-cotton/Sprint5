package com.example.shoestap.di

import android.content.Context
import androidx.room.Room
import com.example.shoestap.room.ShoeDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideShoeDatabase(@ApplicationContext app: Context): ShoeDatabase {
        return Room.databaseBuilder(
            app,
            ShoeDatabase::class.java,
            "shoe_database"
        ).build()
    }

    @Provides
    @Singleton
    fun provideShoeDao(database: ShoeDatabase) = database.shoeDao()
}