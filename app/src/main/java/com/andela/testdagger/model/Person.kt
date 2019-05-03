package com.andela.testdagger.model

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

@Entity(tableName = "Person")
class Person (
        @PrimaryKey(autoGenerate = true) var id: Long? = null,
        @ColumnInfo(name = "personName") var personName: String? = null,
        @ColumnInfo(name = "email")var email: String? = null
        )