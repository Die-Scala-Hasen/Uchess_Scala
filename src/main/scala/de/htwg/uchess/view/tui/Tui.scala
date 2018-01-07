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
      case input => handleMove(input)
    }
  }

  def handleMove(line: String) = {
    val r = """(([a-hA-H])([1-8]) ([a-hA-H])([1-8]))""".r
    val list = r.findAllIn(line).toList
    if (list.nonEmpty) {
      try {
        val src = GameFieldPoint(list.head.substring(0, 1), list.head.substring(1, 2).toInt)
        val dst = GameFieldPoint(list.head.substring(3, 4), list.head.substring(4, 5).toInt)
        controller ! MoveCmd(src, dst)
      } catch {
        case _: NoSuchElementException => println("Invalid command!")
      }
    }else {
      println("Invalid command!")
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
    println("Please enter a command: q - quit, r - restart, coordinates to move")
  }

  def printGameField(gameField: GameField): Unit = {
    println(gameField.toString)
  }
}
