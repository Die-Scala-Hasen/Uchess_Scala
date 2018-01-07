package de.htwg.uchess.controller.impl

import akka.actor.{Actor, ActorSelection}
import de.htwg.uchess.controller.Controller
import de.htwg.uchess.model.Piece
import de.htwg.uchess.model.impl.GameField
import de.htwg.uchess.model.impl.Pawn
import de.htwg.uchess.util.Point

case object StartMessage

class UChessController() extends Actor with Controller {
  private var gameField = GameField(8)
  private val view: ActorSelection = context.system.actorSelection("user/view*")
  private var movePiece: Piece = _
  private var movePiecePos: Point = _
  private var startPlayerWhite = true
  private var whiteKingAlive = true
  private var blackKingAlive = true
  private var status = ""
  private var selected = false
  private var lock = false
  private var winner = ""

  initAll()
  notifyView()

  override def receive = {
    case QuitCmd => exitGame()
    case RestartCmd => reset()
    case move: MoveCmd => handleMove(move.src, move.dst)
    case _ if !winner.isEmpty => view ! InvalidInfo(gameField, "Invalid Command")
    case _ => view ! InvalidInfo(gameField, "Invalid Command")
  }

  private def initAll(): Unit = {
    gameField = GameField(8)
    movePiece = null
    movePiecePos = null
    startPlayerWhite = true
    whiteKingAlive = true
    blackKingAlive = true
    status = "Welcome to UChess"
    lock = false
    winner = ""
  }

  private def notifyView(): Unit = {
    var info: Info = null
    if (winner.nonEmpty) {
      info = GameoverInfo(gameField, winner)
    } else {
      var selPos: (Point) = null
      var possMoves: List[Point] = null
      if (selected) {
        selPos = movePiecePos
        possMoves = movePiece.possibleMove(gameField.gameField,selPos)
      }
      info = UpdateInfo(gameField, possMoves, selPos, status)
    }
    view ! info
  }

  private def checkPlayerTurn(p: Piece): Boolean = {
    if (p.color.equals('w') && startPlayerWhite) {
      true
    } else if (p.color.equals('b') && !startPlayerWhite) {
      true
    }
    else
      false
  }

  def printField(): String = gameField.toString


  override def getField(): GameField = {
    gameField
  }

  override def gameLock(): Boolean = {
    lock
  }

  override def getWinner(): String = {
    winner
  }

  private def select(point: Point): Unit = {
    val gameField = this.gameField.gameField
    gameField.get(point) match {
      case None =>
        status = "No Figure selected."
        notifyView()
      case Some(p) =>
        if (checkPlayerTurn(p)) {
          movePiece = p
          movePiecePos = point
          selected = true
          status = "One Figure is selected"
          notifyView()
        }
    }
  }

  override def handleMove(start: Point, target: Point): Unit = {
    val gameField = this.gameField.gameField
    gameField.get(start) match {
      case None =>
        status = "No Figure to move."
        notifyView()
      case Some(p) =>
        val validMoveList = p.possibleMove(gameField, start)
        if (validMoveList.contains(target) && checkPlayerTurn(p)) {
          turnColorChange()
          movePiece(p, start, target)
          status = "Figure was moved successfully."
        } else {
          status = "Invalid move!"
        }
        selected = false
        notifyView()
    }
  }


  private def killKingBlack() = {
    gameField = gameField.copy(gameField = gameField.gameField - Point(4, 0))
  }

  private def killKingWhite() = {
    gameField = gameField.copy(gameField = gameField.gameField - Point(4, 7))
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

    if (!whiteKingAlive) {
      status = "Black got the chicken dinner"
      lock = true
      winner = "Black"
      notifyView()
    }

    if (!blackKingAlive) {
      status = "White got the chicken dinner"
      lock = true
      winner = "White"
      notifyView()
    }
  }

  override def reset(): Unit = {
    initAll()
    notifyView()
  }

  override def exitGame(): Unit = {
    context.system.terminate()
  }

}
