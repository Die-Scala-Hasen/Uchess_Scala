package de.htwg.uchess.controller.impl

import de.htwg.uchess.model.impl.GameField
import de.htwg.uchess.util.Point


trait Info {
  val gameField: GameField
}

case class InvalidInfo(gameField: GameField, message: String) extends Info

case class GameoverInfo(gameField: GameField, status: String) extends Info

case class UpdateInfo(gameField: GameField, possibleMoves: List[Point], selfPos: Point, status: String) extends Info
