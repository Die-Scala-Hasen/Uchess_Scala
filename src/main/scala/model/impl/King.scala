package model.impl

import model.Piece

case class King(private var x: Int, private var y: Int, color: Char, figure: String) extends Piece {
  override def move(x: Int, y: Int): Unit = ???
  override def toString: String = {

  }
}
