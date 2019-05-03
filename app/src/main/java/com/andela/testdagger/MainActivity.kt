package com.andela.testdagger

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.andela.testdagger.Repository.Repository
import com.andela.testdagger.application.RootApplication
import com.andela.testdagger.model.ApiResponse
import com.andela.testdagger.model.FoodResults
import com.andela.testdagger.network.ApiService
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject


class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var apiService: ApiService

    @Inject
    lateinit var repository: Repository

    var disposable: Disposable? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        (application as RootApplication).appComponent.inject(this)
        getResults()
        click.setOnClickListener {
        addPerson()
        }
    }


    fun getResults() {
        disposable = apiService.getFood().observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe({
                    Log.e("result++", it.results.toString())
                },  {
                    Log.e("error++", it.message)
                })
    }

    private fun addPerson() {
        repository.addNewTask(name.text.toString(), email.text.toString())
    }

}
