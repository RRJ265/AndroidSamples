package com.example.daggercoroutines.network

import com.example.daggercoroutines.model.Product
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {

    @GET("products")
    suspend fun getProducts() : Response<List<Product>>
}