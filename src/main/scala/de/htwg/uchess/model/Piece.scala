package de.htwg.uchess.model

import scala.annotation.tailrec
import scala.collection.mutable.ListBuffer

import de.htwg.uchess.model.impl.Knight
import de.htwg.uchess.util.Point

trait Piece {
  val color: Char

  def possibleMove(gameField: Map[Point, Piece], currentPoint: Point): List[Point]

  override def toString: String

  protected def internalMove(gameField: Map[Point, Piece], startPoint: Point, possibilities: List[(Int, Int)]): List[Point] = {
    def addValidOffset(p: Point, offset: (Int, Int)): Option[Point] = {
      val ret = Point(p.x + offset._1, p.y + offset._2)
      Some(ret).filter(isValidPoint)
    }

    val list = new ListBuffer[Point]

    @tailrec
    def rec(currentPoint: Point, possibilities: List[(Int, Int)]): List[Point] = possibilities match {
      case Nil => list.result()
      case offset :: tail =>
        addValidOffset(currentPoint, offset) match {
          case Some(point) =>
            gameField.get(point) match {
              case Some(piece) if piece.color != color =>
                list += point
                rec(startPoint, tail)

              case Some(_) => // else color == color
                rec(startPoint, tail)

              case None =>
                list += point
                rec(point, possibilities)
            }

          case None =>
            rec(startPoint, tail)
        }
    }

    rec(startPoint, possibilities)
  }

  protected def internalMoveSingleSteps(gameField: Map[Point, Piece], startPoint: Point, possibilities: List[(Int, Int)]): List[Point] = {
    def addValidOffset(p: Point, offset: (Int, Int)): Option[Point] = {
      val ret = Point(p.x + offset._1, p.y + offset._2)
      Some(ret).filter(isValidPoint)
    }

    val list = new ListBuffer[Point]

    @tailrec
    def rec(currentPoint: Point, possibilities: List[(Int, Int)]): List[Point] = possibilities match {
      case Nil => list.result()
      case offset :: tail =>
        addValidOffset(currentPoint, offset) match {
          case Some(point) =>
            gameField.get(point) match {
              case Some(piece) if piece.color != color =>
                if (this.isInstanceOf[Knight]) {
                  list += point
                  rec(startPoint, tail)
                } else {
                  list += point
                  list.result()
                }
              case Some(_) => // else color == color
                rec(startPoint, tail)

              case None =>
                list += point
                rec(startPoint, tail)
            }

          case None =>
            rec(startPoint, tail)
        }
    }

    rec(startPoint, possibilities)
  }

  def isValidPoint(pointToCheck: Point): Boolean = {
    var isValid: Boolean = false
    if (pointToCheck.x >= 0 && pointToCheck.x <= 7 && pointToCheck.y >= 0 && pointToCheck.y <= 7) {
      isValid = true
    }
    isValid
  }
}
