package com.example.productcatalogapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.*
import androidx.navigation.navArgument
import com.example.productcatalogapp.presentation.cart.CartScreen
import com.example.productcatalogapp.presentation.checkout.BuyScreen
import com.example.productcatalogapp.presentation.productdetail.ProductDetailScreen
import com.example.productcatalogapp.presentation.productlist.ProductListScreen
import com.example.productcatalogapp.ui.theme.ProductCatalogTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ProductCatalogTheme {
                ProductCatalogApp()
            }
        }
    }
}

@Composable
fun ProductCatalogApp() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "productList") {
        composable("productList") {
            ProductListScreen(navController = navController)
        }
        composable(
            "productDetail/{productId}",
            arguments = listOf(navArgument("productId") { type = NavType.IntType })
        ) { backStackEntry ->
            val productId = backStackEntry.arguments?.getInt("productId") ?: 0
            ProductDetailScreen(productId = productId, navController = navController)
        }
        composable("cart") {
            CartScreen(navController = navController)
        }
        composable("buy") {
            BuyScreen(navController = navController)
        }


    }
}
