package de.htwg.uchess.view.gui

import java.awt.{Color, Dimension}
import javax.swing.ImageIcon

import akka.actor.ActorSelection
import de.htwg.uchess.controller.impl.{Info, MoveCmd, UpdateInfo}
import de.htwg.uchess.model.impl.GameField
import de.htwg.uchess.util.{PieceButton, Point}

import scala.collection.mutable.ListBuffer
import scala.swing.event.ButtonClicked
import scala.swing.GridPanel

class GamePanel(controller: ActorSelection) extends GridPanel(0, 8) {

  val blackFieldColor = new Color(185, 122, 87)
  val whiteFieldColor = new Color(239, 227, 175)

  private val lightBlue = Color.decode("#B8CFE5")

  private val buttons = new ListBuffer[PieceButton]()

  initPieceButtons()
  colorizeBoard()
  addActionListenerToBtns()
  drawIconBoard()

  private def initPieceButtons() = {
    buttons += new PieceButton(Some("bTower"), Point(0, 0))
    buttons += new PieceButton(Some("bKnight"), Point(1, 0))
    buttons += new PieceButton(Some("bBishop"), Point(2, 0))
    buttons += new PieceButton(Some("bQueen"), Point(3, 0))
    buttons += new PieceButton(Some("bKing"), Point(4, 0))
    buttons += new PieceButton(Some("bBishop"), Point(5, 0))
    buttons += new PieceButton(Some("bKnight"), Point(6, 0))
    buttons += new PieceButton(Some("bTower"), Point(7, 0))

    for (i <- 0 to 7)
      buttons += new PieceButton(Some("bPawn"), Point(i, 1))
    for (i <- 0 to 7)
      buttons += new PieceButton(None, Point(i, 2))
    for (i <- 0 to 7)
      buttons += new PieceButton(None, Point(i, 3))
    for (i <- 0 to 7)
      buttons += new PieceButton(None, Point(i, 4))
    for (i <- 0 to 7)
      buttons += new PieceButton(None, Point(i, 5))

    for (i <- 0 to 7)
      buttons += new PieceButton(Some("wPawn"), Point(i, 6))

    buttons += new PieceButton(Some("wTower"), Point(0, 7))
    buttons += new PieceButton(Some("wKnight"), Point(1, 7))
    buttons += new PieceButton(Some("wBishop"), Point(2, 7))
    buttons += new PieceButton(Some("wQueen"), Point(3, 7))
    buttons += new PieceButton(Some("wKing"), Point(4, 7))
    buttons += new PieceButton(Some("wBishop"), Point(5, 7))
    buttons += new PieceButton(Some("wKnight"), Point(6, 7))
    buttons += new PieceButton(Some("wTower"), Point(7, 7))
  }

  private def setBtnIcon(btn: PieceButton, icon: String): Unit = {
    try {
      val image = new ImageIcon(this.getClass.getResource(icon)).getImage
      btn.icon = new ImageIcon(image)
    } catch {
      case ex: Exception =>
        System.out.println(ex)
    }
  }

  private def drawIconBoard() = {
    for (n <- 0 to 63) {
      contents += buttons(n)
      buttons(n).figure match {
        case Some(f) => setBtnIcon(buttons(n), "resources/" + f + ".png")
        case None => buttons(n).icon = null
      }
    }
  }

  private def colorizeBoard() = {
    for (x <- 0 to 7) {
      if (x % 2 == 0) {
        buttons(x).background = whiteFieldColor
        buttons(x + 16).background = whiteFieldColor
        buttons(x + 32).background = whiteFieldColor
        buttons(x + 48).background = whiteFieldColor

        buttons(x + 9).background = whiteFieldColor
        buttons(x + 25).background = whiteFieldColor
        buttons(x + 41).background = whiteFieldColor
        buttons(x + 57).background = whiteFieldColor

        buttons(x + 8).background = blackFieldColor
        buttons(x + 24).background = blackFieldColor
        buttons(x + 40).background = blackFieldColor
        buttons(x + 56).background = blackFieldColor
      } else {
        buttons(x).background = blackFieldColor
        buttons(x + 16).background = blackFieldColor
        buttons(x + 32).background = blackFieldColor
        buttons(x + 48).background = blackFieldColor
      }
    }
  }

  private def addActionListenerToBtns() = {
    for (x <- 0 to 63) {
      buttons(x).preferredSize = new Dimension(60, 60)
      buttons(x).reactions += {
        case _: ButtonClicked => controller ! MoveCmd(buttons(x).pos)
      }
    }
  }

  def update(info: Info): Unit = {
//    updateGameField(info.gameField)
    info match {
      case ui: UpdateInfo =>
        // mark selected field
        if (ui.selfPos != null) {
          for(bt <- buttons){
            if(bt.pos.equals(ui.selfPos)){
              bt.background = lightBlue
            }
          }
        }
        // mark possible moves
        if (ui.possibleMoves != null) {
          ui.possibleMoves.foreach { field =>
            for(bt <- buttons){
              if(field.equals(bt.pos)){
                bt.background = lightBlue
              }
            }
          }
        }
      case _ =>
    }
  }

//  private def updateGameField(gamefield: GameField): Unit = ???
}
