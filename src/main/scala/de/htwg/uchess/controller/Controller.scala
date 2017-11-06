package de.htwg.uchess.controller

import de.htwg.uchess.util.Point

trait Controller {

  def startGame()

  def getField()

  def getStatusMessage()

  def move(start: Point, target: Point)

  def checkWin()

  def reset()

  def exitGame()
}
