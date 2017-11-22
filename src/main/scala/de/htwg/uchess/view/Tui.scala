package de.htwg.uchess.view

import akka.actor.Actor
import de.htwg.uchess.controller.impl.UChessController
import de.htwg.uchess.util.{GameFieldPoint, Point}

class Tui(controller: UChessController){ // extends Actor{

  printGameField
  controller.move(GameFieldPoint("b",7),GameFieldPoint("b",5))
  printGameField
  controller.move(GameFieldPoint("a",2),GameFieldPoint("a",3))
  printGameField
  controller.move(GameFieldPoint("b",5),GameFieldPoint("b",4))
  printGameField
  controller.move(GameFieldPoint("a",3),GameFieldPoint("a",4))
  printGameField
  controller.move(GameFieldPoint("d",7),GameFieldPoint("d",6))
  printGameField
  controller.move(GameFieldPoint("c",8),GameFieldPoint("h",3))
  printGameField
  controller.move(GameFieldPoint("h",3),GameFieldPoint("g",4))
  printGameField
  controller.move(GameFieldPoint("g",4),GameFieldPoint("h",5))
  printGameField
  controller.move(GameFieldPoint("h",5),GameFieldPoint("f",3))
  printGameField
  controller.move(GameFieldPoint("d",2),GameFieldPoint("d",3))
  printGameField
  controller.move(GameFieldPoint("c",1),GameFieldPoint("h",6))
  printGameField
  controller.move(GameFieldPoint("a",1),GameFieldPoint("a",3))
  printGameField
  controller.move(GameFieldPoint("a",3),GameFieldPoint("c",3))
  printGameField
  controller.move(GameFieldPoint("c",3),GameFieldPoint("c",6))
  printGameField
  controller.move(GameFieldPoint("b",1),GameFieldPoint("c",3))
  printGameField

  def printGameField: Unit = {
    println(controller.gamefield.toString)
  }

  /*override def receive = {
    case "exit" => println("Hallo Exit Marcel rockt Peace")
    case _ => println("Default case")
  }*/
}
