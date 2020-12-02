package com.example.desafio03_dh.login.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.navigation.Navigation
import com.example.desafio03_dh.R
import com.example.desafio03_dh.login.model.Usuario
import com.google.android.material.textfield.TextInputEditText

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
            val edtNomeUsuario = minhaView.findViewById<TextInputEditText>(R.id.edtName_fCreateAccount)
            val edtEmailUsuario = minhaView.findViewById<TextInputEditText>(R.id.edtEmail_fCreateAccount)
            val edtPasswordUsuario = minhaView.findViewById<TextInputEditText>(R.id.edtPassword_fCreateAccount)

            if (consiteDadosRegistro(
                    edtNomeUsuario,
                    edtEmailUsuario,
                    edtPasswordUsuario
                )
            ) {
                val usuario = Usuario(
                    edtNomeUsuario.text.toString(),
                    edtEmailUsuario.text.toString(),
                    edtPasswordUsuario.text.toString()
                )

                navigation.navigate(R.id.action_createAccountFragment_to_menuFragment)
            }
        }

        minhaView.findViewById<ImageView>(R.id.imgReturn_fCreateAccount).setOnClickListener {
            val navigation = Navigation.findNavController(minhaView)
            navigation.popBackStack()
        }
        return minhaView
    }

    fun consiteDadosRegistro(
        nomeUsuario: TextInputEditText,
        emailUsuario: TextInputEditText,
        passwordUsuario: TextInputEditText
    ): Boolean {
        when {
            nomeUsuario.text!!.isEmpty() -> {
                nomeUsuario.error = "Informe o nome do usuário"
                nomeUsuario.requestFocus()
            }
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
            passwordUsuario.text!!.length < 3 -> {
                passwordUsuario.error = "Senha deve ter ao menos três caracteres"
                passwordUsuario.requestFocus()
            }
            else -> return true
        }
        return false
    }
}