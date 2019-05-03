package com.andela.testdagger.network

import com.andela.testdagger.model.ApiResponse
import com.andela.testdagger.model.FoodResults
import io.reactivex.Observable
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {
    @GET("food.json")
    fun getFood(): Observable<ApiResponse<List<FoodResults>>>
}