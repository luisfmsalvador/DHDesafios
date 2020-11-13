package com.example.desafio02_dh

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.desafio02_dh.listacardapio.model.Cardapio

class CardapioAdapterHolder(val view: View) : RecyclerView.ViewHolder(view) {
    private val nome: TextView = view.findViewById(R.id.txtPrato_fCardapio)
    private val imagem: ImageView = view.findViewById(R.id.imgCardapio_fCardapio)

    fun bind(cardapio: Cardapio) {
        nome.text = cardapio.nome
        imagem.setImageResource(cardapio.imagem)
    }
}