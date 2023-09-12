package com.example.OrganizacionLetras

import com.example.Organizacion
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

private val letras = mutableListOf("a", "e", "b", "c", "i")

fun Route.rutaOrganizacion() {
  route("/organizacion") {
    get {
      if (letras.isNotEmpty()) {
        letras.sorted()
      } else {
          call.respondText("No hay letras")
      }
        call.respond(letras)

    }

    post {
      val letra = call.receive<Organizacion>()
        letras[0] = letra.letra1
        letras[1] = letra.letra2
        letras[2] = letra.letra3
        letras[3] = letra.letra4
        letras[4] = letra.letra5
      call.respondText("Letras recebidas", status = HttpStatusCode.Created)
    }
  }
}
