package com.gabo7.parcial2pdm.view.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.gabo7.parcial2pdm.R
import com.gabo7.parcial2pdm.model.product.Product
import com.gabo7.parcial2pdm.view.navigation.Screens

@Composable
fun ProductCard(product : Product, onClick : () -> Unit) {

    Card (
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .clickable { onClick() }
    ) {

        Column (
            modifier = Modifier
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Row {
                AsyncImage(
                    model = product.image,
                    contentDescription = "Product Image",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(250.dp) //misma cosa, se me fue colocarle una altura adecuada para que permitiera ver todo
                )
            }

            Spacer(modifier = Modifier.height(5.dp))

            Text(product.name, style = MaterialTheme.typography.titleLarge)
            Text(product.category, style = MaterialTheme.typography.titleMedium)
            Text(product.price.toString(), style = MaterialTheme.typography.titleSmall)
        }
    }
}