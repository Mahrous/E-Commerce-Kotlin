package com.mahrous.domain.usecase

import com.mahrous.domain.repo.HomeRepo

class GetHome(private val homeRepo: HomeRepo) {
    operator suspend fun invoke( mail : String, code : Int) = homeRepo.getHomeDataFromServer(mail , code)
}