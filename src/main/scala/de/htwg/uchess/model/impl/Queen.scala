package de.htwg.uchess.model.impl

import de.htwg.uchess.model.Piece
import de.htwg.uchess.util.Point

import scala.collection.mutable.ListBuffer

case class Queen(color: Char) extends Piece {
  override def possibleMove(gameField: ListBuffer[Field], currentPoint: Point) = {
    val list = new ListBuffer[Point]
//
//    for {
//      x <- -1 to 1
//      y <- -1 to 1
//      if x != 0 && y != 0
//    }{
//      list ++= internalMove(gameField, currentPoint, x, y)
//    }

    for {
      x <- currentPoint.x -1 to currentPoint.x +1
      y <- currentPoint.y -1 to currentPoint.y +1
      p = Point(x,y)
      if currentPoint != p
    } {
      list ++= internalMove(gameField, p)
    }

    list.result()
  }
  override def toString: String = {
    color match {
      case 'w' => "♕"
      case 'b' => "♛"
      case _   => "Q" + color
    }
  }
}
