package controller.impl

import View.Tui
import akka.actor.{ActorSystem, Props}
import controller.Controller
import util.Point

class UChessController extends Controller {
  override def startGame(): Unit = ???

  override def getField(): Unit = ???

  override def getStatusMessage(): Unit = ???

  override def move(start: Point, target: Point): Unit = ???

  override def checkWin(): Unit = ???

  override def reset(): Unit = ???

  override def exitGame(): Unit = ???

//  def akkaTest(): Unit = {
//    val system = ActorSystem("Tui")
//    val chessActor = system.actorOf(Props[Tui], name = "chessActor")
//    chessActor ! "exit"
//    chessActor ! "default test"
//  }
}
