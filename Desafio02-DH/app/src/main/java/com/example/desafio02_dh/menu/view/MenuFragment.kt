package com.example.desafio02_dh.menu.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.desafio02_dh.R
import com.example.desafio02_dh.Restaurante
import com.example.desafio02_dh.RestauranteAdapter
import com.google.android.material.card.MaterialCardView


class MenuFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var minhaView = inflater.inflate(R.layout.fragment_menu, container, false)

        val recyclerView = minhaView.findViewById<RecyclerView>(R.id.listaRestaurante)

        val restaurantes = arrayListOf(
            Restaurante("Tony Roma's", "22:00", "Av. Lavandisca, 717 - Indianópolis, São Paulo", R.mipmap.ic_rest1),
            Restaurante("Aoyama - Moema", "00:00", "Alameda dos Arapanés, 421 - Moema, São Paulo", R.mipmap.ic_rest2),
            Restaurante("Outback - Moema", "00:00", "Av. Moaci, 187 - Moema, São Paulo", R.mipmap.ic_rest3),
            Restaurante("Sí Señor!", "01:00", "Alameda Jauaperi, 626 - Moema, São Paulo", R.mipmap.ic_rest4)
        )

        val restauranteAdapter = RestauranteAdapter(restaurantes) {
            val navController = Navigation.findNavController(minhaView)
            minhaView.findViewById<MaterialCardView>(R.id.cardRestaurante).setOnClickListener {
                navController.navigate(R.id.action_menuFragment_to_cardapioFragment)
            }
        }
        val viewManager = LinearLayoutManager(minhaView.context)
        recyclerView.apply {
            setHasFixedSize(true)
            layoutManager = viewManager
            adapter = restauranteAdapter
        }

        return minhaView
    }

}