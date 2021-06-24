package com.example.retrofit_demo.repository

import com.example.retrofit_demo.model.GitHubUserModel
import com.example.retrofit_demo.model.UserModel

interface GitHubRepository {

    //User
    suspend fun getUserDetailfromAPI(userName : String) : UserModel?

    //Follower
    suspend fun getListFollowerfromAPI(userName : String) : List<GitHubUserModel>?

    //Following
    suspend fun getListFollowingfromAPI(userName : String) : List<GitHubUserModel>?
}