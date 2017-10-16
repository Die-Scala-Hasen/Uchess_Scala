package controller

import scala.swing.{Point, Publisher}


trait Controller extends Publisher {

  def startGame()

  def getField()

  def getStatusMessage()

  def move(start: Point, target: Point)

  def checkWin()

  def reset()

  def exitGame()
}
