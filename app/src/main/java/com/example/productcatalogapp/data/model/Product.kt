package com.example.productcatalogapp.data.model

data class ProductResponse(
    val products: List<Product>
)

data class Product(
    val id: Int,
    val title: String,
    val description: String,
    val price: Double,
    val category: String,
    val rating: Float,
    val images: List<String>,
    val thumbnail: String
)
