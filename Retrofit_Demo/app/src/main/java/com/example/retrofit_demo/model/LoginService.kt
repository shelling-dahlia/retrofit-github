package com.example.retrofit_demo.model

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface LoginService {
    @GET("/login/register")
    suspend fun getRegister(@Path("userName") userName: String?): Call<UserModel>
}