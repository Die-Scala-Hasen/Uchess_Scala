package de.htwg.uchess.model.impl

import de.htwg.uchess.model.Piece
import de.htwg.uchess.util.Point

import scala.collection.mutable.ListBuffer

case class Queen( color: Char) extends Piece {
  override def possibleMove(gameField: ListBuffer[Field], currentPoint: Point) = ???
  override def toString: String = {
    color match {
      case 'w' => "♕"
      case 'b' => "♛"
      case _   => "Q" + color
    }
  }
}
