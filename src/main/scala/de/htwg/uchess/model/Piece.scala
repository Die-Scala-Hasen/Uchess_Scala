package de.htwg.uchess.model

import de.htwg.uchess.model.impl.Field
import de.htwg.uchess.util.Point

import scala.collection.mutable.ListBuffer

trait Piece{
  val color: Char

  def possibleMove(gameField: ListBuffer[Field], currentPoint: Point): List[Point]
  override def toString: String

  def internalMove(gameField: ListBuffer[Field], currentPoint: Point, indicatorX:Int, indicatorY:Int):ListBuffer[Point] = {
    val list = new ListBuffer[Point]
    val PointCounterX: Int = currentPoint.x + indicatorX
    val PointCounterY: Int = currentPoint.y + indicatorY

    val internalPoint: Point = Point(PointCounterX, PointCounterY)
    if (isValidPoint(internalPoint)) {
      if (findField(gameField, internalPoint).optionChessPiece.isDefined) {
        val foundPiece: Piece = findField(gameField, internalPoint).optionChessPiece.get
        if (!foundPiece.color.equals(color)) {
          list += internalPoint
        }
      }else{
        list += internalPoint
        list ++= internalMove(gameField,internalPoint,indicatorX,indicatorY)
      }
    }
    list
  }

  def findField(gameField: ListBuffer[Field], pointToFind: Point): Field = {
    val result: ListBuffer[Field] = gameField.filter(_.point.equals(pointToFind))
    result.head
  }

  def isValidPoint(pointToCheck: Point):Boolean ={
    var isValid:Boolean = false
    if(pointToCheck.x >= 0 && pointToCheck.x <= 7 && pointToCheck.y >= 0 && pointToCheck.y <= 7){
      isValid = true
    }
    isValid
  }
}
