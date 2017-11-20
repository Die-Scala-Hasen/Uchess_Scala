package de.htwg.uchess.model.impl

import de.htwg.uchess.model.Piece
import de.htwg.uchess.util.Point

import scala.collection.mutable.ListBuffer

case class Pawn(color: Char, var firstMove: Boolean = true) extends Piece {
  override def possibleMove(gameField: ListBuffer[Field], currentPoint: Point): List[Point] = {
    val list = new ListBuffer[Point]

    color match {
      case 'w' =>
        val oneStepPoint: Point = Point(currentPoint.x, currentPoint.y - 1)
        if (isValidPoint(oneStepPoint)&& findField(gameField, oneStepPoint).optionChessPiece.isEmpty) {
          list += oneStepPoint
        }

        val twoStepPoint: Point = Point(currentPoint.x, currentPoint.y - 2)
        if (isValidPoint(twoStepPoint)&& firstMove && findField(gameField, twoStepPoint).optionChessPiece.isEmpty) {
          list += twoStepPoint
        }

        val crossRightPoint: Point = Point(currentPoint.x + 1, currentPoint.y - 1)
        if (isValidPoint(crossRightPoint)&& findField(gameField, crossRightPoint).optionChessPiece.isDefined) {
          list += crossRightPoint
        }

        val crossLeftPoint: Point = Point(currentPoint.x - 1, currentPoint.y - 1)
        if (isValidPoint(crossLeftPoint)&& findField(gameField, crossLeftPoint).optionChessPiece.isDefined) {
          list += crossLeftPoint
        }
      case 'b' =>
        val oneStepPoint: Point = Point(currentPoint.x, currentPoint.y + 1)
        if (isValidPoint(oneStepPoint)&& findField(gameField, oneStepPoint).optionChessPiece.isEmpty) {
          list += oneStepPoint
        }

        val twoStepPoint: Point = Point(currentPoint.x, currentPoint.y + 2)
        if (isValidPoint(twoStepPoint)&& firstMove && findField(gameField, twoStepPoint).optionChessPiece.isEmpty) {
          list += twoStepPoint
        }

        val crossRightPoint: Point = Point(currentPoint.x - 1, currentPoint.y + 1)
        if (isValidPoint(crossRightPoint)&& findField(gameField, crossRightPoint).optionChessPiece.isDefined) {
          list += crossRightPoint
        }

        val crossLeftPoint: Point = Point(currentPoint.x + 1, currentPoint.y + 1)
        if (isValidPoint(crossLeftPoint)&& findField(gameField, crossLeftPoint).optionChessPiece.isDefined) {
          list += crossLeftPoint
        }
    }
    firstMove = false
    list.toList
  }

  override def toString: String = {
    color match {
      case 'w' => "♙"
      case 'b' => "♟"
      case _ => "P" + color
    }
  }


}
