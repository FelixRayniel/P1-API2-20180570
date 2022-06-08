package com.example.p1_api2_20180570.di

import android.content.Context
import androidx.room.Room
import com.example.p1_api2_20180570.data.PrestamoDao
import com.example.p1_api2_20180570.data.RegistroPrestamoDb
import com.example.p1_api2_20180570.data.Repository.PrestamoRepository
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
    fun providesRegistroPrestamoComposeDb(@ApplicationContext context: Context): RegistroPrestamoDb {
        return Room.databaseBuilder(
            context, RegistroPrestamoDb::class.java, "RegistroPrestamoDb"
        )
            .fallbackToDestructiveMigration()
            .build()
    }


    @Provides
    fun providePrestamoDao(registroPrestamoDb: RegistroPrestamoDb): PrestamoDao =
        registroPrestamoDb.prestamoDao

    @Provides
    fun providePrestamoRepository(prestamoDao: PrestamoDao): PrestamoRepository{
        return PrestamoRepository(prestamoDao)
    }
}