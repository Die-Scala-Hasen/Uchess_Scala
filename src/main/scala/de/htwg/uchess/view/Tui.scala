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

  def printGameField: Unit = {
    println(controller.gamefield.toString)
  }

  /*override def receive = {
    case "exit" => println("Hallo Exit Marcel rockt Peace")
    case _ => println("Default case")
  }*/
}
