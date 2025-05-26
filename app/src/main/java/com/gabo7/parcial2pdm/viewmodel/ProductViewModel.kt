package com.gabo7.parcial2pdm.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.gabo7.parcial2pdm.model.product.Product
import com.gabo7.parcial2pdm.model.repository.ProductRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class ProductViewModel : ViewModel() {

    private val repository = ProductRepository()

    private val _query = MutableStateFlow<String>("")
    val query : StateFlow<String> = _query

    private val _products = repository.getProducts()

    val filteredProducts : StateFlow<List<Product>> = query
        .map { text ->
            _products.filter {
                it.name.contains(text, true) || it.category.contains(text, true)
            }
        }
        .stateIn(viewModelScope, SharingStarted.Lazily, _products)

    fun onQueryChange(query : String) {
        _query.value = query
    }

    fun getProductById(id : Int) : Product? = repository.getProductById(id)
}