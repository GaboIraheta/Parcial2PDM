package com.gabo7.parcial2pdm.view.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.gabo7.parcial2pdm.model.product.Product

@Composable
fun ProductDetailScreen(product : Product, navController: NavController) {

    Column (
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 30.dp)
    ) {

        Button(
            onClick = { navController.popBackStack() },
            modifier = Modifier.padding(bottom = 8.dp)
        ) {
            Text("←")
            Text("${product.name}") //esto lo hice para mostrar que el contenido si se guarda
        }

        Spacer(modifier = Modifier.height(5.dp))

        Column (
            modifier = Modifier
                .fillMaxWidth(),
            horizontalAlignment  = Alignment.CenterHorizontally
        ) {

            Row {
                AsyncImage(
                    model = product.image,
                    contentDescription = "Product Image",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(250.dp) //esto es lo unico que me falto para que se mostrara bien la pantalla de detalles
                    //se me fue la onda de colocarle un tamano fijo con la presura de terminarlo a tiempo
                )
            }

            Spacer(modifier = Modifier.height(5.dp))

            Text(product.name, style = MaterialTheme.typography.titleLarge)
            Text(product.category, style = MaterialTheme.typography.titleMedium)
            Text(product.price.toString(), style = MaterialTheme.typography.titleSmall)

            Spacer(modifier = Modifier.height(5.dp))

            Button(
                onClick = { product.addedToCart = true }
            ) {
                Text("Agregar al carrito")
            }
        }
    }
}