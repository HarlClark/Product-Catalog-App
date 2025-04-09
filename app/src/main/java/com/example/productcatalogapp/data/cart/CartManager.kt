package com.example.productcatalogapp.data.cart

import androidx.compose.runtime.mutableStateListOf
import com.example.productcatalogapp.data.model.Product

data class CartItem(
    val product: Product,
    val quantity: Int
)

object CartManager {
    private val _cartItems = mutableStateListOf<CartItem>()
    val cartItems: List<CartItem> get() = _cartItems

    fun addToCart(product: Product) {
        val index = _cartItems.indexOfFirst { it.product.id == product.id }
        if (index != -1) {
            val current = _cartItems[index]
            _cartItems[index] = current.copy(quantity = current.quantity + 1)
        } else {
            _cartItems.add(CartItem(product, 1))
        }
    }

    fun increaseQuantity(productId: Int) {
        val index = _cartItems.indexOfFirst { it.product.id == productId }
        if (index != -1) {
            val current = _cartItems[index]
            _cartItems[index] = current.copy(quantity = current.quantity + 1)
        }
    }

    fun decreaseQuantity(productId: Int) {
        val index = _cartItems.indexOfFirst { it.product.id == productId }
        if (index != -1) {
            val current = _cartItems[index]
            if (current.quantity > 1) {
                _cartItems[index] = current.copy(quantity = current.quantity - 1)
            } else {
                _cartItems.removeAt(index)
            }
        }
    }

    fun removeItem(productId: Int) {
        _cartItems.removeAll { it.product.id == productId }
    }

    fun clearCart() {
        _cartItems.clear()
    }
}
