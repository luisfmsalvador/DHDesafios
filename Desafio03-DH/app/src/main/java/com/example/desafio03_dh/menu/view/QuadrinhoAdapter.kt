package com.example.desafio03_dh.menu.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.desafio03_dh.R
import com.example.desafio03_dh.menu.model.QuadrinhoModel

class QuadrinhoAdapter(private var quadrinhos: MutableList<QuadrinhoModel>): RecyclerView.Adapter<QuadrinhoViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): QuadrinhoViewHolder {
        val inflador = LayoutInflater.from(parent.context).inflate(R.layout.lista_menu, parent, false)
        return QuadrinhoViewHolder(inflador)
    }

    override fun getItemCount() = quadrinhos.size

    override fun onBindViewHolder(holder: QuadrinhoViewHolder, position: Int) {
        val item= quadrinhos[position]

        holder.bind(item)
    }
}