package de.htwg.uchess.view.gui

import java.awt.{Color, Font}

import scala.swing.{GridPanel, Label}

class StatusBottomBarPanel extends GridPanel(2, 1) {

  background = Color.WHITE

  val arialFont = new Font("Arial", Font.CENTER_BASELINE, 12)

  val status: Label = new Label {
    font = arialFont
  }
  contents += status

  val turn: Label = new Label {
    font = arialFont
  }
  contents += turn

  def setStatus(game: String): Unit = status.text = "Status: " + game

  //  def setTurn(turn: String): Unit = this.turn.text = "Turn: " + turn
}
