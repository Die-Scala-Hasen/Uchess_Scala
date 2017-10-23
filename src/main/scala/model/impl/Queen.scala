package model.impl

import model.Piece

import util.Point

case class Queen(p: Point, color: Char) extends Piece {
  override def possibleMove(gameField: GameField): List[Field] = ???
  override def toString: String = {
    color match {
      case 'w' => "♕"
      case 'b' => "♛"
      case _   => "Q" + color
    }
  }
}
