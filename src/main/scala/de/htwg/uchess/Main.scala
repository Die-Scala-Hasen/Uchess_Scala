package de.htwg.uchess

import akka.actor.{ActorRef, ActorSystem, Props}
import de.htwg.uchess.controller.impl.UChessController

class Main {
  this: ChessModule =>
  implicit val system: ActorSystem = ActorSystem("ChessSystem")
  var controller: ActorRef = _

  def start(): Unit = {
    createUI()
    controller = system.actorOf(Props[UChessController], "controller")
  }
}

object Main {

  import scala.concurrent.ExecutionContext.Implicits.global

  def main(args: Array[String]) {

    val chess = new Main with OfflineModule
    chess.start()
    chess.system.whenTerminated.onComplete(_ => System.exit(0))

    while (true) {
      val input = scala.io.StdIn.readLine()
      chess.tui ! input
    }
  }
}
