package com.example.desafio02_dh

import com.example.desafio02_dh.listacardapio.model.Cardapio

data class Restaurante(
  val nome:String,
  val horarioFechamento:String,
  val endereco:String,
  val imagem:Int,
  val cardapio: List<Cardapio>
)