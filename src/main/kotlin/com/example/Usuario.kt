package com.example

import kotlinx.serialization.Serializable

@Serializable
data class Usuario (
  val nombre: String,
  val apellido: String,
  val correo: String
)