package de.htwg.uchess.view.gui

import javax.swing.{Icon, JOptionPane, UIManager}

import scala.swing.Dialog.showMessage
import scala.swing.Swing.EmptyIcon
import scala.swing.{Component, Dialog, Swing}


object InfoDialog {

  private def showOptions[A <: Enumeration](
                                             parent: Component = null,
                                             message: Any,
                                             title: String = UIManager.getString("OptionPane.titleText"),
                                             messageType: Dialog.Message.Value = Dialog.Message.Question,
                                             icon: Icon = EmptyIcon,
                                             entries: A,
                                             initial: A#Value): Option[A#Value] = {
    val r = JOptionPane.showOptionDialog(
      if (parent == null) null else parent.peer, message, title, 0,
      messageType.id, Swing.wrapIcon(icon),
      entries.values.toArray[AnyRef], initial)
    if (r < 0) None else Some(entries(r))
  }

  def showGameOver(frame: Component): Unit = {
      showMessage(frame, "Game Over")
  }
}
