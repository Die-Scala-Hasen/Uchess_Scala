package de.htwg.uchess.controller

import de.htwg.uchess.model.impl.GameField
import de.htwg.uchess.util.Point

trait Controller {
  def gameLock(): Boolean

  def getField(): GameField

  def getWinner(): String

  def handleMove(start: Point, target: Point): Unit

  def checkWin(): Unit

  def reset()

  def exitGame()
}
