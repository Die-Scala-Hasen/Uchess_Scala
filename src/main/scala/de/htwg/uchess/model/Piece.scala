package de.htwg.uchess.model

import de.htwg.uchess.model.impl.{Field, GameField}
import de.htwg.uchess.util.Point

import scala.collection.mutable.ListBuffer


trait Piece{
  def possibleMove(figuresList: ListBuffer[Field]): List[Point]
  override def toString: String
}
