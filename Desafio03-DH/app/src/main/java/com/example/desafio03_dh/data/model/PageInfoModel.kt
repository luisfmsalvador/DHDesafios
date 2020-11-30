package com.example.desafio03_dh.data.model

import com.google.gson.annotations.SerializedName

data class PageInfoModel (
    @SerializedName("total")
    val quantidade: Int,
    @SerializedName("results")
    val resultado:  List<CharacterModel>
)