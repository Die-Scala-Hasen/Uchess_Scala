//package de.htwg.uchess.view.gui
//
//import akka.actor.{Actor, ActorSelection}
//import de.htwg.uchess.controller.impl.{Info, InvalidInfo}
//import de.htwg.uchess.view.Gui
//
//class SwingActor extends Actor {
//  val controller: ActorSelection = context.system.actorSelection("user/controller")
//  val gui = new Gui(controller)
//
//  override def receive: Receive = {
//    case info: InvalidInfo => println(info.message)
//    case info: Info => gui.update(info)
//  }
//}
