package de.htwg.uchess.controller.impl

import akka.actor.{ActorSystem, Props}
import de.htwg.uchess.controller.Controller
import de.htwg.uchess.model.Piece
import de.htwg.uchess.model.impl.GameField
import de.htwg.uchess.model.impl.Pawn
import de.htwg.uchess.util.Point
import de.htwg.uchess.view.Tui

case object StartMessage

class UChessController(size: Int) extends Controller {
  private var gameField = GameField(size)
  private var startPlayerWhite = true
  private var whiteKingAlive = true
  private var blackKingAlive = true

  private def checkPlayerTurn(p: Piece): Boolean = {
    if (p.color.equals('w') && startPlayerWhite == true) {
      true
    } else if (p.color.equals('b') && startPlayerWhite == false) {
      true
    }
    else
      false
  }

  def printField(): String = gameField.toString

  override def startGame(): Unit = ???

  override def getField(): Unit = ???

  override def getStatusMessage(): Unit = ???

  override def move(start: Point, target: Point): Boolean = {
    val gameField = this.gameField.gameField
    gameField.get(start) match {
      case None => false
      case Some(p) =>
        val validMoveList = p.possibleMove(gameField, start)
        if (validMoveList.contains(target) && checkPlayerTurn(p)) {
          turnColorChange()
          movePiece(p, start, target)
          true
        } else {
          false
        }
    }
  }

  private def killKingBlack() = {
    gameField = gameField.copy(gameField = gameField.gameField - new Point(4,0))
  }

  private def killKingWhite() = {
    gameField = gameField.copy(gameField = gameField.gameField - new Point(4,7))
  }

  private def turnColorChange() = {
    startPlayerWhite = !startPlayerWhite
  }

  private def movePiece(piece: Piece, start: Point, target: Point): Unit = {
    piece match {
      case pawn: Pawn =>
        pawn.firstMove = false
        gameField = gameField.copy(gameField = gameField.gameField - start + (target -> piece))
        checkWin()
      case _ =>
        gameField = gameField.copy(gameField = gameField.gameField - start + (target -> piece))
        checkWin()
    }
  }

  override def checkWin(): Unit = {
    whiteKingAlive = false
    blackKingAlive = false

    gameField.gameField.foreach { keyVal =>
      if (keyVal._2.toString.equals("♔")) {
        whiteKingAlive = true
      }
      if (keyVal._2.toString.equals("♚")) {
        blackKingAlive = true
      }
    }

    if(!whiteKingAlive) {
      printf("Black got the chicken dinner")
    }

    if(!blackKingAlive) {
      printf("White got the chicken dinner")
    }


  }

  override def reset(): Unit = ???

  override def exitGame(): Unit = ???


//    def akkaTest(): Unit = {
//      val system = ActorSystem("UpdateSystem")
//      val chessActor = system.actorOf(Props(new Tui(this)), name = "tui")
//      chessActor ! StartMessage
//      chessActor ! "exit"
//     chessActor ! "blat"
//    }
}
