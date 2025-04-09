package com.example.productcatalogapp.presentation.cart

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.rememberAsyncImagePainter
import com.example.productcatalogapp.data.cart.CartItem
import com.example.productcatalogapp.data.cart.CartManager

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CartScreen(navController: NavController) {
    val cartItems = CartManager.cartItems
    val total = cartItems.sumOf { it.product.price * it.quantity }

    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(title = { Text("🛒 Your Cart") })
        },
        bottomBar = {
            if (cartItems.isNotEmpty()) {
                BottomAppBar {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.dp),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text("Total: ₹${"%.2f".format(total)}", style = MaterialTheme.typography.titleMedium)
                        Button(
                            onClick = {
                                navController.navigate("buy")
                            }
                        ) {
                            Text("Check Out")
                        }
                    }
                }
            }
        }
    ) { padding ->
        if (cartItems.isEmpty()) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(padding),
                contentAlignment = Alignment.Center
            ) {
                Text("Your cart is empty 😕")
            }
        } else {
            LazyColumn(
                modifier = Modifier
                    .padding(padding)
                    .padding(bottom = 80.dp),
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                items(cartItems, key = { it.product.id }) { item ->
                    CartItemCard(item, navController)
                }
            }
        }
    }
}

@Composable
fun CartItemCard(item: CartItem, navController: NavController) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { navController.navigate("productDetail/${item.product.id}") },
        shape = RoundedCornerShape(16.dp),
        elevation = CardDefaults.cardElevation(4.dp)
    ) {
        Column(modifier = Modifier.padding(12.dp)) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Image(
                    painter = rememberAsyncImagePainter(item.product.thumbnail),
                    contentDescription = item.product.title,
                    modifier = Modifier
                        .size(80.dp)
                        .clip(RoundedCornerShape(12.dp))
                )
                Spacer(Modifier.width(12.dp))
                Column(modifier = Modifier.weight(1f)) {
                    Text(item.product.title, fontWeight = FontWeight.SemiBold)
                    Text("Price: ₹${"%.2f".format(item.product.price)}")
                    Text("Subtotal: ₹${"%.2f".format(item.product.price * item.quantity)}")
                }
                IconButton(onClick = {
                    CartManager.removeItem(item.product.id)
                }) {
                    Icon(Icons.Default.Delete, contentDescription = "Remove")
                }
            }

            Spacer(modifier = Modifier.height(8.dp))

            Row(
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth()
            ) {
                IconButton(onClick = { CartManager.decreaseQuantity(item.product.id) }) {
                    Icon(Icons.Default.Clear, contentDescription = "Decrease")
                }

                Text(
                    text = item.quantity.toString(),
                    modifier = Modifier.padding(horizontal = 12.dp),
                    style = MaterialTheme.typography.bodyLarge
                )

                IconButton(onClick = { CartManager.increaseQuantity(item.product.id) }) {
                    Icon(Icons.Default.Add, contentDescription = "Increase")
                }
            }
        }
    }
}
