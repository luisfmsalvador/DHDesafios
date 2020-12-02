package com.example.desafio03_dh.menu.model

import com.google.gson.annotations.SerializedName


data class ComicModel(
    @SerializedName("id")
    val id: Int,
    @SerializedName("title")
    val titulo: String,
    @SerializedName("description")
    val descricao: String,
    @SerializedName("issueNumber")
    val numero: Double,
    @SerializedName("prices")
    val precos: List<PriceModel>,
    @SerializedName("thumbnail")
    val thumbnail: ThumbnailModel,
    @SerializedName("pageCount")
    val paginas: Int,
    @SerializedName("dates")
    val datas: List<DateModel>
)