package de.htwg.uchess.controller

import de.htwg.uchess.model.impl.GameField
import de.htwg.uchess.util.Point

trait Controller {

  def startGame()

  def getField(): GameField

  def getStatusMessage()

  def move(start: Point, target: Point): Boolean

  def checkWin()

  def reset()

  def exitGame()
}
