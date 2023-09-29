package com.example.Jugador

import com.example.Ataque
import com.example.Mounstro
import io.ktor.http.*
import io.ktor.server.routing.*
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import kotlin.random.Random

var monstruo: Mounstro = (
  Mounstro(100, 10)
)

var ataque: Ataque = (
  Ataque(0)
        )

fun Route.rutaJugador() {
  route("/jugador") {
    get{
      call.respond(monstruo)
    }
    post{
      val tempAtaque = call.receive<Ataque>()
      val tempMounstro = monstruo
      var ataqueF = Random.nextInt(0, 5) * tempAtaque.atk
      tempMounstro.vida = monstruo.vida - ataqueF
      //println(tempMounstro.vida)
      //monstruo.vida - ataqueF
      call.respondText("ataque recibido", status = HttpStatusCode.Created)
    }
  }
}