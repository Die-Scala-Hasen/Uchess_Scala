package de.htwg.uchess.controller.impl

import de.htwg.uchess.view.Tui
import akka.actor.{ActorSystem, Props}
import de.htwg.uchess.controller.Controller
import de.htwg.uchess.model.Piece
import de.htwg.uchess.model.impl.{Field, GameField}
import de.htwg.uchess.util.Point

import scala.collection.mutable.ListBuffer

class UChessController(val gamefield: GameField) extends Controller {

  override def startGame(): Unit = ???

  override def getField(): Unit = ???

  override def getStatusMessage(): Unit = ???

  override def move(start: Point, target: Point): Unit = {

    if(findField(start).optionChessPiece.isDefined){
      val validMoveList = gamefield.gameFieldToPlay.filter(_.point.equals(start))
        .map(_.optionChessPiece.get.possibleMove(gamefield.gameFieldToPlay,start))

      if (validMoveList.exists(_.contains(target))) {
        movePiece(start, target)
      }
      else{
        //todo: prints only for testing
        println("invalid move")
      }
    }else{
      print("Please select an ChessPiece to move")
    }


  }

  private def movePiece(start: Point, target: Point): Unit = {
    var s: Piece = null
    for (i <- gamefield.gameFieldToPlay.indices) {
      val currentField = gamefield.gameFieldToPlay(i)
      if (currentField.point.equals(start)) {
        s = currentField.optionChessPiece.get
        gamefield.gameFieldToPlay.update(i, currentField.copy(optionChessPiece = None))
      }
    }
    for (i <- gamefield.gameFieldToPlay.indices) {
      val currentField = gamefield.gameFieldToPlay(i)
      if (currentField.point.equals(target)) {
        gamefield.gameFieldToPlay.update(i, currentField.copy(optionChessPiece = Option(s)))
      }
    }
  }

  override def checkWin(): Unit = ???

  override def reset(): Unit = ???

  override def exitGame(): Unit = ???


  def findField(pointToFind: Point): Field = {
    val result: ListBuffer[Field] = gamefield.gameFieldToPlay.filter(_.point.equals(pointToFind))
    result.head
  }

  /*def akkaTest(): Unit = {
    val system = ActorSystem("Tui")
    val chessActor = system.actorOf(Props[Tui], name = "chessActor")
    chessActor ! "exit"
    chessActor ! "default de.htwg.uchess.test"
  }*/
}
