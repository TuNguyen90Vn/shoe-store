package com.tn.shoestore.models

object FakeData {

    fun createFakeData() = mutableListOf(
        Shoe(
            name = "Adidas",
            size = 32.2,
            company = "Adidas",
            description = "Description",
            images = listOf()
        ),
        Shoe(
            name = "Nike Air",
            size = 32.2,
            company = "Adidas",
            description = "Description",
            images = listOf()
        ),
        Shoe(
            name = "Bitis Hunter",
            size = 32.2,
            company = "Bitis",
            description = "Description",
            images = listOf()
        )
    )
}