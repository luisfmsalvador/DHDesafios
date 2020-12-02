package com.example.desafio03_dh.menu.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.liveData
import com.example.desafio03_dh.menu.model.CharacterModel
import com.example.desafio03_dh.menu.repository.CharacterRepository
import kotlinx.coroutines.Dispatchers

class CharacterViewModel(
    private val repository: CharacterRepository
) : ViewModel() {

    var characters: List<CharacterModel> = listOf()

    fun obterLista(name: String = "Spider-man") = liveData(Dispatchers.IO) {
        val response = repository.obterPersonagens(name)
        characters = response.dados.resultado
        emit(response.dados.resultado)
    }

    class CharacterViewModelFactory(private val repository: CharacterRepository) :
        ViewModelProvider.Factory {
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            return CharacterViewModel(repository) as T
        }
    }
}