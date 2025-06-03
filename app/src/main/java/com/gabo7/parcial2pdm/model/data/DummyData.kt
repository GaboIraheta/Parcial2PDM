package com.gabo7.parcial2pdm.model.data

import com.gabo7.parcial2pdm.model.product.Product

val dummyProducts = listOf(
    Product(
        id = 1,
        name = "Auriculares Inalámbricos",
        category = "Electrónica",
        price = 45.99,
        description = "Auriculares Bluetooth con cancelación de ruido y hasta 12 horas de batería.",
        image = "https://cdnx.jumpseller.com/furst-mayorista/image/46624735/resize/1000/1000?1712949829" //le puse una imagem con acceso para probar
    ),
    Product(
        id = 2,
        name = "Camiseta Oversize",
        category = "Ropa",
        price = 19.50,
        description = "Camiseta de algodón suave, ideal para uso diario. Disponible en varios colores.",
        image = "https://example.com/images/camiseta.png"
    ),
    Product(
        id = 3,
        name = "Mochila Urbana",
        category = "Accesorios",
        price = 32.00,
        description = "Mochila con diseño minimalista, compartimiento para laptop y resistente al agua.",
        image = "https://example.com/images/mochila.png"
    ),
    Product(
        id = 4,
        name = "Lámpara LED Inteligente",
        category = "Hogar",
        price = 28.75,
        description = "Lámpara con control por voz y app móvil. Cambia de color y regula intensidad.",
        image = "https://example.com/images/lampara.png"
    ),
    Product(
        id = 5,
        name = "Termo Acero Inoxidable",
        category = "Cocina",
        price = 14.99,
        description = "Termo térmico de 500 ml que mantiene bebidas frías o calientes por horas.",
        image = "https://example.com/images/termo.png"
    )
)