package com.example.plugins

import com.example.Jugador.rutaJugador
import com.example.ListMercado.rutaMercado
import com.example.OrganizacionLetras.rutaOrganizacion
import com.example.Reloj.rutaReloj
import com.example.UsuarioK.rutaUsuario
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Application.configureRouting() {
  routing {
    get("/") {
      call.respondText("Hello World!")
    }
    //rutaOperacion()
    //rutaOrganizacion()
    //rutaUsuario()
    //rutaJugador()
    rutaReloj()
    //rutaMercado()
  }
}
