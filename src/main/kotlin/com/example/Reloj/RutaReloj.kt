package com.example.Reloj

import com.example.RelojK
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import java.text.SimpleDateFormat
import java.util.*

val formatter = SimpleDateFormat("hh:mm:ss a")
val tiempo = Date()
var time = formatter.format(tiempo)

val relojj: RelojK = (
  RelojK(10, 25, 55, "p. m.")
)

fun Route.rutaReloj() {
  route("/reloj") {
    get {
      //aca llama la variable time que muestra la hora actual
      call.respond(time)
    }

    post {

      val reloj = call.receive<RelojK>()
      val hora = tiempo.hours
      println(hora)
      val tempReloj = reloj.hora.toString() + ":" + reloj.minutos.toString() + ":" + reloj.segundos.toString() + " " + reloj.franja
      time = tempReloj.format(Date())
      call.respondText("Operación recibida", status = HttpStatusCode.Created)
    }
  }
}