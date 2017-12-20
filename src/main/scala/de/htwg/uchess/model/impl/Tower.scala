package de.htwg.uchess.model.impl

import de.htwg.uchess.model.Piece
import de.htwg.uchess.util.Point

case class Tower(color: Char) extends Piece {

  override def possibleMove(gameField: Map[Point, Piece], currentPoint: Point): List[Point] = {
    val possibilities = Vector((0, 1), (0, -1), (1, 0), (-1, 0))
    internalMove(gameField, currentPoint, possibilities.toList)
  }

  override def toString: String = {
    color match {
      case 'w' => "♖"
      case 'b' => "♜"
      case _ => "T" + color
    }
  }
}
