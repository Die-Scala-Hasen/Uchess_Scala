package de.htwg.uchess.view

import akka.actor.Actor
import de.htwg.uchess.controller.impl.UChessController
import de.htwg.uchess.util.{GameFieldPoint, Point}

class Tui(c: UChessController){ // extends Actor{

  def processInputLine(line: String): Boolean = {

    val r = """(([a-hA-H])([1-8]) ([a-hA-H])([1-8]))""".r

    if(line.equals("q"))
      return false

    val list = r.findAllIn(line).toList
    if(list.nonEmpty) {
      val src = GameFieldPoint(list(0).substring(0,1),list(0).substring(1,2).toInt)
      val dst = GameFieldPoint(list(0).substring(3,4),list(0).substring(4,5).toInt)
      c.move(src,dst)
    }else{
      print("Invalid Input!")
    }

   return  true
  }


 /*
  printGameField
  c.move(GameFieldPoint("b",7),GameFieldPoint("b",5))
  printGameField
  c.move(GameFieldPoint("a",2),GameFieldPoint("a",3))
  printGameField
  c.move(GameFieldPoint("b",5),GameFieldPoint("b",4))
  printGameField
  c.move(GameFieldPoint("a",3),GameFieldPoint("a",4))
  printGameField
  c.move(GameFieldPoint("d",7),GameFieldPoint("d",6))
  printGameField
  c.move(GameFieldPoint("c",8),GameFieldPoint("h",3))
  printGameField
  c.move(GameFieldPoint("h",3),GameFieldPoint("g",4))
  printGameField
  c.move(GameFieldPoint("g",4),GameFieldPoint("h",5))
  printGameField
  c.move(GameFieldPoint("h",5),GameFieldPoint("f",3))
  printGameField
  c.move(GameFieldPoint("d",2),GameFieldPoint("d",3))
  printGameField
  c.move(GameFieldPoint("c",1),GameFieldPoint("h",6))
  printGameField
  c.move(GameFieldPoint("a",1),GameFieldPoint("a",3))
  printGameField
  c.move(GameFieldPoint("a",3),GameFieldPoint("c",3))
  printGameField
  c.move(GameFieldPoint("c",3),GameFieldPoint("c",6))
  printGameField
  c.move(GameFieldPoint("b",1),GameFieldPoint("c",3))
  printGameField*/

  def printGameField: Unit = {
    println(c.gamefield.toString)
  }

  /*override def receive = {
    case "exit" => println("Hallo Exit Marcel rockt Peace")
    case _ => println("Default case")
  }*/
}
