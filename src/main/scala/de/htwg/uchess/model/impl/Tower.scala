package de.htwg.uchess.model.impl

import de.htwg.uchess.model.Piece
import de.htwg.uchess.util.Point

import scala.collection.mutable.ListBuffer

case class Tower(color: Char) extends Piece {
  override def possibleMove(gameField: Map[Point, Piece], currentPoint: Point): List[Point] = {
    val list = new ListBuffer[Point]

    list.appendAll(internalMove(gameField, currentPoint, 0,   1))
    list.appendAll(internalMove(gameField, currentPoint, 0,  -1))
    list.appendAll(internalMove(gameField, currentPoint, 1,   0))
    list.appendAll(internalMove(gameField, currentPoint, -1,  0))

    list.toList
  }

  override def toString: String = {
    color match {
      case 'w' => "♖"
      case 'b' => "♜"
      case _   => "T" + color
    }
  }
}
