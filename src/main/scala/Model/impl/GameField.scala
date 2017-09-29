package Model.impl

import scala.Array.ofDim

/**
  * Created by mbo on 29.09.2017.
  */
class GameField {
  var gameField = ofDim[Int](8,8)


  def initialGameField(): Unit = {
    for(x <- 0 until 8; y <- 0 until 8) {
      gameField(x)(y) = 0
    }
  }

  def drawGameField(): Unit = {
    for(x <- 0 until 8) {
      for(y <- 0 until 8) {
        print("0 ")
      }
      println()
    }
  }


}
