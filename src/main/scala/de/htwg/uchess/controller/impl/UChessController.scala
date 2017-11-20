package de.htwg.uchess.controller.impl

import de.htwg.uchess.view.Tui
import akka.actor.{ActorSystem, Props}
import de.htwg.uchess.controller.Controller
import de.htwg.uchess.model.Piece
import de.htwg.uchess.model.impl.GameField
import de.htwg.uchess.util.Point

class UChessController(val gamefield: GameField) extends Controller {

  override def startGame(): Unit = ???

  override def getField(): Unit = ???

  override def getStatusMessage(): Unit = ???

  override def move(start: Point, target: Point): Unit = {

    val validMoveList = gamefield.gameField
      .filter(_.point.equals(start))
      .map(_.optionChessPiece.get.possibleMove(gamefield.gameField,start))

    if (validMoveList.exists(_.contains(target))) {
      movePiece(start, target)

    }

  }

  private def movePiece(start: Point, target: Point): Unit = {
    var s: Piece = null
    for (i <- gamefield.gameField.indices) {
      val currentField = gamefield.gameField(i)
      if (currentField.point.equals(start)) {
        s = currentField.optionChessPiece.get
        gamefield.gameField.update(i, currentField.copy(optionChessPiece = None))
      }
    }
    for (i <- gamefield.gameField.indices) {
      val currentField = gamefield.gameField(i)
      if (currentField.point.equals(target)) {
        gamefield.gameField.update(i, currentField.copy(optionChessPiece = Option(s)))
      }
    }
  }

  override def checkWin(): Unit = ???

  override def reset(): Unit = ???

  override def exitGame(): Unit = ???

  /*def akkaTest(): Unit = {
    val system = ActorSystem("Tui")
    val chessActor = system.actorOf(Props[Tui], name = "chessActor")
    chessActor ! "exit"
    chessActor ! "default de.htwg.uchess.test"
  }*/
}
