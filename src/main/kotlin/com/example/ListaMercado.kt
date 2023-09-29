package com.example

import kotlinx.serialization.Serializable

@Serializable
data class ListaMercado (
  val harina: String,
  val proteina: String,
  val vegetal: String,
  val bebida: String
)