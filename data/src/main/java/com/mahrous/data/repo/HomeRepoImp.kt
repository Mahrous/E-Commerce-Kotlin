package com.mahrous.data.repo

import com.mahrous.data.apiservice.ApiService
import com.mahrous.domain.entity.HomeModel
import com.mahrous.domain.repo.HomeRepo

class HomeRepoImp (private val apiService: ApiService): HomeRepo {
    override suspend fun getHomeDataFromServer( mail : String , code : Int): List<HomeModel> = apiService.getHome(mail,code)

}