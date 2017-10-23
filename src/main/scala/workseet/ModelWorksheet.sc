import model.impl.{Field, GameField, King}
import util.Point

object ModelWorksheet {

  val l:List[Int] =List(1,2,3,4,5,6,7,8)

  for (i <- l) {
    println(i)
  }

  l.size
  l.length

//  val x: Int = 8
//  val y: Int = 8
//
//  val view = new GameField(x, y)
//  view.drawGameField()

//  val p: Point = new Point(1, 5)
//  val king: King = King(1, 5, 'w')
//
//  val f1: Field = Field(p)
//  val f2: Field = Field(p,Some(king))
}

// Own CaseClass Example
//object Test extends App {
//
//  val k = King(1, 2, 'w')
//
//  case class T(i: Int)
//
//  println(T(1).isInstanceOf[Product])
//
//  val c = Case(1, "")
//  val c1 =  c.copy(s = "hallo")
//  println(c1)
//}
//
//class Case(val i: Int, val s: String) extends Product {
//
//  def copy(i: Int = this.i, s: String = this.s) = new Case(i, s)
//
//  override def productElement(n: Int): Any = n match {
//    case 0 => i
//    case 1 => s
//    case _ => throw new IndexOutOfBoundsException("")
//  }
//
//  override def productArity(): Int = 2
//
//  override def canEqual(that: Any): Boolean = that.isInstanceOf[Case]
//
//  override def toString():String = {
//    s"Case($i, $s)"
//  }
//}
//
//object Case {
//  def apply(i: Int, s: String) = new Case(i, s)
//}
