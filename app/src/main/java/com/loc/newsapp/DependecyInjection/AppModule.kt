package com.loc.newsapp.DependecyInjection

import android.app.Application
import com.loc.newsapp.data.manager.LocalMangerImpl
import com.loc.newsapp.domain.manager.LocalUserManager
import com.loc.newsapp.domain.usecases.app_entry.AppEntryUseCaseData
import com.loc.newsapp.domain.usecases.app_entry.ReadAppEntry
import com.loc.newsapp.domain.usecases.app_entry.SaveAppEntry
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    fun provideLocalUserManger(
        application: Application
    ):LocalUserManager = LocalMangerImpl(application)


    @Provides
    @Singleton
    fun providesAppEntryUseCases(localUserManager: LocalUserManager)= AppEntryUseCaseData(
        readAppEntry = ReadAppEntry(localUserManager),
        saveAppEntry = SaveAppEntry(localUserManager)
    )
}