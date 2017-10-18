package model.impl

import model.Piece

case class King(private var x: Int, private var y: Int, color: Char) extends Piece {
  override def move(x: Int, y: Int): Unit = ???
  override def toString: String = {
    color match {
      case 'w' => "♔"
      case 'b' => "♚"
      case _ => "K"+color
    }
  }
}
