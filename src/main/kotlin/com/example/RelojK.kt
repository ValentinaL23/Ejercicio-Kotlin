package com.example

import kotlinx.serialization.Serializable

@Serializable
data class RelojK (
  var hora: Int,
  var minutos: Int,
  var segundos: Int,
  var franja: String
)