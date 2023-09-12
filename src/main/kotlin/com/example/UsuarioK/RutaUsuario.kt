package com.example.UsuarioK

import com.example.Usuario
import io.ktor.http.*
import io.ktor.server.routing.*
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import kotlin.random.Random

private var listaUsuarios: Usuario = (
  Usuario("Maria", "Díaz", "maria.diaz@gmail.com")
)

fun Route.rutaUsuario() {
  route("/usuario") {
    get{
      /*if (usuarios.isNotEmpty()) {
      } else {
        call.respondText("No hay usuarios",
          status = HttpStatusCode.OK)
      }*/
        call.respond(listaUsuarios)
    }

    post {
      val usuario = call.receive<Usuario>()
      listaUsuarios = usuario
      val numRandom = Random.nextInt(0, 5)
      println(numRandom)
      call.respondText("Usuario creado", status = HttpStatusCode.Created)
    }
  }
}