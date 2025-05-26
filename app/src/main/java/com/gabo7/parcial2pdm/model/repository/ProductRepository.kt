package com.gabo7.parcial2pdm.model.repository

import com.gabo7.parcial2pdm.model.data.dummyProducts
import com.gabo7.parcial2pdm.model.product.Product

class ProductRepository {

    private val products = dummyProducts

    fun getProducts() :  List<Product> = products

    fun getProductById(id : Int) : Product? = products.find { it.id == id }
}