package de.htwg.uchess.model.impl

import de.htwg.uchess.model.Piece
import de.htwg.uchess.util.Point


case class Queen(color: Char) extends Piece {
  override def possibleMove(gameField: Map[Point, Piece], currentPoint: Point): List[Point] = {
//    val list = new ListBuffer[Point]
//
//    for {
//      x <- -1 to 1
//      y <- -1 to 1
//      if x != 0 && y != 0
//    }{
//      list ++= internalMove(gameField, currentPoint, x, y)
//    }

    val possibilities = for {
      x <-  -1 to  +1
      y <-  -1 to  +1
      if (x , y) != (0 , 0)
    } yield (x, y)

    internalMove2(gameField, currentPoint, possibilities.toList)
//    for {
//      x <-  -1 to  +1
//      y <-  -1 to  +1
//      if (x , y) != (0 , 0)
//    } {
//      list ++= internalMove(gameField, currentPoint, x, y)
//    }
//
//    list.result()
  }
  override def toString: String = {
    color match {
      case 'w' => "♕"
      case 'b' => "♛"
      case _   => "Q" + color
    }
  }
}
