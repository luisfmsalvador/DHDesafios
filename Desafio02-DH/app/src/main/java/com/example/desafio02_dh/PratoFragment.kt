package com.example.desafio02_dh

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.example.desafio02_dh.listacardapio.model.Cardapio
import com.example.desafio02_dh.menu.view.MenuFragment
import com.google.gson.Gson


class PratoFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_prato, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val json = arguments?.getString(CardapioFragment.CARDAPIO_KEY)
        val cardapio = Gson().fromJson(json, Cardapio::class.java)

        view.findViewById<TextView>(R.id.txtDescricao_fPrato).text = cardapio.descricao
        view.findViewById<TextView>(R.id.txtNome_fPrato).text = cardapio.nome
        view.findViewById<ImageView>(R.id.imgPrato_fPrato).setImageResource(cardapio.imagem)
    }

}