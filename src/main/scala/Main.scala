
import controller.impl.UChessController
import model.impl.GameField
import akka.actor.Actor
import akka.actor.ActorSystem
import akka.actor.Props

object Main {
  def main(args: Array[String]) {

    val view = GameField(8)
    val c = new UChessController()
    c.akkaTest()
    println(view.toString())

  }
}