package com.example.desafio03_dh.menu.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.liveData
import com.example.desafio03_dh.menu.model.ComicModel
import com.example.desafio03_dh.menu.repository.ComicRepository
import kotlinx.coroutines.Dispatchers

class ComicViewModel(
    private val repository: ComicRepository
): ViewModel() {
    var comics: List<ComicModel> = listOf()

    fun obterLista(characterId: Int = 1009610) = liveData(Dispatchers.IO) {
        val response = repository.obterQuadrinhos(characterId)
        comics = response.dados.resultado
        emit(response.dados.resultado)
    }

    class ComicViewModelFactory(private val repository: ComicRepository) :
        ViewModelProvider.Factory {
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            return ComicViewModel(repository) as T
        }
    }
}