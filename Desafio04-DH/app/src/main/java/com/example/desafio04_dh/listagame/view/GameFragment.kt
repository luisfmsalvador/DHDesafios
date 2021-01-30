package com.example.desafio04_dh.listagame.view

import android.app.Activity.RESULT_OK
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import androidx.core.content.ContextCompat
import androidx.navigation.Navigation
import com.example.desafio04_dh.R
import com.example.desafio04_dh.listagame.model.GameModel
import com.google.android.material.textfield.TextInputEditText
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.google.firebase.storage.FirebaseStorage

private const val MODOENTRADA = "MODOENTRADA"
private const val IDGAME = "IDGAME"

class GameFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var modoEntrada: String? = null
    private var idGame: String? = null
    private var imageURI: Uri? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            modoEntrada = it.getString(MODOENTRADA)
            idGame = it.getString(IDGAME)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_game, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val imagemFundo = ContextCompat.getDrawable(view.context, R.drawable.splash_img)
        view.findViewById<ImageView>(R.id.imgFundo_fGame).setImageDrawable(imagemFundo)

        val name = view.findViewById<TextInputEditText>(R.id.edtName_fGame)
        val createdAt = view.findViewById<TextInputEditText>(R.id.edtCreateAt_fGame)
        val description = view.findViewById<TextInputEditText>(R.id.edtDescription_fGame)

        view.findViewById<Button>(R.id.btnImagem_fGame).setOnClickListener {
            procurarArquivo()
        }

        view.findViewById<Button>(R.id.btnSave_fGame).setOnClickListener {
            if (consisteTela(name, createdAt, description)){
                val usuario = FirebaseAuth.getInstance().currentUser?.uid.toString()
                val game = GameModel(name.text.toString(), createdAt.text.toString().toInt(), description.text.toString())
                val firebaseDatabase = FirebaseDatabase.getInstance()

                firebaseDatabase.getReference("Usuarios")
                                 .child(usuario)
                                 .child(name.text.toString())
                                 .setValue(game)

                imageURI?.run {
                    val StorageRef = FirebaseStorage.getInstance().getReference("uploads")
                    val fileReference = StorageRef.child(usuario).child(name.text.toString())
                    fileReference.putFile(this)
                        .addOnSuccessListener {
                            
                        }

                }

                val navigation = Navigation.findNavController(it)
                navigation.popBackStack()
            }
        }
    }

    fun consisteTela(name: TextInputEditText, createdAt: TextInputEditText, description:TextInputEditText):Boolean{
        when {
            (name.text.toString().isEmpty()) -> {
                name.setError("Informe o nome do game")
                name.requestFocus()
                return false
            }
            (createdAt.text.toString().isEmpty()) -> {
                createdAt.setError("Informe a data de criação do game")
                createdAt.requestFocus()
                return false
            }
            (createdAt.text.toString().toInt() < 1900) -> {
                createdAt.setError("Data de criação deve ser maior que 1900")
                createdAt.requestFocus()
                return false
            }
            (createdAt.text.toString().toInt() > 2021) -> {
                createdAt.setError("Data de criação deve ser menor/igual a 2021")
                createdAt.requestFocus()
                return false
            }
            (description.text.toString().isEmpty()) -> {
                description.setError("Informe a descrição do game")
                description.requestFocus()
                return false
            }
        }

        return true
    }

    fun procurarArquivo(){
        val intent = Intent()
        intent.type = "image/"
        intent.action = Intent.ACTION_GET_CONTENT
        startActivityForResult(intent, CONTENT_REQUEST_CODE)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == CONTENT_REQUEST_CODE && resultCode == RESULT_OK) {
            imageURI = data?.data
        }
    }

    companion object {
        @JvmStatic
        fun newInstance(modoEntrada: String, idGame: String) =
            GameFragment().apply {
                arguments = Bundle().apply {
                    putString(MODOENTRADA, modoEntrada)
                    putString(IDGAME, idGame)
                }
            }

        const val CONTENT_REQUEST_CODE = 1
    }
}