package de.htwg.uchess.util

object GameFieldPoint {
  def apply(x: String, y: Int): Point = {
    Point(encodeX(x), encodeY(y))
  }

  val xLetterToInternalId = Map("a" -> 0, "b" -> 1, "c" -> 2, "d" -> 3, "e" -> 4, "f" -> 5, "g" -> 6, "h" -> 7)
  val yNumberToInternalId = Map(1 -> 0, 2 -> 1, 3 -> 2, 4 -> 3, 5 -> 4, 6 -> 5, 7 -> 6, 8 -> 7)

  private def encodeX(x: String): Int = {
    if (xLetterToInternalId.keySet.contains(x)) {
      xLetterToInternalId(x)
    } else {
      Int.MinValue
    }
  }

  private def encodeY(y: Int): Int = {
    if (yNumberToInternalId.keySet.contains(y)) {
      yNumberToInternalId(y)
    } else {
      Int.MinValue
    }
  }
}