package de.htwg.uchess.model.impl

import de.htwg.uchess.model.Piece
import de.htwg.uchess.util.Point

case class Queen(color: Char) extends Piece {

  override def possibleMove(gameField: Map[Point, Piece], currentPoint: Point): List[Point] = {
    val possibilities = Vector((-1, -1), (-1, 1), (1, -1), (1, 1), (-1, 0), (1, 0), (0, -1), (0, 1))
    internalMove(gameField, currentPoint, possibilities.toList)
  }

  override def toString: String = {
    color match {
      case 'w' => "♕"
      case 'b' => "♛"
      case _ => "Q" + color
    }
  }
}
