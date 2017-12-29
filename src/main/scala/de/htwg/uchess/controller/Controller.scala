package de.htwg.uchess.controller

import de.htwg.uchess.model.impl.GameField
import de.htwg.uchess.util.Point

trait Controller {
  def gameLock(): Boolean

  def startGame()

  def getField(): GameField

  def getWinner(): String

  def getStatusMessage()

  def move(start: Point, target: Point): Boolean

  def checkWin(): Unit

  def reset()

  def exitGame()
}
