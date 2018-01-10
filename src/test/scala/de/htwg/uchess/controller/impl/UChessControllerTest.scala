package de.htwg.uchess.controller.impl

import akka.actor.{Actor, ActorSystem, Props}
import de.htwg.uchess.util.Point
import org.scalatest.WordSpec
import org.scalatest.Matchers

class UChessControllerTest extends WordSpec with Matchers {

  var testInfo: Info = _

  class TestUI extends Actor {
    override def receive: Receive = {
      case info: Info => testInfo = info
    }
  }

  "A new UChessController as part of an Actorsystem" should {
    val system: ActorSystem = ActorSystem("UChessTestSystem")
    system.actorOf(Props(new TestUI), name = "view$testUI")
    val controller = system.actorOf(Props[UChessController], "controller")


    "restart game" in {
      controller ! RestartCmd
      Thread.sleep(200) // wait for actor message receive
      testInfo match {
        case ui: UpdateInfo =>
          ui.status shouldBe "Welcome to UChess"
          ui.selfPos shouldBe null
      }
    }

    "handle game over" in {
      controller ! MoveCmd(Point(4, 6))
      controller ! MoveCmd(Point(4, 4))
      controller ! MoveCmd(Point(4, 1))
      controller ! MoveCmd(Point(4, 3))
      controller ! MoveCmd(Point(3, 7))
      controller ! MoveCmd(Point(6, 4))
      controller ! MoveCmd(Point(4, 0))
      controller ! MoveCmd(Point(4, 1))
      controller ! MoveCmd(Point(6, 4))
      controller ! MoveCmd(Point(6, 3))
      controller ! MoveCmd(Point(2, 1))
      controller ! MoveCmd(Point(2, 3))
      controller ! MoveCmd(Point(6, 3))
      controller ! MoveCmd(Point(4, 1))

      Thread.sleep(200) // wait for actor message receive
      testInfo match {
        case gi: GameoverInfo =>
          gi.status shouldBe "White got the chicken dinner"
      }
    }
  }
}
