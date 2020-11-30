package com.example.desafio03_dh.data.model

import com.google.gson.annotations.SerializedName

data class CharacterModel (
    @SerializedName("id")
    val id:Int,
    @SerializedName("name")
    val nome: String,
    @SerializedName("thumbnail")
    val thumbnail: ThumbnailModel
)