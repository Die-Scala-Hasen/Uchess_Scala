package de.htwg.uchess.view

import akka.actor.Actor
import de.htwg.uchess.controller.impl.UChessController
import de.htwg.uchess.util.Point

class Tui(controller: UChessController){ // extends Actor{

  printGameField
  controller.move(Point(1,6),Point(1,4))
  printGameField
  controller.move(Point(0,1),Point(0,2))
  printGameField
  controller.move(Point(1,4),Point(1,3))
  printGameField
  controller.move(Point(0,2),Point(0,3))
  printGameField
  controller.move(Point(3,6),Point(3,5))
  printGameField
  controller.move(Point(2,7),Point(7,2))
  printGameField
  controller.move(Point(7,2),Point(6,3))
  printGameField
  controller.move(Point(6,3),Point(7,4))
  printGameField
  controller.move(Point(7,4),Point(5,2))
  printGameField
  controller.move(Point(3,1),Point(3,2))
  printGameField
  controller.move(Point(2,0),Point(7,5))
  printGameField
  controller.move(Point(0,0),Point(0,2))
  printGameField
  controller.move(Point(0,2),Point(1,2))
  printGameField
  controller.move(Point(1,2),Point(1,3))
  printGameField
  controller.move(Point(1,0),Point(2,2))
  printGameField

  def printGameField: Unit = {
    println(controller.gamefield.toString)
  }

  /*override def receive = {
    case "exit" => println("Hallo Exit Marcel rockt Peace")
    case _ => println("Default case")
  }*/
}
