package com.gabo7.parcial2pdm.view.navigation

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavArgument
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.gabo7.parcial2pdm.view.screens.CartScreen
import com.gabo7.parcial2pdm.view.screens.ProductDetailScreen
import com.gabo7.parcial2pdm.view.screens.ProductListScreen
import com.gabo7.parcial2pdm.viewmodel.ProductViewModel

@Composable
fun Navigation(viewModel : ProductViewModel = viewModel()) {

    val navController = rememberNavController()

    NavHost(navController, startDestination = Screens.ProductListScreen.route) {

        composable (Screens.ProductListScreen.route) {
            ProductListScreen(viewModel, navController)
        }

        composable (Screens.ProductDetailScreen.route, arguments = listOf(navArgument("productID") { type = NavType.IntType } )
        ) { backStackEntry ->
            val productId = backStackEntry.arguments?.getInt("productID")
            val product = productId?.let { viewModel.getProductById(productId) }
            if (product != null) ProductDetailScreen(product, navController)
        }

        composable (Screens.CartScreen.route) {
            CartScreen(viewModel, navController)
        }
    }
}