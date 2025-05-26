package com.gabo7.parcial2pdm.view.navigation

sealed class Screens(val route : String) {

    object ProductListScreen : Screens("productList")

    object CartScreen : Screens("cartList")

    object ProductDetailScreen : Screens("productDetail/{productID}") {
        fun createRoute(productID: Int) = "productDetail/$productID"
    }
}