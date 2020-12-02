package com.example.desafio03_dh.menu.repository

import com.example.desafio03_dh.data.api.NetworkUtils
import com.example.desafio03_dh.data.model.ResponseModel
import com.example.desafio03_dh.menu.model.CharacterModel
import retrofit2.http.GET
import retrofit2.http.Query

interface ICharacterEndPoint {
    @GET("/v1/public/characters")
    suspend fun obterPersonagens(@Query("name") name: String): ResponseModel<CharacterModel>

    companion object {
        val endpoint: ICharacterEndPoint by lazy {
            NetworkUtils.getRetrofitInstance().create(ICharacterEndPoint::class.java)
        }
    }

}