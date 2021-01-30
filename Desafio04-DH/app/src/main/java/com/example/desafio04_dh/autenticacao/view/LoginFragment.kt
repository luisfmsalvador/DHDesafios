package com.example.desafio04_dh.autenticacao.view

import android.content.Context
import android.content.SharedPreferences
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
import com.google.android.material.checkbox.MaterialCheckBox
import com.google.android.material.textfield.TextInputEditText
import com.google.firebase.auth.FirebaseAuth


class LoginFragment : Fragment() {
    private lateinit var minhaView: View
    private val mAuth = FirebaseAuth.getInstance()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        minhaView = inflater.inflate(R.layout.fragment_login, container, false)

        val preferences = this.activity?.getSharedPreferences(APP_NAME, Context.MODE_PRIVATE)
        if (preferences?.getBoolean(LoginFragment.KEEP_CONNECTED_PREFS,false)!!){
            val email = preferences?.getString(LoginFragment.USER_PREFS,"")
            val senha = preferences?.getString(LoginFragment.PASSWORD_PREFS,"")

            autenticaUsuario(email!!,senha!!)
        }

        return minhaView
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val email = minhaView.findViewById<TextInputEditText>(R.id.edtEmail_fLogin)
        val senha = minhaView.findViewById<TextInputEditText>(R.id.edtPassword_fLogin)
        val isRemember = minhaView.findViewById<MaterialCheckBox>(R.id.ckbRemember)

        val imagemFundo = ContextCompat.getDrawable(view.context, R.drawable.splash_img)
        view.findViewById<ImageView>(R.id.imgFundo_fLogin).setImageDrawable(imagemFundo)

        view.findViewById<Button>(R.id.btnLogin_fLogin).setOnClickListener {
            if (consisteTela(email,senha)) {
                setPreferences(isRemember, email, senha)
                autenticaUsuario(email.text.toString(),senha.text.toString())
            }
        }

        view.findViewById<Button>(R.id.btnSign_fLogin).setOnClickListener {
            val navigation = Navigation.findNavController(it)
            navigation.navigate(R.id.action_loginFragment_to_createAccountFragment)
        }
    }

    fun consisteTela(email: TextInputEditText, senha:TextInputEditText):Boolean{
        when {
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
        }

        return true
    }

    fun setPreferences(isRemember: MaterialCheckBox, email: TextInputEditText, senha: TextInputEditText){
        val preferences = this.activity?.getSharedPreferences(APP_NAME, Context.MODE_PRIVATE)
        preferences?.edit()?.putBoolean(KEEP_CONNECTED_PREFS,isRemember.isChecked)?.apply()
        if (isRemember.isChecked) {
            preferences?.edit()?.putString(PASSWORD_PREFS,senha.text.toString())?.apply()
            preferences?.edit()?.putString(USER_PREFS,email.text.toString())?.apply()
        } else {
            preferences?.edit()?.putString(PASSWORD_PREFS,"")?.apply()
            preferences?.edit()?.putString(USER_PREFS,"")?.apply()
        }
    }

    fun autenticaUsuario(email:String, senha:String){
        mAuth.signInWithEmailAndPassword(email,senha)
            .addOnCompleteListener(OnCompleteListener {
                if (it.isSuccessful) {
                    val navigation = Navigation.findNavController(minhaView)
                    navigation.navigate(R.id.action_loginFragment_to_menuFragment)
                } else {
                    Toast.makeText(minhaView.context, "Falha de autenticação.",
                        Toast.LENGTH_LONG).show()
                }
            })
    }
    companion object {
        private const val APP_NAME = "DESAFIO04"
        private const val KEEP_CONNECTED_PREFS = "KEEP_CONNECTED_PREFS"
        private const val PASSWORD_PREFS = "PASSWORD_PREFS"
        private const val USER_PREFS = "USER_PREFS"
    }
}