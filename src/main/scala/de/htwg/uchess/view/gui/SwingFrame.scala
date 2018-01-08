package de.htwg.uchess.view.gui

import akka.actor.ActorSelection
import de.htwg.uchess.controller.impl._

import scala.swing._
import scala.swing.event.Key

class SwingFrame(controller: ActorSelection) extends Frame {

  menuBar = new MenuBar {
    contents += new Menu("File") {
      mnemonic = Key.G
      contents += new MenuItem(Action("New") {
        controller ! RestartCmd
      })
      contents += new MenuItem(Action("Quit") {
        controller ! QuitCmd
      })
    }
  }

  val letterTopBarPanel = new LetterTopBarPanel
  val numberSideBarPanel = new NumberSideBarPanel
  val statusPanel = new StatusBottomBarPanel
  val gamePanel = new GamePanel(controller)

  contents = new BorderPanel {

    layout(letterTopBarPanel) = BorderPanel.Position.North
    layout(numberSideBarPanel) = BorderPanel.Position.West
    layout(gamePanel) = BorderPanel.Position.Center
    layout(statusPanel) = BorderPanel.Position.South

  }

  title = "UChess - MPS - WS17/18"
  peer.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE)
  size = new Dimension(800, 800)
  visible = true

  def update(info: Info): Unit = {
    gamePanel.update(info)

    info match {
      case gi: GameoverInfo =>
        statusPanel.setStatus(gi.status)
        InfoDialog.showGameOver(contents.head)
        controller ! RestartCmd
      case ui: UpdateInfo =>
        statusPanel.setStatus(ui.status)
    }
  }

}
