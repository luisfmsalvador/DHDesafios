package com.example.desafio04_dh.menu.view

import android.os.Build
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.navigation.Navigation
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.desafio04_dh.R
import com.example.desafio04_dh.listagame.model.GameModel
import com.example.desafio04_dh.listagame.view.GameAdapter
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class MenuFragment : Fragment() {

    lateinit var minhaView:View

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        minhaView = inflater.inflate(R.layout.fragment_menu, container, false)
        return minhaView
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val usuario = FirebaseAuth.getInstance().currentUser?.uid.toString()

        view.findViewById<FloatingActionButton>(R.id.btnInserir_fMenu).setOnClickListener {
            val navigation = Navigation.findNavController(it)
            navigation.navigate(R.id.action_menuFragment_to_gameFragment)
        }

        carregaLista(usuario)
    }

    fun carregaLista(usuario:String){
        val _listaGames = mutableListOf<GameModel>()
        val databaseReference = FirebaseDatabase.getInstance()
        val myRef = databaseReference.getReference("Usuarios").child(usuario)

        myRef.addListenerForSingleValueEvent(object : ValueEventListener {
            override fun onCancelled(p0: DatabaseError) {
            }

            override fun onDataChange(p0: DataSnapshot) {
                for(ds in p0.children){
                    val game = ds.getValue(GameModel::class.java)
                    if (game != null) {
                        _listaGames.add(game)
                    }
                }

                val recyclerView = minhaView.findViewById<RecyclerView>(R.id.recyclerMenu)
                val manager = GridLayoutManager(minhaView.context, 2)
                val listaAdapter = GameAdapter(_listaGames, {})

                recyclerView.apply {
                    setHasFixedSize(true)

                    layoutManager = manager
                    adapter = listaAdapter
                }

            }
        })
    }
}