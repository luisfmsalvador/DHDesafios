package com.example.desafio02_dh.menu.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.desafio02_dh.R
import com.example.desafio02_dh.menu.model.Restaurante

class RestauranteAdapter(
    private val dataSet: List<Restaurante>,
    private val listener: (Restaurante) -> Unit
) : RecyclerView.Adapter<RestauranteAdapterHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RestauranteAdapterHolder {
        val inflador =
            LayoutInflater.from(parent.context).inflate(R.layout.lista_restaurantes, parent, false)

        return RestauranteAdapterHolder(
            inflador
        )
    }

    override fun getItemCount() = dataSet.size

    override fun onBindViewHolder(holder: RestauranteAdapterHolder, position: Int) {
        val item = dataSet[position]
        holder.bind(item)
        holder.itemView.setOnClickListener { listener(item) }

    }


}