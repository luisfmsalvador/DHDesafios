package com.example.desafio03_dh.menu.repository

import com.example.desafio03_dh.menu.model.QuadrinhoModel

class QuadrinhoRepository {
    fun obterQuadrinhos(callback: (quadrinhos: List<QuadrinhoModel>) -> Unit) {
        val listaDeQuadrinhos = obterDoBanco()

        callback.invoke(listaDeQuadrinhos)
    }

    fun obterDoBanco(): List<QuadrinhoModel>{
        return listOf(
            QuadrinhoModel(96,"https://i.pinimg.com/564x/9a/8d/86/9a8d867e2ce5cd63b08a5fc0b02bf306.jpg"),
            QuadrinhoModel(97, "https://i.pinimg.com/564x/07/3f/6a/073f6aa3badbcc1f47047a5976a2048a.jpg"),
            QuadrinhoModel(98, "https://i.pinimg.com/564x/e9/af/3b/e9af3b67ec7077406998b92dffe9ee6f.jpg"),
            QuadrinhoModel(99, "https://i.pinimg.com/564x/74/0d/90/740d90b7e4336cc4b5239edd288c234c.jpg"),
            QuadrinhoModel(100, "https://i.pinimg.com/564x/c2/85/2b/c2852ba9cdd242418a262349be2f24a0.jpg"),
            QuadrinhoModel(101,"https://i.pinimg.com/564x/10/47/81/104781e37c547b1e27fde022e9397726.jpg")
        )
    }
}