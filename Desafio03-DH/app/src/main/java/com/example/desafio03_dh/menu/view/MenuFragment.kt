package com.example.desafio03_dh.menu.view

import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.desafio03_dh.R
import com.example.desafio03_dh.menu.model.ComicModel
import com.example.desafio03_dh.menu.model.DateModel
import com.example.desafio03_dh.menu.model.PriceModel
import com.example.desafio03_dh.menu.repository.CharacterRepository
import com.example.desafio03_dh.menu.repository.ComicRepository
import com.example.desafio03_dh.menu.viewmodel.CharacterViewModel
import com.example.desafio03_dh.menu.viewmodel.ComicViewModel
import java.text.SimpleDateFormat
import java.util.*

class MenuFragment : Fragment() {
    private lateinit var _listaAdapter: ComicAdapter
    private var _listaDeQuadrinhos = mutableListOf<ComicModel>()
    private var _idCharacter: Int = 0
    private var _imgCharacter: String = ""

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_menu, container, false)
    }

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val _viewModelPersonagem = ViewModelProvider(
            this,
            CharacterViewModel.CharacterViewModelFactory(CharacterRepository())
        ).get(CharacterViewModel::class.java)

        val _viewModel = ViewModelProvider(
            this,
            ComicViewModel.ComicViewModelFactory(ComicRepository())
        ).get(ComicViewModel::class.java)

        _viewModelPersonagem.obterLista().observe(viewLifecycleOwner, Observer {
            _idCharacter = it[0].id
            _imgCharacter = "${it[0].thumbnail.diretorio}.${it[0].thumbnail.extensao}"
        })

        _viewModel.obterLista().observe(viewLifecycleOwner, Observer {
            _listaDeQuadrinhos.clear()
            _listaDeQuadrinhos.addAll(it)

            val listaAdapter = ComicAdapter(_listaDeQuadrinhos) {
                val navigation = Navigation.findNavController(view)

                val bundle = Bundle()
                bundle.putInt("idCharacter",_idCharacter)
                bundle.putString("imgCharacter",_imgCharacter)
                bundle.putString("imgComic","${it.thumbnail.diretorio}.${it.thumbnail.extensao}")
                bundle.putString("txtTitulo",it.titulo)
                bundle.putString("txtDescricao",it.descricao)
                bundle.putInt("qtdePaginas",it.paginas)
                bundle.putString("txtData",buscaDataPublicacao(it.datas))
                bundle.putDouble("vlPreco",buscaPreco(it.precos))

                navigation.navigate(R.id.action_menuFragment_to_detalheRevistaFragment, bundle)
            }

            val recyclerView = view.findViewById<RecyclerView>(R.id.recyclerMenu)
            val manager = GridLayoutManager(view.context,3)

            recyclerView.apply {
                setHasFixedSize(true)

                layoutManager = manager
                adapter = listaAdapter

            }
        })

        _viewModelPersonagem.obterLista()
        _viewModel.obterLista()
    }

    fun buscaPreco(precos: List<PriceModel>):Double {
        for(precos: PriceModel in precos){
            if (precos.tipo == "onsaleDate" || precos.tipo == "printPrice") {
                return precos.price
            }
        }
        return 0.0
    }

    fun buscaDataPublicacao(datas: List<DateModel>):String{
        val formato = SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH)
        val formatoExtenso = SimpleDateFormat("MMMM dd, yyyy", Locale.ENGLISH)
        lateinit var dataFormatada: Date
        try{
            for(data: DateModel in datas){
                if (data.tipo == "onsaleDate") {
                    val dataPublicacao = formato.parse(data.data)
                    return formatoExtenso.format(dataPublicacao).capitalize()
                }
            }
        } catch (e: Exception){
            return ""
        }
        return ""

    }
}

