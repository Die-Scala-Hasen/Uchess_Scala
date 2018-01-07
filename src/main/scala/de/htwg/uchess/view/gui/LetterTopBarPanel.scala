package de.htwg.uchess.view.gui

import java.awt.{Color, Dimension}

import scala.swing.{GridPanel, Label}

class LetterTopBarPanel extends GridPanel(1, 8) {
  private val cols = Array("A", "B", "C", "D", "E", "F", "G", "H")

  background = Color.WHITE
  contents += new Label
  for (value <- 0 until this.columns) {
    contents += new Label {
      preferredSize = new Dimension(60, 60)
      text = cols(value)
    }
  }

}
