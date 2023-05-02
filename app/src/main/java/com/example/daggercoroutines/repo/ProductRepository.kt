package com.example.daggercoroutines.repo

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.daggercoroutines.model.Product
import com.example.daggercoroutines.network.ApiService
import javax.inject.Inject

class ProductRepository @Inject constructor(private val apiService: ApiService) {

    private val _products = MutableLiveData<List<Product>>()
    fun products(): LiveData<List<Product>> = _products

    suspend fun getProducts() {
        val result = apiService.getProducts()
        if (result.isSuccessful && result.body() != null)
            _products.postValue(result.body())
    }
}