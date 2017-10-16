package Model

import Model.impl.{GameField, Pawn}

/**
  * Created by mbo on 29.09.2017.
  */
object ModelTest {
  def main(args: Array[String]): Unit = {

    val x: Int = 8
    val y: Int = 8

    val view = new GameField(x,y)
    view.drawGameField()

  }



}
