package de.htwg.uchess.View

import akka.actor.Actor
import de.htwg.uchess.controller.impl.UChessController
import de.htwg.uchess.util.Point

class Tui(controller: UChessController){ // extends Actor{

  printGameField
  controller.move(Point(0,1),Point(0,2))
  printGameField

  def printGameField: Unit = {
    println(controller.gamefield.toString)
  }

  /*override def receive = {
    case "exit" => println("Hallo Exit Marcel rockt Peace")
    case _ => println("Default case")
  }*/
}
