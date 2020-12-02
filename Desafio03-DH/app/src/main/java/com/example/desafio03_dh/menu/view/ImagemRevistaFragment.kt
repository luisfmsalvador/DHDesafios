package com.example.desafio03_dh.menu.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.navigation.Navigation
import com.example.desafio03_dh.R
import com.squareup.picasso.Picasso

class ImagemRevistaFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_imagem_revista, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val imagemQuadrinho = view.findViewById<ImageView>(R.id.imgCapaRevista_fImagemRevista)
        val caminhoImagemQuadrinho = arguments?.getString("imgComic")

        Picasso.get()
            .load(caminhoImagemQuadrinho)
            .into(imagemQuadrinho)

        view.findViewById<ImageView>(R.id.imgReturn_fImagemRevista).setOnClickListener {
            val navigation = Navigation.findNavController(view)
            navigation.popBackStack()
        }
    }
}