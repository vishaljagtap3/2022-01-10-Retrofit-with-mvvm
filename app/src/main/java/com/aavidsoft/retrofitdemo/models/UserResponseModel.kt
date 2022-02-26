package com.aavidsoft.retrofitdemo.models

import com.google.gson.annotations.SerializedName

data class UserResponseModel(
    @SerializedName("page")
    var page : Int,
    @SerializedName("total_pages")
    var totalPages : Int,
    @SerializedName("data")
    var users : ArrayList<User>
)
