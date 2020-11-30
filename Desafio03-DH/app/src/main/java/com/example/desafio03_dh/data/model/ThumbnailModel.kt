package com.example.desafio03_dh.data.model

import com.google.gson.annotations.SerializedName

data class ThumbnailModel(
    @SerializedName("path")
    val diretorio: String,
    @SerializedName("extension")
    val exensao: String
)