package de.htwg.uchess.model.impl

import de.htwg.uchess.model.Piece
import de.htwg.uchess.util.Point

import scala.collection.mutable.ListBuffer

case class Bishop( color: Char) extends Piece {
  override def possibleMove(figureList: ListBuffer[Field]) = ???
  override def toString: String = {
    color match {
      case 'w' => "♗"
      case 'b' => "♝"
      case _   => "B" + color
    }
  }
}
