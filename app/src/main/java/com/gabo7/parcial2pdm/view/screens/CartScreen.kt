package com.gabo7.parcial2pdm.view.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.lifecycle.viewmodel.compose.viewModel
import com.gabo7.parcial2pdm.viewmodel.ProductViewModel
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.gabo7.parcial2pdm.view.components.ProductCard
import com.gabo7.parcial2pdm.view.navigation.Screens
import java.nio.file.WatchEvent

@Composable
fun CartScreen(viewModel: ProductViewModel = viewModel(), navController : NavController) {

    val products by viewModel.filteredProducts.collectAsState()

    Column (
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 30.dp)
    ) {

        Button(
            onClick = { navController.popBackStack() }
        ) {
            Text("←")
        }

        LazyColumn (
            modifier = Modifier.padding(10.dp)
        ) {
            items (products) { product ->
                if (product.addedToCart) {
                    ProductCard(product) {
                        navController.navigate(Screens.ProductDetailScreen.createRoute(product.id))
                    }
                }
            }
        }
    }
}