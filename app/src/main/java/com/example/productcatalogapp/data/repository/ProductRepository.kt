package com.example.productcatalogapp.data.repository

import com.example.productcatalogapp.data.api.RetrofitInstance
import com.example.productcatalogapp.data.model.Product

class ProductRepository {
    private val api = RetrofitInstance.api

    suspend fun getProducts(): List<Product> = api.getProducts().products
    suspend fun getProductById(id: Int): Product = api.getProductById(id)
}
