package com.example.desafio02_dh.menu.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.desafio02_dh.R
import com.example.desafio02_dh.Restaurante
import com.example.desafio02_dh.RestauranteAdapter
import com.example.desafio02_dh.listacardapio.model.Cardapio
import com.google.gson.Gson


class MenuFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var minhaView = inflater.inflate(R.layout.fragment_menu, container, false)

        val recyclerView = minhaView.findViewById<RecyclerView>(R.id.listaRestaurante)

        val restaurantes = arrayListOf(
            Restaurante(
                "Tony Roma's",
                "22:00",
                "Av. Lavandisca, 717 - Indianópolis, São Paulo",
                R.mipmap.ic_rest1,
                arrayListOf(
                    Cardapio("Prato1", "Prato delicioso 1", R.mipmap.ic_rest1),
                    Cardapio("Prato2", "Prato delicioso2", R.mipmap.ic_rest2),
                    Cardapio("Prato3", "Prato delicioso3", R.mipmap.ic_rest3),
                    Cardapio("Prato4", "Prato delicioso4", R.mipmap.ic_rest1),
                    Cardapio("Prato5", "Prato delicioso5", R.mipmap.ic_rest1),
                    Cardapio("Prato6", "Prato delicioso6", R.mipmap.ic_rest2),
                    Cardapio("Prato7", "Prato delicioso7", R.mipmap.ic_rest3),
                    Cardapio("Prato8", "Prato delicioso8", R.mipmap.ic_rest1)
                )
            ),
            Restaurante(
                "Aoyama - Moema",
                "00:00",
                "Alameda dos Arapanés, 421 - Moema, São Paulo",
                R.mipmap.ic_rest2,
                arrayListOf(
                    Cardapio("Prato1", "Prato delicioso1", R.mipmap.ic_rest1),
                    Cardapio("Prato2", "Prato delicioso2", R.mipmap.ic_rest2),
                    Cardapio("Prato3", "Prato delicioso3", R.mipmap.ic_rest3),
                    Cardapio("Prato7", "Prato delicioso7", R.mipmap.ic_rest3),
                    Cardapio("Prato8", "Prato delicioso8", R.mipmap.ic_rest1)
                )
            ),
            Restaurante(
                "Outback - Moema", "00:00", "Av. Moaci, 187 - Moema, São Paulo", R.mipmap.ic_rest3,
                arrayListOf(
                    Cardapio("Prato5", "Prato delicioso5", R.mipmap.ic_rest1),
                    Cardapio("Prato6", "Prato delicioso6", R.mipmap.ic_rest2),
                    Cardapio("Prato7", "Prato delicioso7", R.mipmap.ic_rest3),
                    Cardapio("Prato8", "Prato delicioso8", R.mipmap.ic_rest1)
                )
            ),
            Restaurante(
                "Sí Señor!", "01:00", "Alameda Jauaperi, 626 - Moema, São Paulo", R.mipmap.ic_rest4,
                arrayListOf(
                    Cardapio("Prato1", "Prato delicioso1", R.mipmap.ic_rest1),
                    Cardapio("Prato2", "Prato delicioso2", R.mipmap.ic_rest2),
                    Cardapio("Prato3", "Prato delicioso3", R.mipmap.ic_rest3),
                    Cardapio("Prato7", "Prato delicioso7", R.mipmap.ic_rest3),
                    Cardapio("Prato8", "Prato delicioso8", R.mipmap.ic_rest1)
                )
            )
        )

        val restauranteAdapter = RestauranteAdapter(restaurantes) {

            val navController = Navigation.findNavController(minhaView)

            val bundle = Bundle()
            val jsonString = Gson().toJson(it)
            bundle.putString(RESTAURANTE_KEY, jsonString)

            navController.navigate(R.id.action_menuFragment_to_cardapioFragment, bundle)
        }
        val viewManager = LinearLayoutManager(minhaView.context)
        recyclerView.apply {
            setHasFixedSize(true)
            layoutManager = viewManager
            adapter = restauranteAdapter
        }

        return minhaView
    }

    companion object {
        const val RESTAURANTE_KEY = "RESTAURANTE_KEY"
    }
}