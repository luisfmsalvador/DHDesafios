package com.example.desafio03_dh.menu.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import com.example.desafio03_dh.R
import com.example.desafio03_dh.menu.repository.CharacterRepository
import com.example.desafio03_dh.menu.viewmodel.CharacterViewModel
import com.squareup.picasso.Picasso

class DetalheRevistaFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_detalhe_revista, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.findViewById<ImageView>(R.id.imgReturn_fDetalheRevista).setOnClickListener {
            val navigation = Navigation.findNavController(view)
            navigation.popBackStack()
        }

        val imagemPersonagem = view.findViewById<ImageView>(R.id.imgPersonagem_fDetalheRevista)
        val caminhoImagemPersonagem =  arguments?.getString("imgCharacter")

        Picasso.get()
            .load(caminhoImagemPersonagem)
            .into(imagemPersonagem)

        view.findViewById<TextView>(R.id.txtTitulo_fDetalheRevista).text =arguments?.getString("txtTitulo")?.toUpperCase()
        view.findViewById<TextView>(R.id.txtTexto_fDetalheRevista).text = arguments?.getString("txtDescricao")
        view.findViewById<TextView>(R.id.txtPage_fDetalheRevista).text = arguments?.getInt("qtdePaginas").toString()
        view.findViewById<TextView>(R.id.txtPublicacao_fDetalheRevista).text = arguments?.getString("txtData")
        view.findViewById<TextView>(R.id.txtPrice_fDetalheRevista).text = arguments?.getDouble("vlPreco").toString()


        val imagemQuadrinho = view.findViewById<ImageView>(R.id.imgCapaRevista_fDetalheRevista)
        val caminhoImagemQuadrinho = arguments?.getString("imgComic")

        Picasso.get()
            .load(caminhoImagemQuadrinho)
            .into(imagemQuadrinho)

        imagemQuadrinho.setOnClickListener {
            val bundle = Bundle()
            bundle.putString("imgComic",caminhoImagemQuadrinho)

            val navigation = Navigation.findNavController(view)
            navigation.navigate(R.id.action_detalheRevistaFragment_to_imagemRevistaFragment,bundle)
        }
    }
}