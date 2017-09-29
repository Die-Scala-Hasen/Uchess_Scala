package Model

import Model.impl.{GameField, Pawn}

/**
  * Created by mbo on 29.09.2017.
  */
object ModelTest {
  def main(args: Array[String]): Unit = {


    val view = new GameField()
    view.drawGameField()

  }



}
