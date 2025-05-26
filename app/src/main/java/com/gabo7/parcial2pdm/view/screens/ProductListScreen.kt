package com.gabo7.parcial2pdm.view.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.navigation.NavController
import com.gabo7.parcial2pdm.viewmodel.ProductViewModel
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.gabo7.parcial2pdm.view.components.ProductCard
import com.gabo7.parcial2pdm.view.navigation.Screens

@Composable
fun ProductListScreen(viewModel: ProductViewModel, navController: NavController) {

    val query by viewModel.query.collectAsState()
    val products by viewModel.filteredProducts.collectAsState()

    Column (
        modifier = Modifier
            .fillMaxSize()
            .padding(10.dp)
    ) {

        TextField(
            value = query,
            onValueChange = { viewModel.onQueryChange(it) },
            modifier = Modifier.fillMaxWidth(),
            placeholder = { Text("Busca producto por nombre o categoria") }
        )

        LazyColumn {
            items (products) { product ->
                ProductCard(product) {
                    navController.navigate(Screens.ProductDetailScreen.createRoute(product.id))
                }
            }
        }

        Spacer(modifier = Modifier.height(10.dp))

        Button(
            onClick = { navController.navigate(Screens.CartScreen.route)}
        ) {
            Text("Ver el carrito")
        }
    }
}