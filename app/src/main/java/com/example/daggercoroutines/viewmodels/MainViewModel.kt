package com.example.daggercoroutines.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.daggercoroutines.model.Product
import com.example.daggercoroutines.repo.ProductRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel(private val productRepository: ProductRepository) : ViewModel() {

    fun products(): LiveData<List<Product>> = productRepository.products()

    init {
        viewModelScope.launch(Dispatchers.IO) {
            productRepository.getProducts()
        }
    }

}