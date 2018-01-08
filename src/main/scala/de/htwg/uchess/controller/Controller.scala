package de.htwg.uchess.controller

import de.htwg.uchess.model.impl.GameField
import de.htwg.uchess.util.Point

trait Controller {
  def getField(): GameField

  def doMove(target: Point): Unit

  def checkWin(): Unit

  def reset(): Unit

  def exitGame(): Unit
}
