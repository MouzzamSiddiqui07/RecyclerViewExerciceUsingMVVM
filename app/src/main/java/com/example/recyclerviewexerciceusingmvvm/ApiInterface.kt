package com.example.networkwithretrofit

import com.example.recyclerviewexerciceusingmvvm.Model.ModelUserData
import com.example.recyclerviewexerciceusingmvvm.Model.ModelUserDataItem
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.*

interface ApiInterface {

    @GET("/posts")
    fun getPosts(): Call<List<ModelUserDataItem>>


}