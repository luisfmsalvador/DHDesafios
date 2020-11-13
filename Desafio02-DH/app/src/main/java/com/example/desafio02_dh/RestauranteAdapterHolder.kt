package com.example.desafio02_dh

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class RestauranteAdapterHolder(private val view: View):RecyclerView.ViewHolder(view) {
    private val nomeRestaurante : TextView = view.findViewById(R.id.txtRestaurante_fMenu)
    private val enderecoRestaurante : TextView = view.findViewById(R.id.txtEndereco_fMenu)
    private val horarioFechamentoRestaurante : TextView = view.findViewById(R.id.txtHorarioFecha_fMenu)

    fun bind(restaurante:Restaurante){
        nomeRestaurante.text = restaurante.nome
        enderecoRestaurante.text = restaurante.endereco
        horarioFechamentoRestaurante.text = restaurante.horarioFechamento
    }
}