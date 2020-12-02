package com.example.desafio03_dh.main.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.desafio03_dh.R
import com.example.desafio03_dh.menu.repository.CharacterRepository
import com.example.desafio03_dh.menu.viewmodel.CharacterViewModel

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }

    companion object {
    }

}