package model.impl

import util.Point


case class GameField(size: Int) {
  val MIN_POS = 0
  val MAX_POS = size - 1

  var gameField: List[Field] = List()
  var whiteKing: King = King(Point(4, 0), 'w')
  var blackKing: King = King(Point(4, 7), 'b')
  var whiteQueen: Queen = Queen(Point(3, 0), 'w')
  var blackQueen: Queen = Queen(Point(3, 7), 'b')

  initialGameField()
  initFigures()

  private def initialGameField(): Unit = {
    gameField = List()
    for {
      y <- MIN_POS until size
      x <- MIN_POS until size
    } {
      gameField = gameField :+ Field(Point(x, y))
    }
  }

  private def initFigures():Unit ={
    initWhiteFigures()
    initBlackFigures()
  }

  private def initWhiteFigures():Unit ={


  }
  private def initBlackFigures():Unit ={

  }
}
