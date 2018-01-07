package de.htwg.uchess

import akka.actor.{ActorRef, ActorSystem, Props}
import de.htwg.uchess.view.gui.SwingActor
import de.htwg.uchess.view.tui.Tui

trait ChessModule {
  def createUI()(implicit system: ActorSystem): Unit

  def createTUI()(implicit system: ActorSystem): ActorRef = system.actorOf(Props[Tui], "view$tui")

  def createGUI()(implicit system: ActorSystem): ActorRef = system.actorOf(Props[SwingActor], "view$gui")
}

trait OfflineModule extends ChessModule {
  var tui: ActorRef = _
  var gui: ActorRef = _

  override def createUI()(implicit system: ActorSystem): Unit = {
    tui = createTUI()
    gui = createGUI()
  }
}