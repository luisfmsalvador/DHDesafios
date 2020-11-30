package com.example.desafio03_dh.data.model

import com.google.gson.annotations.SerializedName

data class ResponseModel (
    @SerializedName("code")
    val retorno: Int,
    @SerializedName("data")
    val dados: DadosModel
)