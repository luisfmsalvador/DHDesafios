package com.example.desafio02_dh

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.navigation.Navigation
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.desafio02_dh.listacardapio.model.Cardapio
import com.google.android.material.card.MaterialCardView

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

        minhaView.findViewById<ImageView>(R.id.imgRestaurante_fCardapio).setImageResource(R.mipmap.ic_rest1)

        val recyclerView = minhaView.findViewById<RecyclerView>(R.id.listaCardapio)

        val cardapios = arrayListOf(
            Cardapio(
                "XXXXX",
                "fdfsfsfsd",
                R.mipmap.ic_rest1
            ),
            Cardapio(
                "XXXXX",
                "fdfsfsfsd",
                R.mipmap.ic_rest1
            ),
            Cardapio(
                "XXXXX",
                "fdfsfsfsd",
                R.mipmap.ic_rest1
            ),
            Cardapio(
                "XXXXX",
                "fdfsfsfsd",
                R.mipmap.ic_rest1
            ),
            Cardapio(
                "XXXXX",
                "fdfsfsfsd",
                R.mipmap.ic_rest1
            ),
            Cardapio(
                "XXXXX",
                "fdfsfsfsd",
                R.mipmap.ic_rest1
            ),
            Cardapio(
                "XXXXX",
                "fdfsfsfsd",
                R.mipmap.ic_rest1
            )
        )

        val cardapioAdapter = CardapioAdapter(cardapios) {
            val navController = Navigation.findNavController(minhaView)
            minhaView.findViewById<MaterialCardView>(R.id.cardCardapio).setOnClickListener {
                navController.navigate(R.id.pratoFragment)
            }
        }

        val viewManager = GridLayoutManager(minhaView.context,2)
        recyclerView.apply {
            setHasFixedSize(true)
            layoutManager = viewManager
            adapter = cardapioAdapter
        }

        return minhaView
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }

    companion object {
        @JvmStatic
        fun newInstance(nome: String) =
            CardapioFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_RESTAURANTE, nome)

                }
            }
    }
}