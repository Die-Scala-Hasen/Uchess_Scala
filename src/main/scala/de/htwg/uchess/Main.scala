package de.htwg.uchess

import akka.actor.{ActorSystem, Props}
import de.htwg.uchess.view.{Gui, Tui}
import de.htwg.uchess.controller.impl.{StartMessage, UChessController}


object Main {
  def main(args: Array[String]) {

    val c = new UChessController(8)
    val gui = new Gui(c)

  val tui = new Tui(c)
    tui.printGameField
   while (tui.processInputLine(scala.io.StdIn.readLine())) {
      tui.printGameField
    }


  }
}
