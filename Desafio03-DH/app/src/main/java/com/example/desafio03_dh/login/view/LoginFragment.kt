package com.example.desafio03_dh.login.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.example.desafio03_dh.R
import com.example.desafio03_dh.login.model.Usuario
import com.google.android.material.textfield.TextInputEditText

class LoginFragment : Fragment() {
    lateinit var minhaView: View

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

            val edtUsuario = minhaView.findViewById<TextInputEditText>(R.id.edtEmail_fLogin)
            val edtPassword = minhaView.findViewById<TextInputEditText>(R.id.edtPassword_fLogin)
            if (consiteDadosAutenticacao(edtUsuario, edtPassword)) {
                navigation.navigate(R.id.action_loginFragment_to_menuFragment)
            }
        }

        return minhaView
    }

    fun consiteDadosAutenticacao(emailUsuario: TextInputEditText, passwordUsuario: TextInputEditText): Boolean {
        when {
            emailUsuario.text!!.isEmpty() -> {
                emailUsuario.error = "Informe o e-mail"
                emailUsuario.requestFocus()
            }
            !android.util.Patterns.EMAIL_ADDRESS.matcher(emailUsuario.text).matches() -> {
                emailUsuario.error = "E-mail inválido"
                emailUsuario.requestFocus()
            }
            passwordUsuario.text!!.isEmpty() -> {
                passwordUsuario.error = "Informe a senha"
                passwordUsuario.requestFocus()
            }
            else -> return true
        }
        return false
    }
}