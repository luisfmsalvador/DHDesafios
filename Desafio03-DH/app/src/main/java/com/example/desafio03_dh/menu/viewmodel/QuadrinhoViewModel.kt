package com.example.desafio03_dh.menu.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.desafio03_dh.menu.model.QuadrinhoModel
import com.example.desafio03_dh.menu.repository.QuadrinhoRepository

class QuadrinhoViewModel(
    private val repository: QuadrinhoRepository
) : ViewModel() {

    val listaDeQuadrinhosData = MutableLiveData<List<QuadrinhoModel>>()

    fun obterLista() {
        repository.obterQuadrinhos {
            listaDeQuadrinhosData.value = it
        }
    }

    class QuadrinhoViewModelFactory(private val repository: QuadrinhoRepository) :
        ViewModelProvider.Factory {
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            return QuadrinhoViewModel(repository) as T
        }
    }
}