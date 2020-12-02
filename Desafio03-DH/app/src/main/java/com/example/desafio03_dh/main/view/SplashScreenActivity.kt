package com.example.desafio03_dh.main.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import com.example.desafio03_dh.R

class SplashScreenActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

/*        val _viewModel = ViewModelProvider(
            this,
            QuadrinhoViewModel.QuadrinhoViewModelFactory(QuadrinhoRepository())
        ).get(QuadrinhoViewModel::class.java)

        _viewModel.obterLista().observe(this, Observer {
            if (it.size == 1) {
            }
        })
*/

        Handler(Looper.getMainLooper()).postDelayed(Runnable {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        },3000)
    }
}