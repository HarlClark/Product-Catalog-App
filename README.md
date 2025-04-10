# Product Catalog App

## Assignment Summary

This Android application was developed as part of a Kotlin Mobile Development assignment. The objective was to build a complete product catalog app using Jetpack Compose that supports:

- A clean and scrollable product listing interface
- Detailed product view with image gallery
- Shopping cart functionality with quantity control
- Checkout screen for collecting customer details
- Responsive UI
- Full navigation architecture and app branding

The app is designed to showcase both UI/UX best practices and modern Android development techniques using Jetpack Compose.

---

## Features

- Product listing with title, price, and description
- Product detail screen with full-screen image preview
- Add to cart and quantity control (+ / -)
- Remove individual items from cart
- Real-time subtotal and total calculation
- Swipe-to-refresh and error retry handling
- Checkout screen with Name, Address, and Phone input
- Snackbar confirmation for cart actions
- Redirect to product list after checkout


---

## Tech Stack

- Kotlin
- Jetpack Compose
- Material 3
- Navigation Compose
- Coil (image loading)
- Accompanist SwipeRefresh
- ViewModel + mutableState for state management

---
## Project Structure

## Project Structure

app/
└── src/
    └── main/
        ├── java/
        │   └── com/example/productcatalogapp/
        │       ├── data/
        │       │   ├── model/            # Product data model
        │       │   └── cart/             # CartManager and CartItem
        │       ├── presentation/
        │       │   ├── productlist/      # ProductListScreen and ViewModel
        │       │   ├── productdetail/    # ProductDetailScreen and ViewModel
        │       │   ├── cart/             # CartScreen
        │       │   └── checkout/         # BuyScreen (user details input)
        │       ├── ui/
        │       │   └── theme/
        │       │       ├── AppTypography/ # Custom text style
        │       │       ├── Color/         # Have color value
        │       │       ├── Theme/         # Overall theme
        │       │       └── Type/          
        │       └── MainActivity.kt       # NavHost and entry point
        └── res/
            ├── drawable/                 # Icons, splash background
            ├── mipmap/                   # App launcher icons
            └── values/                   # themes.xml, colors.xml, strings.xml

---
## How to Run

1. Clone the project:
```bash
git clone https://github.com/HarlClark/Product-Catalog-App.git
