package com.example.desafio03_dh.data.model

import com.example.desafio03_dh.menu.model.CharacterModel
import com.google.gson.annotations.SerializedName

data class PageInfoModel<T> (
    @SerializedName("total")
    val quantidade: Int,
    @SerializedName("results")
    val resultado:  List<T>
)