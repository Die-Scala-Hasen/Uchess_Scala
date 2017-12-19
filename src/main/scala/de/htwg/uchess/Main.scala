package de.htwg.uchess

import de.htwg.uchess.view.Tui
import de.htwg.uchess.controller.impl.UChessController

object Main {
  def main(args: Array[String]) {

    val c = new UChessController(8)
    val tui =  new Tui(c)


    tui.printGameField
    while(tui.processInputLine(scala.io.StdIn.readLine())) {
        tui.printGameField
    }

    //c.akkaTest()
    //println(gamefield.toString())

  }
}
