package com.example.desafio02_dh

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.example.desafio02_dh.login.model.Usuario
import org.w3c.dom.Text


class RegistroFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_registro, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val navController = Navigation.findNavController(view)

        view.findViewById<ImageView>(R.id.imgReturn_fRegistro).setOnClickListener {
            navController.navigate(R.id.action_registroFragment_pop2)
        }

        view.findViewById<Button>(R.id.btnLogin_fRegister).setOnClickListener {
            val edtNomeUsuario = view.findViewById<TextView>(R.id.edtNome_fRegister)
            val edtEmailUsuario = view.findViewById<TextView>(R.id.edtEmail_fRegister)
            val edtPasswordUsuario = view.findViewById<TextView>(R.id.edtPassword_fRegister)
            val edtRepeatPasswordUsuario = view.findViewById<TextView>(R.id.edtRepeatPassword_fRegister)

            if (consiteDadosRegistro(edtNomeUsuario, edtEmailUsuario, edtPasswordUsuario,edtRepeatPasswordUsuario)){
                val usuario = Usuario(edtNomeUsuario.text.toString(),edtEmailUsuario.text.toString(),edtPasswordUsuario.text.toString())

                navController.navigate(R.id.action_registroFragment_to_menuFragment)
            }
        }
    }

    fun consiteDadosRegistro(nomeUsuario:TextView, emailUsuario: TextView, passwordUsuario: TextView, repeatPasswordUsuario: TextView):Boolean {
        when {
            nomeUsuario.text.isEmpty() -> {
                nomeUsuario.error = "Informe o nome do usuário"
                nomeUsuario.requestFocus()
            }
            emailUsuario.text.isEmpty() -> {
                emailUsuario.error = "Informe o e-mail"
                emailUsuario.requestFocus()
            }
            !android.util.Patterns.EMAIL_ADDRESS.matcher(emailUsuario.text).matches() -> {
                emailUsuario.error = "E-mail inválido"
                emailUsuario.requestFocus()
            }
            passwordUsuario.text.isEmpty() -> {
                passwordUsuario.error = "Informe a senha"
                passwordUsuario.requestFocus()
            }
            passwordUsuario.text.length < 3 -> {
                passwordUsuario.error = "Senha deve ter ao menos três caracteres"
                passwordUsuario.requestFocus()
            }
            repeatPasswordUsuario.text.isEmpty() -> {
                passwordUsuario.error = "Informe a confirmação de senha"
                passwordUsuario.requestFocus()
            }
            passwordUsuario.text.toString() != repeatPasswordUsuario.text.toString() -> {
                repeatPasswordUsuario.error = "Confirmação de senha incorreta"
                repeatPasswordUsuario.requestFocus()
            }
            else -> return true
        }
        return false
    }
}