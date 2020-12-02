package com.example.desafio03_dh.menu.repository

import com.example.desafio03_dh.data.api.NetworkUtils
import com.example.desafio03_dh.data.model.ResponseModel
import com.example.desafio03_dh.menu.model.ComicModel
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface IComicEndPoint {
    @GET("/v1/public/characters/{characterId}/comics")
    suspend fun obterQuadrinhos(@Path("characterId") characterId: Int, @Query("format") format:String = "comic", @Query("formatType") formatType:String = "comic", @Query("noVariants") noVariants:Boolean = true): ResponseModel<ComicModel>

    companion object {
        val endpoint: IComicEndPoint by lazy {
            NetworkUtils.getRetrofitInstance().create(IComicEndPoint::class.java)
        }
    }
}