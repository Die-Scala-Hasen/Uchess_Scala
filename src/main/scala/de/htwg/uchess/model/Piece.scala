package de.htwg.uchess.model

import de.htwg.uchess.model.impl.{Field, GameField}
import de.htwg.uchess.util.Point

import scala.collection.mutable.ListBuffer


trait Piece{
  def possibleMove(gameField: ListBuffer[Field], currentPoint: Point): List[Point]
  override def toString: String

  def findField(gameField: ListBuffer[Field], pointToFind: Point): Field = {
    val result: ListBuffer[Field] = gameField.filter(_.point.equals(pointToFind))
    result.head
  }

  def isValidPoint(pointToCheck: Point):Boolean ={
    var isValid:Boolean = false
    if(pointToCheck.x >= 0 && pointToCheck.y >= 0){
      isValid = true
    }
    isValid
  }
}
