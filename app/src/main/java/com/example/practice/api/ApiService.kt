package com.example.practice.api

import com.example.practice.response.User
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {

    @GET("users")
    fun getUsers(): Call<MutableList<User>>
}