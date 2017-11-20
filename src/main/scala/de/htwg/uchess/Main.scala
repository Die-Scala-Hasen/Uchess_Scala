package de.htwg.uchess

import de.htwg.uchess.view.Tui
import de.htwg.uchess.controller.impl.UChessController
import de.htwg.uchess.model.impl.GameField
import de.htwg.uchess.util.Point

object Main {
  def main(args: Array[String]) {

    val gamefield = GameField(8)
    val c = new UChessController(gamefield)
    val tui =  new Tui(c)
    //c.akkaTest()
    //println(gamefield.toString())

  }
}
