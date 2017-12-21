package de.htwg.uchess.view

import akka.actor.Actor
import de.htwg.uchess.controller.impl.UChessController
import de.htwg.uchess.util.GameFieldPoint

class Tui(c: UChessController) { // extends Actor{

  def processInputLine(line: String): Boolean = {

    val r = """(([a-hA-H])([1-8]) ([a-hA-H])([1-8]))""".r

    if (line.equals("q"))
      return false

    val list = r.findAllIn(line).toList
    if (list.nonEmpty) {
      val src = GameFieldPoint(list.head.substring(0, 1), list.head.substring(1, 2).toInt)
      val dst = GameFieldPoint(list.head.substring(3, 4), list.head.substring(4, 5).toInt)
      val move = c.move(src, dst)
      if (!move) {
        print("invalid move")
      }
    } else {
      print("Invalid Input!")
    }
    true
  }

  def printGameField: Unit = {
    println(c.printField())
  }

  /*override def receive = {
    case "exit" => println("Hallo Exit Marcel rockt Peace")
    case _ => println("Default case")
  }*/
}
