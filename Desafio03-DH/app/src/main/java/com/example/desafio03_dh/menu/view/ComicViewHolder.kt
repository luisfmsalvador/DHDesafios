package com.example.desafio03_dh.menu.view

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.desafio03_dh.R
import com.example.desafio03_dh.menu.model.ComicModel
import com.squareup.picasso.Picasso

class ComicViewHolder(private val view: View): RecyclerView.ViewHolder(view) {
    private val imagem = view.findViewById<ImageView>(R.id.imgRevista_fMenu)
    private val numero = view.findViewById<TextView>(R.id.txtNumeroRevista_fMenu)

    fun bind(quadrinho: ComicModel){
        if (quadrinho.numero != 0.0) {
            numero.text = "# " + quadrinho.numero
        } else {
            numero.text = "S/N"
        }

        val caminhoImagem = "${quadrinho.thumbnail.diretorio}.${quadrinho.thumbnail.extensao}"

        Picasso.get()
            .load(caminhoImagem)
            .into(imagem)
    }
}