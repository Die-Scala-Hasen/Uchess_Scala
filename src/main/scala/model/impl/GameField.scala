package model.impl

import util.Point

import scala.Array.ofDim


case class GameField() {

  var gameField: Array[Array[Field]] = ofDim[Field](8, 8)
  var whiteKing: King = King(4, 0, 'w')
  var blackKing: King = King(4, 7, 'b')
  var whiteQueen: Queen = Queen(3, 0, 'w')
  var blackQueen: Queen = Queen(3, 7, 'b')

  initialGameField()
  initKings()
  initQueens()

  private def initialGameField(): Unit = {
    for (x <- 0 until 8; y <- 0 until 8) {
      gameField(x)(y) = Field(new Point(x, y))
    }
  }

  def initKings(): Unit = {
    gameField(4)(0) = Field(new Point(4, 0), Some(whiteKing))
    gameField(4)(7) = Field(new Point(4, 7), Some(blackKing))
  }

  private def initQueens(): Unit = {
    gameField(3)(0) =  Field(new Point(3, 0), Some(whiteQueen))
    gameField(3)(7) =  Field(new Point(3, 7), Some(blackQueen))
  }

  override def toString: String = {

    var temp:String =""
    var field:String = ""

    var y = 7
    while ( {y >= 0}) {
      temp +="|"
      var x = 0
      while ( {x <= 7}) {
        if (gameField(x)(y).optionChessPiece.isDefined){
          temp += gameField(x)(y).optionChessPiece.get.toString
        }else{
          temp += "\u2001"
        }
        temp += "|"
        x += 1
      }
      field += temp + "\n"
      temp = ""
      y -=1
    }
    field
  }

}
