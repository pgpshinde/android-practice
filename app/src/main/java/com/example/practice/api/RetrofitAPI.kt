package com.example.practice.api

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

// TODO: Implement a simple networking API using retrofit or any library you're familiar with 🙌
// Note: Fetching users-list is the *only* use-case therefore avoid implementing unrelated,
// extra, features no matter how common or useful they might be for potential future cases.
//

object RetrofitAPI {

    private const val BASE_URL: String = "https://jsonplaceholder.typicode.com/"

    private val gson : Gson by lazy {
        GsonBuilder().setLenient().create()
    }

    private val interceptor : HttpLoggingInterceptor by lazy {
        HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
    }

    private val httpClient : OkHttpClient by lazy {
        OkHttpClient.Builder().addInterceptor(interceptor).build()
    }

    private val retrofit : Retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(httpClient)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
    }
    val apiService :  ApiService by lazy{
        retrofit.create(ApiService::class.java)
    }
}