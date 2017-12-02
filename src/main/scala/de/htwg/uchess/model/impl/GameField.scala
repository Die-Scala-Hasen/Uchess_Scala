package de.htwg.uchess.model.impl

import de.htwg.uchess.util.Point

import scala.collection.mutable.ListBuffer

case class GameField(size: Int) {
  val MIN_POS = 0
  val MAX_POS = size - 1

  val gameFieldToPlay: ListBuffer[Field] = new ListBuffer[Field]

  initialGameField()
  initFigures()

  private def initialGameField(): Unit = {
    for {
      y <- MIN_POS until size
      x <- MIN_POS until size
    } {
      gameFieldToPlay += Field(Point(x,y))
    }
  }

  private def initFigures(): Unit = {
    initWhiteFigures()
    initBlackFigures()
  }

  private def initWhiteFigures(): Unit = {
    initTowers(56, 'w')
    initKnights(56, 'w')
    initBishops(56, 'w')
    initQueens(56, 'w')
    initKings(56, 'w')
    initPawn(48, 'w')

  }
  private def initBlackFigures(): Unit = {
    initTowers(0, 'b')
    initKnights(0, 'b')
    initBishops(0, 'b')
    initQueens(0, 'b')
    initKings(0, 'b')
    initPawn(8, 'b')
  }

  private def initPawn(offset: Int, color: Char): Unit = {
    for (i <- 0 until size) {
      val currentPoint = gameFieldToPlay(i + offset).point
      gameFieldToPlay.update(offset + i, Field(currentPoint, Some(Pawn(color))))
    }
  }

  private def initTowers(offset: Int, color: Char): Unit = {
    for (i <- 0 until size by 7) {
      val currentPoint = gameFieldToPlay(i + offset).point
      gameFieldToPlay.update(offset + i,
                       Field(currentPoint, Some(Tower(color))))
    }
  }

  private def initKnights(offset: Int, color: Char): Unit = {
    for (i <- 1 until size by 5) {
      val currentPoint = gameFieldToPlay(i + offset).point
      gameFieldToPlay.update(offset + i,
                       Field(currentPoint, Some(Knight(color))))
    }
  }

  private def initBishops(offset: Int, color: Char): Unit = {
    for (i <- 2 until size by 3) {
      val currentPoint = gameFieldToPlay(i + offset).point
      gameFieldToPlay.update(offset + i,
                       Field(currentPoint, Some(Bishop(color))))
    }
  }

  private def initQueens(offset: Int, color: Char): Unit = {
    val currentPoint = gameFieldToPlay(3 + offset).point
    gameFieldToPlay.update(offset + 3,
                     Field(currentPoint, Some(Queen(color))))
  }

  private def initKings(offset: Int, color: Char): Unit = {
    val currentPoint = gameFieldToPlay(4 + offset).point
    gameFieldToPlay.update(offset + 4,
                     Field(currentPoint, Some(King(color))))
  }

  override def toString: String = {
    var row: Int = 1
    var sb: String = ""

    sb += "\n  |\u200aa\u202f|\u200ab\u202f|\u200ac\u202f|\u200ad\u202f|\u200ae\u202f|\u200af\u202f|\u200ag\u202f|\u200ah\u202f|"
    sb += "\n==+---------------------+"
    for (i <- gameFieldToPlay.indices) {
      if (i % size == 0) {
        sb += "\n" + row + " |"
        row += 1
      }
      if (gameFieldToPlay(i).optionChessPiece.isDefined) {
        sb += gameFieldToPlay(i).optionChessPiece.get.toString
      } else {
        sb += "\u2001"
      }
      sb += "|"
    }

    sb += "\n==+---------------------+"
    sb
  }
}
