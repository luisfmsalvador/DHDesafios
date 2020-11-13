package com.example.desafio02_dh.listacardapio.view

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.desafio02_dh.R
import com.example.desafio02_dh.listacardapio.model.Cardapio

class CardapioAdapterHolder(val view: View) : RecyclerView.ViewHolder(view) {
    private val nome: TextView = view.findViewById(R.id.txtPrato_fCardapio)
    private val imagem: ImageView = view.findViewById(R.id.imgCardapio_fCardapio)

    fun bind(cardapio: Cardapio) {
        nome.text = cardapio.nome

        val imagemSplash = ContextCompat.getDrawable(view.context, cardapio.imagem)
        imagem.setImageDrawable(imagemSplash)
    }
}