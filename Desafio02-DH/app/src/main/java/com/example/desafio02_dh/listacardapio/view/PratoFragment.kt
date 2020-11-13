package com.example.desafio02_dh.listacardapio.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.navigation.Navigation
import com.example.desafio02_dh.R
import com.example.desafio02_dh.listacardapio.model.Cardapio
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

        val navController = Navigation.findNavController(view)
        view.findViewById<ImageView>(R.id.imgReturn_fPrato).setOnClickListener {
            navController.navigate(R.id.action_pratoFragment_pop)
        }
    }

}