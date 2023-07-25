package com.mahrous.domain.repo

import com.mahrous.domain.entity.HomeModel

interface HomeRepo {
    suspend fun getHomeDataFromServer(mail : String , code : Int):List<HomeModel>
}