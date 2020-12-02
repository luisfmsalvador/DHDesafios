package com.example.desafio03_dh.menu.model

import com.google.gson.annotations.SerializedName

data class PriceModel(
    @SerializedName("type")
    val tipo: String,
    @SerializedName("price")
    val price: Double
)