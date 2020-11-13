package com.example.desafio02_dh

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.desafio02_dh.listacardapio.model.Cardapio

class CardapioAdapter(val dataSet: List<Cardapio>, private val listener: (Cardapio) -> Unit):RecyclerView.Adapter<CardapioAdapterHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardapioAdapterHolder {
        val inflador = LayoutInflater.from(parent.context).inflate(R.layout.lista_pratos,parent,false)

        return CardapioAdapterHolder(inflador)
    }

    override fun getItemCount() = dataSet.size

    override fun onBindViewHolder(holder: CardapioAdapterHolder, position: Int) {
        holder.bind(dataSet[position])
        holder.itemView.setOnClickListener { listener(dataSet[position])}
    }


}