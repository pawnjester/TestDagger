package com.andela.testdagger.db

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import com.andela.testdagger.model.FoodResults
import com.andela.testdagger.model.Person

@Dao
interface PersonDao {

    @Insert fun insertItem(result: Person)
}