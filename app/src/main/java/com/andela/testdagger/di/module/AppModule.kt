package com.andela.testdagger.di.module

import android.app.Application
import android.arch.persistence.room.Room
import android.content.Context
import com.andela.testdagger.Repository.Repository
import com.andela.testdagger.db.LocalDatabase
import com.andela.testdagger.db.PersonDao
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule(private val app: Application) {
    @Provides
    fun provideContext(): Context = app

    @Provides
    fun provideApplication(): Application = app

    @Provides
    @Singleton
    fun provideDatabase(context: Context): LocalDatabase =
            Room.databaseBuilder(context,
                    LocalDatabase::class.java,
                    "DaggerDatabase")
                    .allowMainThreadQueries().build()

    @Provides
    fun providesPersonDao(database: LocalDatabase) = database.personDao()

    @Provides @Singleton fun providesRepository(dao: PersonDao) = Repository(dao)
}