package de.htwg.uchess.model.impl

import de.htwg.uchess.model.Piece
import de.htwg.uchess.util.Point

import scala.collection.mutable.ListBuffer

case class King(color: Char) extends Piece {
  //todo: add changing function for own pieces
  override def possibleMove(gameField: ListBuffer[Field], currentPoint: Point)= {
    val list = new ListBuffer[Point]

    list.appendAll(internalMove(gameField,  currentPoint, 0,   1))
    list.appendAll(internalMove(gameField,  currentPoint, 0,  -1))
    list.appendAll(internalMove(gameField,  currentPoint, 1,   0))
    list.appendAll(internalMove(gameField,  currentPoint, -1,  0))

    list.appendAll(internalMove(gameField,  currentPoint, 1,   1))
    list.appendAll(internalMove(gameField,  currentPoint, 1,  -1))
    list.appendAll(internalMove(gameField,  currentPoint, -1,  1))
    list.appendAll(internalMove(gameField,  currentPoint, -1, -1))

    list.toList

  }

  override def internalMove(gameField: ListBuffer[Field], currentPoint: Point, indicatorX: Int, indicatorY: Int): ListBuffer[Point] = {

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
        }
      }
    list
  }

    override def toString: String = {
    color match {
      case 'w' => "♔"
      case 'b' => "♚"
      case _   => "K" + color
    }
  }
}