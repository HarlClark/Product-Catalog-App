package com.example.productcatalogapp.data.api

import com.example.productcatalogapp.data.model.Product
import com.example.productcatalogapp.data.model.ProductResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface ProductApiService {
    @GET("products")
    suspend fun getProducts(): ProductResponse

    @GET("products/{id}")
    suspend fun getProductById(@Path("id") id: Int): Product
}