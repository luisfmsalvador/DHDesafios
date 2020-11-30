package com.example.desafio03_dh.menu.view

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.desafio03_dh.R
import com.example.desafio03_dh.menu.model.QuadrinhoModel
import com.squareup.picasso.Picasso

class QuadrinhoViewHolder(private val view: View): RecyclerView.ViewHolder(view) {
    private val imagem = view.findViewById<ImageView>(R.id.imgRevista_fMenu)
    private val numero = view.findViewById<TextView>(R.id.txtNumeroRevista_fMenu)

    fun bind(quadrinho: QuadrinhoModel){
        numero.text = "# " + quadrinho.id

        Picasso.get()
            .load(quadrinho.urlCapa)
            .into(imagem)
    }
}