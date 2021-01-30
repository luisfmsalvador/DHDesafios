package com.example.desafio04_dh.main.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.ImageView
import androidx.core.content.ContextCompat
import com.example.desafio04_dh.R
import com.example.desafio04_dh.autenticacao.view.LoginFragment

class SplashScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        val imagemSplash = ContextCompat.getDrawable(this, R.drawable.splash_img)
        findViewById<ImageView>(R.id.imgSplash_fSplash).setImageDrawable(imagemSplash)

        Handler(Looper.getMainLooper()).postDelayed(Runnable {


            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()

        },1000)
    }
}