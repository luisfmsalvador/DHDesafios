package com.example.desafio04_dh.listagame.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.desafio04_dh.R
import com.example.desafio04_dh.listagame.model.GameModel

class GameAdapter(val dataSet: List<GameModel>, private val listener: (GameModel) -> Unit) :
    RecyclerView.Adapter<GameViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GameViewHolder {
        val inflador =
            LayoutInflater.from(parent.context).inflate(R.layout.lista_menu, parent, false)

        return GameViewHolder(
            inflador
        )
    }

    override fun getItemCount() = dataSet.size

    override fun onBindViewHolder(holder: GameViewHolder, position: Int) {
        holder.bind(dataSet[position])
        holder.itemView.setOnClickListener { listener(dataSet[position]) }
    }


}