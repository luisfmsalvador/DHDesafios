package com.example.desafio03_dh.login.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import androidx.navigation.Navigation
import com.example.desafio03_dh.R

class CreateAccountFragment : Fragment() {
    lateinit var minhaView: View
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        minhaView = inflater.inflate(R.layout.fragment_create_account, container, false)


        minhaView.findViewById<Button>(R.id.btnSave_fCreateAccount).setOnClickListener {
            val navigation = Navigation.findNavController(minhaView)
            navigation.navigate(R.id.action_createAccountFragment_to_menuFragment)
        }

        minhaView.findViewById<ImageView>(R.id.imgReturn_fCreateAccount).setOnClickListener {
            val navigation = Navigation.findNavController(minhaView)
            navigation.popBackStack()
        }
        return minhaView
    }

}