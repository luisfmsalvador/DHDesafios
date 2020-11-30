package com.example.desafio03_dh.main.repository

import com.example.desafio03_dh.data.api.NetworkUtils
import com.example.desafio03_dh.data.model.ResponseModel
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ICharacterEndPoint {
    @GET("characters")
    suspend fun obterPersonagens(@Query("name") name: String): Call<ResponseModel>

    companion object {
        val endpoint: ICharacterEndPoint by lazy {
            NetworkUtils.getRetrofitInstance().create(ICharacterEndPoint::class.java)
        }
    }

}