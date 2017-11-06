package de.htwg.uchess.util

case class Point(var x: Int, var y: Int) {
  override def toString(): String = {
    s"Point($x, $y)"
  }
}
