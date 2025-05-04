package com.example.sriluckplatform.data

import com.example.sriluckplatform.R


object Datasource {
    val products = listOf(
        Product(
            id = 1,
            name = "Classic Sneakers",
            price = 59.99,
            imageResourceId = R.drawable.classic,
            description = "Comfortable classic sneakers for everyday wear",
            category = "Sneakers",
            rating = 4.5f
        ),
        Product(
            id = 2,
            name = "Running Shoes",
            price = 89.99,
            imageResourceId = R.drawable.running,
            description = "High-performance running shoes with cushioning",
            category = "Running",
            rating = 4.8f
        ),
        Product(
            id = 3,
            name = "Formal Oxfords",
            price = 129.99,
            imageResourceId = R.drawable.formal,
            description = "Elegant formal shoes for business occasions",
            category = "Formal",
            rating = 4.3f
        ),
        Product(
            id = 4,
            name = "Casual Loafers",
            price = 69.99,
            imageResourceId = R.drawable.casual,
            description = "Comfortable slip-on shoes for casual outings",
            category = "Casual",
            rating = 4.2f
        ),
        Product(
            id = 5,
            name = "Hiking Boots",
            price = 109.99,
            imageResourceId = R.drawable.boots,
            description = "Durable boots for outdoor adventures",
            category = "Outdoor",
            rating = 4.7f
        ),
        Product(
            id = 6,
            name = "Sports Sandals",
            price = 49.99,
            imageResourceId = R.drawable.sports,
            description = "Lightweight sandals for sports and leisure",
            category = "Sandals",
            rating = 4.0f
        )
    )

    val categories = listOf(
        "All",
        "Sneakers",
        "Running",
        "Formal",
        "Casual",
        "Outdoor",
        "Sandals"
    )

    val currentUser = User(
        id = 1,
        name = "John Doe",
        email = "john@example.com",
        phone = "+1234567890",
        address = "123 Main St, City, Country"
    )
    // Add cart items to Datasource
    val cartItems = mutableListOf(
        CartItem(
            product = products[0],
            quantity = 1,
            selectedColor = "Black"
        ),
        CartItem(
            product = products[1],
            quantity = 2,
            selectedColor = "White"
        ),
        CartItem(
            product = products[2],
            quantity = 1,
            selectedColor = "Brown"
        )
    )
}