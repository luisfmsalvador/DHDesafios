package com.example.desafio03_dh.menu.view

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.observe
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.desafio03_dh.R
import com.example.desafio03_dh.menu.model.QuadrinhoModel
import com.example.desafio03_dh.menu.repository.QuadrinhoRepository
import com.example.desafio03_dh.menu.viewmodel.QuadrinhoViewModel

class MenuFragment : Fragment() {
    lateinit var _view: View
    private lateinit var _listaAdapter: QuadrinhoAdapter
    private var _listaDeQuadrinhos = mutableListOf<QuadrinhoModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_menu, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        _view = view

        val _viewModel = ViewModelProvider(
            this,
            QuadrinhoViewModel.QuadrinhoViewModelFactory(QuadrinhoRepository())
        ).get(QuadrinhoViewModel::class.java)

        _viewModel.listaDeQuadrinhosData.observe(viewLifecycleOwner, Observer {
            _listaDeQuadrinhos.clear()
            _listaDeQuadrinhos.addAll(it)

            val listaAdapter = QuadrinhoAdapter(_listaDeQuadrinhos)
            val recyclerView = _view.findViewById<RecyclerView>(R.id.recyclerMenu)
            val manager = GridLayoutManager(view.context,3)

            recyclerView.apply {
                setHasFixedSize(true)

                layoutManager = manager
                adapter = listaAdapter

            }

        })

        _viewModel.obterLista()


    }
}