package com.andela.testdagger.di.module

import com.andela.testdagger.network.ApiService
import com.andela.testdagger.utils.Constants.BASE_URL
import dagger.Module
import dagger.Provides
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
object NetworkModule {

    @Provides
    internal fun provideOkttpClient(interceptor: Interceptor,
                                    loggingInceptor: HttpLoggingInterceptor):
            OkHttpClient = OkHttpClient.Builder()
            .addInterceptor(interceptor)
            .addInterceptor(loggingInceptor)
            .build()

    @Provides
    @Singleton
    internal fun provideRetrofit(modifiedOkHttpClient: OkHttpClient): Retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(modifiedOkHttpClient)
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create()).build()

    @Provides
    internal fun provideApiService(retrofit: Retrofit) = retrofit.create(ApiService::class.java)

    @Provides
    internal fun provideHttpLoggingInterceptor(): HttpLoggingInterceptor {
        val httpLoggingInterceptor = HttpLoggingInterceptor()
        httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
        return httpLoggingInterceptor
    }

    @Provides
    internal fun provideInterceptor(): Interceptor {
        return Interceptor { chain ->
            val original = chain.request()
            val request = original.url()

            val url = request.newBuilder()
                    .addQueryParameter("api-key", "5e8efaecfe81493b8ef3fb9aa43eeb02")
                    .build()

            val requestBuilder = original.newBuilder().url(url)
            val requested = requestBuilder.build()

            chain.proceed(requested)
        }
    }
}