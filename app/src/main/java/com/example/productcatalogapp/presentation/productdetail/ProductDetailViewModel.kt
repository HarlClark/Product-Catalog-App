package com.example.productcatalogapp.presentation.productdetail

import androidx.compose.runtime.*
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.productcatalogapp.data.model.Product
import com.example.productcatalogapp.data.repository.ProductRepository
import kotlinx.coroutines.launch

class ProductDetailViewModel : ViewModel() {
    private val repository = ProductRepository()

    var product by mutableStateOf<Product?>(null)
        private set

    var isLoading by mutableStateOf(true)
        private set

    var error by mutableStateOf<String?>(null)
        private set

    fun getProduct(id: Int) {
        viewModelScope.launch {
            try {
                isLoading = true
                product = repository.getProductById(id)
                error = null
            } catch (e: Exception) {
                error = "Failed to load product"
            } finally {
                isLoading = false
            }
        }
    }
}
