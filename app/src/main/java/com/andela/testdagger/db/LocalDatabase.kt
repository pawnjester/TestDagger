package com.andela.testdagger.db

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import com.andela.testdagger.model.Person

@Database(entities = [Person::class], version = 1)
abstract class LocalDatabase: RoomDatabase() {

    abstract fun personDao(): PersonDao
}