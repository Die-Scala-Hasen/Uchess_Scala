package View

import akka.actor.Actor
import akka.actor.ActorSystem
import akka.actor.Props

class Tui extends Actor{
  override def receive = {
    case "exit" => println("Hallo Exit Marcel rockt Peace")
    case _ => println("Default case")
  }
}
