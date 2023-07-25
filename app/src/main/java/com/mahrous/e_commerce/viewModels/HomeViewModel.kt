package com.mahrous.e_commerce.viewModels

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mahrous.domain.entity.HomeModel
import com.mahrous.domain.usecase.GetHome
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel  @Inject constructor(private val getHomeUseCase : GetHome) : ViewModel() {

    private val _categories: MutableStateFlow<List<HomeModel>?> = MutableStateFlow(null)
    val categories: StateFlow<List<HomeModel>?> = _categories

    fun getHome(mail : String , code : Int){
        viewModelScope.launch{
            try {
                _categories.value = getHomeUseCase(mail , code)
                Log.e("TAG", "getMeals: "+categories.value )
            } catch (e: Exception){
                Log.e("MealsViewModel", e.message.toString())
            }
        }
    }

}