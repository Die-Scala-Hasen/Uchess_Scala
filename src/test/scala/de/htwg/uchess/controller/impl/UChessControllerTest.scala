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


    "handle a invalid command" in {
      controller ! RestartCmd
      controller ! "Invalide Command String"
      Thread.sleep(200) // wait for actor message receive

      testInfo match {
        case ii: InvalidInfo =>
          ii.message shouldBe "Invalid Command"
      }
    }

    "handle selecting a figure" in {

      controller ! RestartCmd
      controller ! MoveCmd(Point(4, 6))
      Thread.sleep(200) // wait for actor message receive

      testInfo match {
        case ui: UpdateInfo =>
          ui.status shouldBe "One Figure is selected"
          ui.selfPos shouldBe Point(4, 6)
          ui.possibleMoves should contain(Point(4, 4))
          ui.possibleMoves should contain(Point(4, 5))
      }
    }

    "handle move a figure" in {

      controller ! RestartCmd
      controller ! MoveCmd(Point(4, 6))
      controller ! MoveCmd(Point(4, 4))
      Thread.sleep(200) // wait for actor message receive

      testInfo match {
        case ui: UpdateInfo =>
          ui.status shouldBe "Figure was moved successfully."
          ui.selfPos shouldBe null
          ui.possibleMoves shouldBe null
      }
    }

    "handle an invalid move of figure" in {

      controller ! RestartCmd
      controller ! MoveCmd(Point(4, 6))
      controller ! MoveCmd(Point(4, 3))
      Thread.sleep(200) // wait for actor message receive

      testInfo match {
        case ui: UpdateInfo =>
          ui.status shouldBe "Invalid move!"
          ui.selfPos shouldBe null
          ui.possibleMoves shouldBe null
      }
    }


    "handle game over" in {

      controller ! RestartCmd
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

    "restart game" in {
      controller ! RestartCmd
      Thread.sleep(200) // wait for actor message receive

      testInfo match {
        case ui: UpdateInfo =>
          ui.status shouldBe "Welcome to UChess"
          ui.selfPos shouldBe null
      }
    }

    "quit game" in {
      controller ! QuitCmd

      Thread.sleep(200) // wait for actor message receive
      system.isTerminated shouldBe true
    }
  }
}
