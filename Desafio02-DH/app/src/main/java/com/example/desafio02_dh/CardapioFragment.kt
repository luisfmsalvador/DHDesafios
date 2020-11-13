package com.example.desafio02_dh

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.navigation.Navigation
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.desafio02_dh.listacardapio.model.Cardapio
import com.example.desafio02_dh.menu.view.MenuFragment
import com.google.android.material.card.MaterialCardView
import com.google.gson.Gson

private const val ARG_RESTAURANTE = ""


class CardapioFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: Int? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getInt(ARG_RESTAURANTE)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val minhaView = inflater.inflate(R.layout.fragment_cardapio, container, false)

        minhaView.findViewById<ImageView>(R.id.imgRestaurante_fCardapio)
            .setImageResource(R.mipmap.ic_rest1)

        val recyclerView = minhaView.findViewById<RecyclerView>(R.id.listaCardapio)

        val json = arguments?.getString(MenuFragment.RESTAURANTE_KEY)

        val restaurante = Gson().fromJson(json, Restaurante::class.java)
        minhaView.findViewById<TextView>(R.id.txtRestaurante_fCardapio).text = restaurante.nome
        minhaView.findViewById<ImageView>(R.id.imgRestaurante_fCardapio)
            .setImageResource(restaurante.imagem)

        val cardapioAdapter = CardapioAdapter(restaurante.cardapio) {
            val bundle = Bundle()
            val jsonString = Gson().toJson(it)
            bundle.putString(CARDAPIO_KEY, jsonString)

            val navController = Navigation.findNavController(minhaView)
            navController.navigate(R.id.action_cardapioFragment_to_pratoFragment, bundle)
        }

        val viewManager = GridLayoutManager(minhaView.context, 2)
        recyclerView.apply {
            setHasFixedSize(true)
            layoutManager = viewManager
            adapter = cardapioAdapter
        }

        return minhaView
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val navController = Navigation.findNavController(view)
        view.findViewById<ImageView>(R.id.imgReturn_fCardapio).setOnClickListener {
            navController.navigate(R.id.action_cardapioFragment_pop)
        }
    }

    companion object {
        const val CARDAPIO_KEY = "CARDAPIO_KEY"
    }
}