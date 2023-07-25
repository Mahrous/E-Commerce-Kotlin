package com.mahrous.data.apiservice


import com.mahrous.domain.entity.HomeModel
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST

interface ApiService {



    @POST("home.php")
    @FormUrlEncoded
    suspend fun getHome(@Field("userId")  mail : String, @Field("catID")  code : Int): List<HomeModel>





}