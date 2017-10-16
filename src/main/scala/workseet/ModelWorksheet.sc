import model.impl.GameField

object ModelWorksheet{

  val x: Int = 8
  val y: Int = 8

  val view = new GameField(x,y)
  view.drawGameField()
}