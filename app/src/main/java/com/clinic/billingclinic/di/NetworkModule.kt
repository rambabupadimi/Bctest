package com.clinic.billingclinic.di

import android.content.Context
import com.clinic.billingclinic.helper.NoNetworkException
import com.clinic.billingclinic.retrofit.ApiEndPoint.Companion.BASE_URL
import com.clinic.billingclinic.retrofit.ApiService
import com.example.appit.kotlintestprojectwithdagger2.retrofit.CheckNetwork
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.soc.mycolorado.network.NetworkInterceptor
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
class NetworkModule{

    @Provides
    @Singleton
    fun provideOkHttpClient(context: Context): OkHttpClient {
        val logging = HttpLoggingInterceptor()
                .setLevel(HttpLoggingInterceptor.Level.HEADERS)
        val client = OkHttpClient.Builder()
                .connectTimeout(100, TimeUnit.SECONDS)
                .writeTimeout(30, TimeUnit.SECONDS)
                .readTimeout(100, TimeUnit.SECONDS)

        client.addInterceptor(logging)

        client.addInterceptor((object : NetworkInterceptor() {
            override val isInternetAvailable: Boolean
                get() = CheckNetwork.isNetworkConnected(context)

            override fun onInternetUnavailable() {
                throw NoNetworkException(context)
            }
        }))

        return client.build()
    }

    @Provides
    @Singleton
    fun provideGson(context: Context): Gson {
        val gsonBuilder = GsonBuilder()
        return gsonBuilder.create()
    }


    @Singleton
    @Provides
    fun provideRetrofit(okHttpClient: OkHttpClient, gson: Gson): Retrofit {
        return Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create(gson))
                .baseUrl(BASE_URL)
                .client(okHttpClient)
                .build()
    }

    @Provides
    @Singleton
    fun provideApiService(retrofit: Retrofit): ApiService {
        return retrofit.create(ApiService::class.java);
    }


}