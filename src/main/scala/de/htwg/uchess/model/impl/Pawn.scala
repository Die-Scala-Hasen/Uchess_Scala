package de.htwg.uchess.model.impl

import de.htwg.uchess.model.Piece
import de.htwg.uchess.util.Point

import scala.collection.mutable.ListBuffer

case class Pawn( color: Char) extends Piece {
  override def possibleMove(figureList: ListBuffer[Field]): List[Point] = {
    val list = List(Point(0,2))
    list
  }
  override def toString: String = {
    color match {
      case 'w' => "♙"
      case 'b' => "♟"
      case _   => "P" + color
    }
  }
}
