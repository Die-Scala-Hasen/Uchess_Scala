package model.impl

import model.Piece
import util.Point

/**
  * Created by mbo on 29.09.2017.
  */
case class Pawn(private var x: Int, private var y: Int, color: Char, figure: String) extends Piece {

  var firstStep = false

  override def move(x: Int, y: Int): Unit =  {
  }

  private def validMove(): Boolean = {
    true
  }
}
