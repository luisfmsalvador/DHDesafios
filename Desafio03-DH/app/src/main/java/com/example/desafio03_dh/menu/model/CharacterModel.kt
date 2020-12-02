package com.example.desafio03_dh.menu.model

import com.google.gson.annotations.SerializedName

data class CharacterModel (
    @SerializedName("id")
    val id:Int,
    @SerializedName("thumbnail")
    val thumbnail: ThumbnailModel
)