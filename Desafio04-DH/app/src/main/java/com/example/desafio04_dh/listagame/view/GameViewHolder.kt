package com.example.desafio04_dh.listagame.view

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.desafio04_dh.R
import com.example.desafio04_dh.listagame.model.GameModel

class GameViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
    private val nome: TextView = view.findViewById(R.id.txtNameGame_FMenu)
    private val createdAt: TextView = view.findViewById(R.id.txtYearGame_FMenu)

    fun bind(game: GameModel) {
        nome.text = game.name
        createdAt.text = game.createdAt.toString()

        /*val imagemSplash = ContextCompat.getDrawable(view.context, cardapio.imagem)
        imagem.setImageDrawable(imagemSplash)*/
    }
}