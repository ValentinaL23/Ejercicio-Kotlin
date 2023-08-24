package com.example.Operaciones

import com.example.Operacion
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

private val operaciones = mutableListOf(
  Operacion(1, "+", 8)
)

private var operador = ""

private var result = 0

fun Route.rutaOperacion() {
  route("/operaciones") {
    get {
      if (operaciones.isNotEmpty()) {
        operador = operaciones[0].operador
        if (operador == "+") {
          result = operaciones[0].valor1 + operaciones[0].valor2
          call.respondText(result.toString())
        } else if (operador == "-") {
          result = operaciones[0].valor1 - operaciones[0].valor2
          call.respondText(result.toString())
        } else if (operador == "*") {
          result = operaciones[0].valor1 * operaciones[0].valor2
          call.respondText(result.toString())
        } else if (operador == "/") {
          result = operaciones[0].valor1 / operaciones[0].valor2
          call.respondText(result.toString())
        }
      } else {
        call.respondText("No hay operaciones")
      }
    }

    post {
      val operacion = call.receive<Operacion>()
      operaciones[0] = operacion
      call.respondText("Operación recibida", status = HttpStatusCode.Created)
    }
  }
}
