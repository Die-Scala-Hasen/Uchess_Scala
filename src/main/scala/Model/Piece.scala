package Model

import Util.Point

/**
  * Created by mbo on 29.09.2017.
  */
trait Piece{
  // def getPosition: Point
  def move(x:Int, y:Int)
  def getColor(): Char
  def getPosition(): Point
  def getFigur(): String
}
