package de.htwg.uchess.view.tui

import akka.actor.{Actor, ActorSelection}
import de.htwg.uchess.controller.impl._
import de.htwg.uchess.model.impl.GameField
import de.htwg.uchess.util.GameFieldPoint

class Tui extends Actor {

  private val controller: ActorSelection = context.system.actorSelection("user/controller")

  override def receive: Receive = {
    case info: GameoverInfo => printGameover(info)
    case info: UpdateInfo => printUpdate(info)
    case input: String => processInputLine(input)
  }

  def processInputLine(line: String) = {
    line.toLowerCase match {
      case "q" => controller ! QuitCmd
      case "r" => controller ! RestartCmd
      case select if line.startsWith("s") && line.length == 3 => handleMove(select)
      case move if line.startsWith("m") && line.length == 3 => handleMove(move)
      case _ => print("Invalid input!")
    }
  }

  def handleMove(line: String) = {
      try {
        val src = GameFieldPoint(line.charAt(1).toString, line.charAt(2).toString.toInt)
        controller ! MoveCmd(src)
      } catch {
        case _: NumberFormatException => println("Invalid command!")
      }
  }

  private def printGameover(info: GameoverInfo) = {
    printGameField(info.gameField)
    println(info.status)
    println("Please enter a command: q - quit, r - restart")
  }

  private def printUpdate(info: UpdateInfo) = {
    printGameField(info.gameField)
    println(info.status)
    println("Please enter a command: q - quit, r - restart, s+coordinates to select a figure (example: sc7), m+coordinates to move (example:mc6)")
  }

  def printGameField(gameField: GameField): Unit = {
    println(gameField.toString)
  }
}
