package com.example.desafio03_dh.menu.repository

class ComicRepository {
    private val client = IComicEndPoint.endpoint
    suspend fun obterQuadrinhos(characterId: Int = 0) = client.obterQuadrinhos(characterId)
}