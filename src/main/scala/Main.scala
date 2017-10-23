
import model.impl.{GameField}


object Main {
  def main(args: Array[String]) {

    val view = GameField(8)

    println(view.toString())

  }
}