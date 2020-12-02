package com.example.desafio03_dh.menu.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.desafio03_dh.R
import com.example.desafio03_dh.menu.model.ComicModel

class ComicAdapter(
    private var quadrinhos: MutableList<ComicModel>,
    private val listener: (ComicModel) -> Unit
) : RecyclerView.Adapter<ComicViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ComicViewHolder {
        val inflador =
            LayoutInflater.from(parent.context).inflate(R.layout.lista_menu, parent, false)
        return ComicViewHolder(inflador)
    }

    override fun getItemCount() = quadrinhos.size

    override fun onBindViewHolder(holder: ComicViewHolder, position: Int) {
        val item = quadrinhos[position]

        holder.bind(item)

        holder.itemView.setOnClickListener { listener(item) }
    }
}