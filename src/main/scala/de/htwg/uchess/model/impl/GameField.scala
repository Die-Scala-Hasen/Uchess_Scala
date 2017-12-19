package de.htwg.uchess.model.impl

import scala.collection.mutable

import de.htwg.uchess.model.Piece
import de.htwg.uchess.util.Point

case class GameField(size: Int, gameField: Map[Point, Piece]) {

  override def toString: String = {

    val sb: mutable.StringBuilder = new StringBuilder

    sb ++= "\n  |\u200aa\u202f|\u200ab\u202f|\u200ac\u202f|\u200ad\u202f|\u200ae\u202f|\u200af\u202f|\u200ag\u202f|\u200ah\u202f|"
    sb ++= "\n==+---------------------+"

    for {
      y <- 0 until size
      x <- 0 until size
    } {
      if (x == 0) sb ++= "\n" + (y + 1) + " |"
      gameField.get(Point(x, y)) match {
        case Some(p) => sb ++= p.toString
        case None => sb ++= "\u2001"
      }
      sb ++= "|"
    }

    sb ++= "\n==+---------------------+"
    sb.result()
  }
}

object GameField {
  def apply(size: Int): GameField = {
    val gameFieldBuilder = Map.newBuilder[Point, Piece]

      initWhiteFigures()
      initBlackFigures()

    def initWhiteFigures(): Unit = {
      if (size == 8) {
        initTowers(7, 'w')
        initKnights(7, 'w')
        initBishops(7, 'w')
        initQueens(7, 'w')
        initKings(7, 'w')
        initPawn(6, 'w')
      }
      else {
        initKingsForScaling(size / 2 , size-1, 'w')
      }

    }

    def initBlackFigures(): Unit = {
      if (size == 8) {
        initTowers(0, 'b')
        initKnights(0, 'b')
        initBishops(0, 'b')
        initQueens(0, 'b')
        initKings(0, 'b')
        initPawn(1, 'b')
      }
      else {
        initKingsForScaling(size / 2 , 0,  'b')
      }
    }

    def initPawn(y: Int, color: Char): Unit = {
      for (x <- 0 until 8) {
        gameFieldBuilder += Point(x, y) -> Pawn(color)
      }
    }

    def initTowers(y: Int, color: Char): Unit = {
      gameFieldBuilder += Point(0, y) -> Tower(color)
      gameFieldBuilder += Point(7, y) -> Tower(color)
    }

    def initKnights(y: Int, color: Char): Unit = {
      gameFieldBuilder += Point(1, y) -> Knight(color)
      gameFieldBuilder += Point(6, y) -> Knight(color)
    }

    def initBishops(y: Int, color: Char): Unit = {
      gameFieldBuilder += Point(2, y) -> Bishop(color)
      gameFieldBuilder += Point(5, y) -> Bishop(color)
    }

    def initQueens(y: Int, color: Char): Unit = {
      gameFieldBuilder += Point(3, y) -> Queen(color)
    }

    def initKings(y: Int, color: Char): Unit = {
      gameFieldBuilder += Point(4, y) -> King(color)
    }

    def initKingsForScaling(x: Int, y: Int, color:Char): Unit ={
      gameFieldBuilder += Point(x,y) -> King(color)
    }

    GameField(size, gameFieldBuilder.result())
  }
}