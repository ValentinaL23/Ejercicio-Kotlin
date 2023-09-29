package com.example.ListMercado

import com.example.ListaMercado
import io.ktor.http.*
import io.ktor.server.routing.*
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*

private val listaDeMercado = mutableListOf(
  ListaMercado("arroz", "pollo", "lechuga", "soda")
)


fun Route.rutaMercado() {
  route("/listamercado") {
    get {
      call.respond(listaDeMercado)
    }

    post {
      val addProducto = call.receive<ListaMercado>()
      listaDeMercado.add(addProducto)
      call.respondText("Elemento agregado", status = HttpStatusCode.Created)
    }
  }
}