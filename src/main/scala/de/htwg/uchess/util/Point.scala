package de.htwg.uchess.util

case class Point(x: Int, y: Int) {
  override def toString(): String = {
    "Point($x, $y)"
  }

  override def equals(obj: scala.Any): Boolean = {
    var check:Boolean = false
    obj match {
      case point: Point =>
        if (this.x == point.x && this.y == point.y) {
          check = true
        }
      case _ => check = false
    }
    check
  }
}
