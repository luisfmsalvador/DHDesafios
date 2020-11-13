package com.example.desafio02_dh.menu.view

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.desafio02_dh.R
import com.example.desafio02_dh.menu.model.Restaurante

class RestauranteAdapterHolder(private val view: View) : RecyclerView.ViewHolder(view) {
    private val nomeRestaurante: TextView = view.findViewById(R.id.txtRestaurante_fMenu)
    private val enderecoRestaurante: TextView = view.findViewById(R.id.txtEndereco_fMenu)
    private val horarioFechamentoRestaurante: TextView =
        view.findViewById(R.id.txtHorarioFecha_fMenu)
    private val imagemRestaurante: ImageView = view.findViewById(R.id.imgRestaurante_fMenu)

    fun bind(restaurante: Restaurante) {
        nomeRestaurante.text = restaurante.nome
        enderecoRestaurante.text = restaurante.endereco
        horarioFechamentoRestaurante.text = "Fecha às " + restaurante.horarioFechamento

        val imagemSplash = ContextCompat.getDrawable(view.context, restaurante.imagem)
        imagemRestaurante.setImageDrawable(imagemSplash)
    }
}