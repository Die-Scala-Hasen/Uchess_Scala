package model.impl

import util.Point

import scala.collection.mutable.ListBuffer

case class GameField(size: Int) {
  val MIN_POS = 0
  val MAX_POS = size - 1

  var gameField: ListBuffer[Field] = new ListBuffer[Field]
  var whiteKing: King = King(Point(4, 0), 'w')
  var blackKing: King = King(Point(4, 7), 'b')
  var whiteQueen: Queen = Queen(Point(3, 0), 'w')
  var blackQueen: Queen = Queen(Point(3, 7), 'b')

  initialGameField()
  initFigures()

  private def initialGameField(): Unit = {
    gameField = new ListBuffer[Field]
    for {
      y <- MIN_POS until size
      x <- MIN_POS until size
    } {
      gameField = gameField :+ Field(Point(x, y))
    }
  }

  private def initFigures(): Unit = {
    initWhiteFigures()
    initBlackFigures()
  }

  private def initWhiteFigures(): Unit = {
    initPawn(48, 'w')

  }
  private def initBlackFigures(): Unit = {
    initPawn(8, 'b')
  }

  private def initPawn(offset: Int, color: Char): Unit = {
    for (i <- 0 until 8) {
      val currentPoint = gameField(i + offset).point
      gameField.update(offset + i, Field(currentPoint, Some(Pawn(currentPoint, color))))
    }
  }

  override def toString: String = {
    var sb: String = ""

    sb += "\n |  a  b  c  d  e  f  g  h  |"
    sb += "\n-+--------------------------+"


    sb += "\n-+--------------------------+"
    sb
  }
}
