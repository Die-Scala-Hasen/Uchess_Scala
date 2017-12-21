package de.htwg.uchess.controller

import de.htwg.uchess.util.Point

trait Controller {

  def startGame()

  def getField()

  def getStatusMessage()

  def move(start: Point, target: Point): Boolean

  def checkWin()

  def reset()

  def exitGame()
}
