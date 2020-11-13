package com.example.desafio02_dh.menu.view

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.navigation.Navigation
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.desafio02_dh.R
import com.example.desafio02_dh.Restaurante
import com.example.desafio02_dh.RestauranteAdapter
import com.google.android.material.card.MaterialCardView

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [MenuFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class MenuFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var minhaView = inflater.inflate(R.layout.fragment_menu, container, false)

        val recyclerView = minhaView.findViewById<RecyclerView>(R.id.listaRestaurante)

        val restaurantes = arrayListOf(
            Restaurante("XXXXX", "XXXX", "xxxxx"),
            Restaurante("WWWWW", "WWWW", "WWWWW"),
            Restaurante("YYYYY", "YYYY", "YYYYY")
        )

        val navController = Navigation.findNavController(minhaView)

        val restauranteAdapter = RestauranteAdapter(restaurantes) {
            minhaView.findViewById<MaterialCardView>(R.id.cardRestaurante).setOnClickListener {
                navController.navigate(R.id.cardapioFragment)
            }
        }
        val viewManager = LinearLayoutManager(minhaView.context)
        recyclerView.apply {
            setHasFixedSize(true)
            layoutManager = viewManager
            adapter = restauranteAdapter

            addItemDecoration(DividerItemDecoration(context, DividerItemDecoration.VERTICAL))

        }

        return minhaView
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment MenuFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            MenuFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}