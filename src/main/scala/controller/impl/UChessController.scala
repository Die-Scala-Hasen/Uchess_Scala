package controller.impl

import controller.Controller

import scala.swing.Point
import scala.swing.event.Event

case class ExitGame() extends Event

class UChessController extends Controller {
  override def startGame(): Unit = ???

  override def getField(): Unit = ???

  override def getStatusMessage(): Unit = ???

  override def move(start: Point, target: Point): Unit = ???

  override def checkWin(): Unit = ???

  override def reset(): Unit = ???

  override def exitGame(): Unit = ???
}
