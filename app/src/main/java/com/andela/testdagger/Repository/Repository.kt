package com.andela.testdagger.Repository

import com.andela.testdagger.db.PersonDao
import com.andela.testdagger.model.Person
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import java.util.*
import javax.inject.Inject

class Repository @Inject constructor(val dao: PersonDao) {

    val compositeDisposable = CompositeDisposable()

    fun addNewTask(name: String, email: String) {
        val newPerson = Person(personName = name, email = email)
        compositeDisposable.add(Observable.fromCallable {
            dao.insertItem(newPerson)
        }.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe())
    }
}