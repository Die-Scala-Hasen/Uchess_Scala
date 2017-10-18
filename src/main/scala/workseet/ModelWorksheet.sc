import model.impl.{Field, GameField, King}
import util.Point

object ModelWorksheet {

//  val x: Int = 8
//  val y: Int = 8
//
//  val view = new GameField(x, y)
//  view.drawGameField()

  val p: Point = new Point(1, 5)
  val king: King = King(1, 5, 'w')

  val f1: Field = Field(p)
  val f2: Field = Field(p,Some(king))
}