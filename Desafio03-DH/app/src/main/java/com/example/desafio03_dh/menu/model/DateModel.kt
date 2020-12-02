package com.example.desafio03_dh.menu.model

import com.google.gson.annotations.SerializedName
import java.util.*

data class DateModel (
    @SerializedName("type")
    val tipo: String,
    @SerializedName("date")
    val data: String
)