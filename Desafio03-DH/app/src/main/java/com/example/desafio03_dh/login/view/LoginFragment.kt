package com.example.desafio03_dh.login.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.example.desafio03_dh.R

class LoginFragment : Fragment() {
    lateinit var minhaView:View

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        minhaView = inflater.inflate(R.layout.fragment_login, container, false)

        // Inflate the layout for this fragment
        minhaView.findViewById<Button>(R.id.btnSign_fLogin).setOnClickListener {
            val navigation = Navigation.findNavController(it)
            navigation.navigate(R.id.action_loginFragment_to_createAccountFragment)
        }

        minhaView.findViewById<Button>(R.id.btnLogin_fLogin).setOnClickListener {
            val navigation = Navigation.findNavController(it)
            navigation.navigate(R.id.action_loginFragment_to_menuFragment)
        }

        return minhaView
    }

}