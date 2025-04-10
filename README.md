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
```bash
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
```
---
## How to Run
**1. Before running the app, make sure you have:**
-Android Studio (Arctic Fox or later)
-Android SDK (API level 33 or higher recommended)
-Kotlin plugin installed (usually included by default)
-An emulator configured or a physical Android device connected

**2. Clone the project:**
```bash
git clone https://github.com/HarlClark/Product-Catalog-App.git
```
Or you can extract ZIP and extract it.

**3.  Open the Project in Android Studio**
- Launch Android Studio
- Click File > Open
- Select the root folder of the project (where the build.gradle file is located)

Android Studio will take a few seconds to index the project and download dependencies.

**4. Sync Gradle**

If prompted, click "Sync Now" or use:
- File > Sync Project with Gradle Files

This ensures all libraries (e.g. Compose, Coil) are properly fetched.

**5. Run the App**

Choose a device:
- either connect your physical Android phone or launch an emulator
- Click the green “Run” button ▶️ at the top of Android Studio
- Select your target device and the app will launch

**6. Explore the App**

Once installed, you can:
- Browse the product list
- Click on a product to view details
- Add items to the cart
- Adjust quantity or remove from cart
- Fill in your name, address, and phone in the Buy screen
- Tap Checkout to complete the flow


