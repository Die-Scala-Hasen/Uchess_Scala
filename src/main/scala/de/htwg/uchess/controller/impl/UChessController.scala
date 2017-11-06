package de.htwg.uchess.controller.impl

import de.htwg.uchess.View.Tui
import akka.actor.{ActorSystem, Props}
import de.htwg.uchess.controller.Controller
import de.htwg.uchess.util.Point

class UChessController extends Controller {
  override def startGame(): Unit = ???

  override def getField(): Unit = ???

  override def getStatusMessage(): Unit = ???

  override def move(start: Point, target: Point): Unit = ???

  override def checkWin(): Unit = ???

  override def reset(): Unit = ???

  override def exitGame(): Unit = ???

  def akkaTest(): Unit = {
    val system = ActorSystem("Tui")
    val chessActor = system.actorOf(Props[Tui], name = "chessActor")
    chessActor ! "exit"
    chessActor ! "default de.htwg.uchess.test"
  }
}
