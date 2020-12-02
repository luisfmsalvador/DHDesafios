package com.example.desafio03_dh.menu.repository

class CharacterRepository {
    private val client = ICharacterEndPoint.endpoint
    suspend fun obterPersonagens(name: String = "Spider-man") = client.obterPersonagens(name)
}