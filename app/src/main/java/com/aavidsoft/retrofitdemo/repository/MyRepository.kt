package com.aavidsoft.retrofitdemo.repository

import com.aavidsoft.retrofitdemo.models.UserResponseModel
import com.aavidsoft.retrofitdemo.network.ApiService

class MyRepository(private val apiService: ApiService) {

    suspend fun getUsers(pageNumber : Int) : UserResponseModel {
        return apiService.getUsers(pageNumber)
    }
}