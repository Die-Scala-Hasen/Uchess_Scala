package de.htwg.uchess.view.gui

import java.awt.{Color, Dimension}

import scala.swing.{GridPanel, Label}

class NumberSideBarPanel extends GridPanel(8, 1){
  background = Color.WHITE
  for(value <- 0 until this.rows){
    contents += new Label {
      preferredSize = new Dimension(60, 60)
      text = (value + 1).toString
    }
  }
}
