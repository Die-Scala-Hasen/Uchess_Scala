package Model.impl

import Model.Piece
import Util.Point

/**
  * Created by mbo on 29.09.2017.
  */
class Pawn(var x: Int, var y: Int, color: Char, figur: String) extends Piece {

  override def move(x: Int, y: Int): Unit =  {
    this.x = x
    this.y = y
  }

  override def getColor(): Char = color
  override def getPosition(): Point = new Point(x,y)
  override def getFigur(): String = figur
}
