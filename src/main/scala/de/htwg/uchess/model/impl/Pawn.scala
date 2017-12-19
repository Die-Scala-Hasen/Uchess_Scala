package de.htwg.uchess.model.impl

import scala.collection.mutable.ListBuffer

import de.htwg.uchess.model.Piece
import de.htwg.uchess.util.Point

case class Pawn(color: Char, var firstMove: Boolean = true) extends Piece {

  override def possibleMove(gameField: Map[Point, Piece], currentPoint: Point): List[Point] = {
    val list = new ListBuffer[Point]

    val oneStepPoint: Point = Point(currentPoint.x, stepY(currentPoint.y, 1))
    if (isValidPoint(oneStepPoint) && gameField.get(oneStepPoint).isEmpty) {
      list += oneStepPoint
    }
    val twoStepPoint: Point = Point(currentPoint.x, stepY(currentPoint.y, 2))
    if (isValidPoint(twoStepPoint) && firstMove && gameField.get(oneStepPoint).isEmpty && gameField.get(twoStepPoint).isEmpty) {
      list += twoStepPoint
    }
    val crossRightPoint: Point = Point(stepX(currentPoint.x, 1), stepY(currentPoint.y, 1))
    if (isValidPoint(crossRightPoint) && gameField.get(crossRightPoint).isDefined && gameField(crossRightPoint).color != color) {
      list += crossRightPoint
    }
    val crossLeftPoint: Point = Point(stepCrossLeftX(currentPoint.x, 1), stepCrossLeftY(currentPoint.y, 1))
    if (isValidPoint(crossLeftPoint) && gameField.get(crossLeftPoint).isDefined && gameField(crossLeftPoint).color != color) {
      list += crossLeftPoint
    }
    list.toList
  }

  private def stepX(position: Int, number: Int): Int = {if (color.equals('w')) position + number else position - number}
  private def stepY(position: Int, number: Int): Int = {if (color.equals('w')) position - number else position + number}

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