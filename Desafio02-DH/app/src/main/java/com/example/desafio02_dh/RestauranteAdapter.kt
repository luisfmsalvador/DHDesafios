package com.example.desafio02_dh

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView

class RestauranteAdapter(private val dataSet: List<Restaurante>, private val listener: (Restaurante) -> Unit):RecyclerView.Adapter<RestauranteAdapterHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RestauranteAdapterHolder {
        val inflador = LayoutInflater.from(parent.context).inflate(R.layout.lista_restaurantes,parent,false)

        return RestauranteAdapterHolder(inflador)
    }

    override fun getItemCount() = dataSet.size

    override fun onBindViewHolder(holder: RestauranteAdapterHolder, position: Int) {
        holder.bind(dataSet[position])
        holder.itemView.setOnClickListener { listener(dataSet[position])}

    }


}