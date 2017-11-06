package de.htwg.uchess

import de.htwg.uchess.controller.impl.UChessController
import de.htwg.uchess.model.impl.GameField

object Main {
  def main(args: Array[String]) {

    val view = GameField(8)
    val c = new UChessController()
    c.akkaTest()
    println(view.toString())

  }
}
