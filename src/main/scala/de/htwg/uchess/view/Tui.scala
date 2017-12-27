package de.htwg.uchess.view


import akka.actor.Actor
import de.htwg.uchess.controller.impl.UChessController
import de.htwg.uchess.util.GameFieldPoint

class Tui(c: UChessController) {

//  val actor = new Actor {
//    override def receive: Receive = {
//      case "exit" => actorTest
//      case _ => println("Default case")
//    }
//  }

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

  def actorTest: Unit = {
    println("Hallo Exit Marcel rockt Peace")
  }


}
