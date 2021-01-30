package com.example.desafio04_dh.autenticacao.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.example.desafio04_dh.R
import com.google.android.gms.tasks.OnCompleteListener
import com.google.android.material.textfield.TextInputEditText
import com.google.firebase.auth.EmailAuthProvider
import com.google.firebase.auth.FirebaseAuth

class CreateAccountFragment : Fragment() {
    private val mAuth = FirebaseAuth.getInstance();

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_create_account, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val imagemFundo = ContextCompat.getDrawable(view.context, R.drawable.splash_img)
        view.findViewById<ImageView>(R.id.imgFundo_fCreateAccount).setImageDrawable(imagemFundo)

        view.findViewById<Button>(R.id.btnSave_fCreateAccount).setOnClickListener {

            val email = view.findViewById<TextInputEditText>(R.id.edtEmail_fCreateAccount)
            val password = view.findViewById<TextInputEditText>(R.id.edtPassword_fCreateAccount)
            val repeatPassword = view.findViewById<TextInputEditText>(R.id.edtRepeatPassword_fCreateAccount)
            val nome = view.findViewById<TextInputEditText>(R.id.edtName_fCreateAccount)

            if (consisteTela(nome,email,password,repeatPassword)) {
                mAuth.createUserWithEmailAndPassword(email.text.toString(), password.text.toString())
                    .addOnCompleteListener(OnCompleteListener {
                        if (it.isSuccessful) {
                            val navigation = Navigation.findNavController(view)
                            navigation.popBackStack()
                        } else {
                            Toast.makeText(view.context, "Falha de autenticação. " + it.exception.toString(),
                                Toast.LENGTH_LONG).show()
                        }
                    })
            }
        }
    }

    fun consisteTela(nome: TextInputEditText, email: TextInputEditText, senha:TextInputEditText, repeatSenha:TextInputEditText):Boolean{
        when {
            (nome.text.toString().isEmpty()) -> {
                nome.setError("Informe o nome")
                nome.requestFocus()
                return false
            }
            (email.text.toString().isEmpty()) -> {
                email.setError("Informe o e-mail")
                email.requestFocus()
                return false
            }
            (!android.util.Patterns.EMAIL_ADDRESS.matcher(email.text).matches())-> {
                email.error = "E-mail inválido"
                email.requestFocus()
                return false
            }
            (senha.text.toString().isEmpty()) -> {
                senha.setError("Informa a senha")
                senha.requestFocus()
                return false
            }
            (repeatSenha.text.toString().isEmpty()) -> {
                repeatSenha.setError("Confirme a senha")
                repeatSenha.requestFocus()
                return false
            }
            (repeatSenha.text.toString() != senha.text.toString()) -> {
                repeatSenha.setError("Confirmação de senha inválida")
                repeatSenha.requestFocus()
                return false
            }
        }

        return true
    }
}