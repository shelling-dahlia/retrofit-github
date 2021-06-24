package com.example.retrofit_demo.repository

import com.example.retrofit_demo.model.GitHubUserModel
import com.example.retrofit_demo.model.UserModel
import retrofit2.http.GET
import retrofit2.http.Path

interface GitHubService {
    //SetInterFace-User
    @GET("/users/{userName}")
    suspend fun getUserDetail(@Path("userName") userName : String?): UserModel?

    //setInterfacce-Follower
    @GET("/users/{userName}/followers")
    suspend fun getListFollower(@Path("userName") userName : String?): List<GitHubUserModel>?

    //setInterfacce-Following
    @GET("/users/{userName}/following")
    suspend fun getListFollowing(@Path("userName") userName : String?): List<GitHubUserModel>?
}