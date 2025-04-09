package com.example.productcatalogapp.presentation.productlist

import androidx.compose.runtime.*
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.productcatalogapp.data.model.Product
import com.example.productcatalogapp.data.repository.ProductRepository
import kotlinx.coroutines.launch

class ProductListViewModel : ViewModel() {

    private val repository = ProductRepository()

    var products by mutableStateOf<List<Product>>(emptyList())
        private set

    var isLoading by mutableStateOf(true)
        private set

    var error by mutableStateOf<String?>(null)
        private set

    // ✅ New: Search query state
    var searchQuery by mutableStateOf("")
        private set

    // ✅ New: Selected category
    var selectedCategory by mutableStateOf("All")
        private set

    // ✅ New: Computed filtered product list
    val filteredProducts: List<Product>
        get() = products.filter {
            (searchQuery.isBlank() || it.title.contains(searchQuery, ignoreCase = true)) &&
                    (selectedCategory == "All" || it.category.equals(selectedCategory, ignoreCase = true))
        }

    // ✅ New: Available categories
    val categories: List<String>
        get() = listOf("All") + products.map { it.category }.distinct()

    init {
        getProducts()
    }

    fun getProducts() {
        viewModelScope.launch {
            try {
                isLoading = true
                products = repository.getProducts()
                error = null
            } catch (e: Exception) {
                error = "Failed to load products"
            } finally {
                isLoading = false
            }
        }
    }

    // ✅ Called when search text changes
    fun onSearchQueryChange(query: String) {
        searchQuery = query
    }

    // ✅ Called when a category is selected
    fun onCategorySelected(category: String) {
        selectedCategory = category
    }
}
