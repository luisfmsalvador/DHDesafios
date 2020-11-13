package com.example.desafio02_dh.login.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.Navigation
import com.example.desafio02_dh.R

class LoginFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_login, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val navController = Navigation.findNavController(view)

        view.findViewById<Button>(R.id.btnLogin_fLogin).setOnClickListener {
            navController.navigate(R.id.action_loginFragment_to_menuFragment)
        }

        view.findViewById<Button>(R.id.btnRegister_fLogin).setOnClickListener {
            navController.navigate(R.id.action_loginFragment_to_registroFragment)
        }
    }
}