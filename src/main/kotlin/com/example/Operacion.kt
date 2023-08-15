package com.example

import kotlinx.serialization.Serializable

@Serializable
data class Operacion (
  val valor1: Int,
  val operador: String,
  val valor2: Int
)