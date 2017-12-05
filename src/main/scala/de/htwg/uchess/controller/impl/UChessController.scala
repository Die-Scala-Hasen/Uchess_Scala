package de.htwg.uchess.controller.impl

import de.htwg.uchess.controller.Controller
import de.htwg.uchess.model.Piece
import de.htwg.uchess.model.impl.GameField
import de.htwg.uchess.util.Point

class UChessController(size: Int) extends Controller {
  private var gamefield = GameField(size)

  def printField(): String = gamefield.toString

  override def startGame(): Unit = ???

  override def getField(): Unit = ???

  override def getStatusMessage(): Unit = ???

  override def move(start: Point, target: Point): Unit = {
    val gamefield = this.gamefield.gameField
    gamefield.get(start) match {
      case None => print("Please select an ChessPiece to move")
      case Some(p) =>
        val validMoveList = p.possibleMove(gamefield, start)
        if (validMoveList.contains(target)) {
          movePiece(p, start, target)
        } else {
          //todo: prints only for testing
          println("invalid move")
        }
    }
  }

  private def movePiece(piece: Piece, start: Point, target: Point): Unit = {
    gamefield = gamefield.copy(gameField = gamefield.gameField - start + (target -> piece))
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
