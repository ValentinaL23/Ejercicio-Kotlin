package com.example

import kotlinx.serialization.Serializable

@Serializable
data class Operacion (
  var valor1: Int,
  var operador: String,
  var valor2: Int
)