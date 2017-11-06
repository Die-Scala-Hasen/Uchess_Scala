package model.impl

import model.Piece
import util.Point

case class Bishop( color: Char) extends Piece {
  override def possibleMove(gameField: GameField) = ???
  override def toString: String = {
    color match {
      case 'w' => "♗"
      case 'b' => "♝"
      case _   => "B" + color
    }
  }
}
