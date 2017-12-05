package de.htwg.uchess.model.impl

import de.htwg.uchess.model.Piece
import de.htwg.uchess.util.Point

import scala.collection.mutable.ListBuffer

case class Pawn(color: Char, var firstMove: Boolean = true) extends Piece {

  override def possibleMove(gameField: Map[Point, Piece], currentPoint: Point): List[Point] = {
    val list = new ListBuffer[Point]

    val oneStepPoint: Point = Point(currentPoint.x, stepY(currentPoint.y, 1))
    if (isValidPoint(oneStepPoint) && findField(gameField, oneStepPoint).optionChessPiece.isEmpty) {
      list += oneStepPoint
    }
    val twoStepPoint: Point = Point(currentPoint.x, stepY(currentPoint.y, 2))
    if (isValidPoint(twoStepPoint) && firstMove && findField(gameField, twoStepPoint).optionChessPiece.isEmpty) {
      list += twoStepPoint
    }
    val crossRightPoint: Point = Point(stepX(currentPoint.x, 1), stepY(currentPoint.y, 1))
    if (isValidPoint(crossRightPoint) && findField(gameField, crossRightPoint).optionChessPiece.isDefined) {
      list += crossRightPoint
    }
    val crossLeftPoint: Point = Point(stepCrossLeftX(currentPoint.x, 1), stepCrossLeftY(currentPoint.y, 1))
    if (isValidPoint(crossLeftPoint) && findField(gameField, crossLeftPoint).optionChessPiece.isDefined) {
      list += crossLeftPoint
    }

    firstMove = false
    list.toList
  }

  private def stepX(position: Int, number: Int): Int = {if (color.equals('w')) position + number else position - number}
  private def stepY(position: Int, number: Int): Int = {if (color.equals('w')) position - number else position + number}

  //for specific crossLeftMove
  private def stepCrossLeftX(position: Int, number: Int): Int = {if (color.equals('w')) position - number else position + number}
  private def stepCrossLeftY(position: Int, number: Int): Int = {if (color.equals('w')) position - number else position + number}

  override def toString: String = {
    color match {
      case 'w' => "♙"
      case 'b' => "♟"
      case _ => "P" + color
    }
  }
}