package de.htwg.uchess.view.gui

import akka.actor.{Actor, ActorSelection}
import de.htwg.uchess.controller.impl.{Info, InvalidInfo}

class SwingActor extends Actor {
  val controller: ActorSelection = context.system.actorSelection("user/controller")
  val frame = new SwingFrame(controller)

  override def receive: Receive = {
    case info: InvalidInfo => println(info.message)
    case info: Info => frame.update(info)
  }
}
